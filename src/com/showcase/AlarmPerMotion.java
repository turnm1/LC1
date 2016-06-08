/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.showcase;

import com.agent.*;
import at.sms.business.sdk.client.impl.DefaultSmsClient;
import at.sms.business.sdk.domain.TextMessage;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.motiondetector.ServiceMotiondetector;
import java.net.URI;
import mail.send.MailConfig;
import mail.send.MailConfigMete;
import mail.send.SendMail;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import sms.send.SmsConfig;

/**
 *
 * @author reto
 */
public class AlarmPerMotion implements MqttCallback {

    // Subscrib Pathways
    // Subscrib Pathways
    private static ServiceMotiondetector smd;
    private final static String SUBSCRIBE_SMD_VALUE = smd.getTopicValue();
    private final static String SUBRSCRIB_SMD_STATUS = smd.getTopicStatus();


    /*
   Es fehlt noch die Aktivity Strom ein/aus (zum Stom, kann man eindeutige Geräte anschliessen), Fenster auf/zu
     */
    private static String sensTyp = "";
    private static String sensUID = "";
    private static String sensRoom = "";
    private static String sensDate = "";

    private static String sensValue = null;
    private static String valueDate = "";

    // Agent Pathways
    public final static String AGENT = "AGENT";
    public final static String CLIENT_ID = "Message";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String PUBLISH_TOPIC = BASE_CONNECTION;

    private final MQTTCommunication communication;

    public AlarmPerMotion() throws MqttException {
        communication = new MQTTCommunication();
        MQTTParameters parameters = new MQTTParameters();
        parameters.setClientID(CLIENT_ID);
        parameters.setIsCleanSession(true);
        parameters.setIsLastWillRetained(true);
        parameters.setLastWillMessage(STATUS_CONNECTION_OFFLINE.getBytes());
        parameters.setLastWillQoS(1);
        parameters.setServerURIs(URI.create("tcp://127.0.0.1:1883"));
        parameters.setWillTopic(STATUS_TOPIC_CONNECTION);
        parameters.setMqttCallback(this);
        communication.connect(parameters);
        communication.publishActualWill(STATUS_CONNECTION_ONLINE.getBytes());
        // communication.subscribe(AGENT + "/#", 0);
        parameters.getLastWillMessage();
    }

    // Get the Topic Pathway for Agent
    public static String getTopic() {
        String value = BASE_CONNECTION + "/";
        return value;
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Ouups, lost connection to subscirptions");

    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {

        MqttMessage message = new MqttMessage();
        message.setRetained(true);
        message.setQos(0);

        if (string.endsWith("Value:")) {
            String[] res = string.split("/", 4);
            String sendedRoom = res[1];
            String sendedSensTyp = res[0];
            String sendedUID = res[2];

            valueDate = new String(mm.getPayload());
            String[] vd = valueDate.split("/", 2);
            sensValue = vd[0];

            if (sensValue.equals("Motion Detected")) {
                String text = "Es wurde eine unregelmässigkeit im Raum: " + sendedRoom + " in der Wohnung von Frau Brönnimann festgestellt, bitte erkundigen Sie sich, ob alle in Ordnung ist. Ihr INTRAAL Team";
                MailConfig mail = new MailConfig();
                mail.setText(text);
                new SendMail().sendMail(mail.getSmtpHost(), mail.getUsername(), mail.getPassword(), mail.getSenderAddress(), mail.getRecipientsAddress(), mail.getSubject(), mail.getText());
                
                MailConfigMete mail2 = new MailConfigMete();
                mail2.setText(text);
                new SendMail().sendMail(mail2.getSmtpHost(), mail2.getUsername(), mail2.getPassword(), mail2.getSenderAddress(), mail2.getRecipientsAddress(), mail2.getSubject(), mail2.getText());
                
                System.out.println("Sending Mail");
                
                try {
                    SmsConfig sc = new SmsConfig();
                    DefaultSmsClient smsClient = new DefaultSmsClient("turnamete@hotmail.com", "Mete08aal08", "https://api.websms.com");

                    long[] recipients = new long[]{sc.getTelenummer()};
                    sc.setMessage(text);
                    String messageContent = sc.getMessage();
                    TextMessage textMessage = new TextMessage(recipients, messageContent);

                    int maxSmsPerMessage = 1;
                    boolean test = false;

                    int statuscode = smsClient.send(textMessage, maxSmsPerMessage, test);
                    if (statuscode == 2000) {
                        System.out.println("Sending SMS successfully tested");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    public static void main(String[] args) throws MqttException {
        AlarmPerMotion service = new AlarmPerMotion();

        // Subscribe via Broker the Motion Sensor
        service.communication.subscribe(SUBSCRIBE_SMD_VALUE, 0);
        service.communication.subscribe(SUBRSCRIB_SMD_STATUS, 0);

    }

}
