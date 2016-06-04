/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;

import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.ambientlight.ServiceAmbientLight;
import com.sensor.distanceIr.ServiceDistanceIr5;
import com.sensor.humidity.ServiceHumidity;
import com.sensor.loadcell.chair.ServiceLoadCell4;
import com.sensor.loadcell.chair.ServiceLoadCell5;
import com.sensor.soundintensity.ServiceSoundIntensity;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author reto
 */
public class Activity implements MqttCallback {

    // Subscrib Pathways
    private static ServiceAmbientLight sal;     // Licht ein/aus
    private final static String SUBSCRIBE_SAL_VALUE = sal.getTopicValue();

    private static ServiceLoadCell4 slc4;          // auf Stuhl sitzen oder nicht
    private final static String SUBSCRIBE_SLC4_VALUE = slc4.getTopicValue();
    private static ServiceLoadCell5 slc5;          // auf Stuhl sitzen oder nicht
    private final static String SUBSCRIBE_SLC5_VALUE = slc5.getTopicValue();
    
    private static BedAgent bedA;                   // bed activity sitzen oder liegen
    private final static String SUBSCRIBE_BEDA_VALUE = bedA.getTopicValue();

    private static ServiceSoundIntensity ssi;   // Wasserhahn auf/zu
    private final static String SUBSCRIBE_SSI_VALUE = ssi.getTopicValue();

    private static ServiceDistanceIr5 sdir5;     // Fenster offen/geschlossen
    private final static String SUBSCRIBE_SDIR5_VALUE = sdir5.getTopicValue();

    private static ServiceHumidity sh;     // Fenster offen/geschlossen
    private final static String SUBSCRIBE_SH_VALUE = sh.getTopicValue();

    /*
   Es fehlt noch die Aktivity Strom ein/aus (zum Stom, kann man eindeutige Geräte anschliessen), Fenster auf/zu
     */
    private static String sensTyp = "";
    private static String sensUID = "";
    private static String sensRoom = "";
    private static String sensDate = "";

    private static String sensValue = null;
    private static String valueDate = "";
    
    
    private static String chairUIDgroup1 = "***1***2";
    private static String chair1Value;
    private static String chair2Value;
    private static String sensChairUIDgroup;
    private static String chairRoom;

    // Agent Pathways
    public final static String AGENT = "AGENT";
    public final static String CLIENT_ID = "Activity";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String PUBLISH_TOPIC = BASE_CONNECTION;

    private final MQTTCommunication communication;

    public Activity() throws MqttException {
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

            // Person sitzt auf einem Stuhl
            if (sendedSensTyp.equals("Load Cell")) {
                if (!sensUID.equals(sendedUID)) {
                    sensUID = sendedUID;
                    
                    // Person sitzt auf Stuhl 1
                    if (sensUID.equals("***1")){
                        sensChairUIDgroup = sensUID;
                        chair1Value = sensValue;
                        chairRoom = sendedRoom;
                    } 
                    if (sensUID.equals("***2")){
                        sensChairUIDgroup = sensChairUIDgroup + sensUID;
                        chair2Value = sensValue;
                    }
                        if (sensChairUIDgroup.equals(chairUIDgroup1)){
                            if(chair1Value.equals("sitzt") && chair2Value.equals("sitzt")){
                                 message.setPayload(("Bewohner sitzt im Raum " + chairRoom).getBytes());
                                 communication.publish(PUBLISH_TOPIC + "/" + "Message:", message);
                            }
                        }
                }
            }
            
           
            // Licht an/aus
            if (sendedSensTyp.equals("Ambient Light")) {
                if (!sensUID.equals(sendedUID)) {
                    sensUID = sendedUID;
                    System.out.println("Aktivity: Licht wurde " + sensValue + " / im Raum: " + sensRoom);
                }
            }

            // CO2 Gehalt im Raum
            if (sendedSensTyp.equals("CO2")) {
                if (!sensUID.equals(sendedUID)) {
                    sensUID = sendedUID;
                    System.out.println("Co2 Gehalt: " + sensValue + " / im Raum: " + sensRoom);
                }
            }

            // Fenster offen/geschlossen
            if (sendedSensTyp.equals("Distance IR")) {
                if (!sensUID.equals(sendedUID)) {
                    sensUID = sendedUID;
                    if (sensValue.equals("Passage Detected")) {
                        message.setPayload(("Fenster wurde geöffnet / im Raum: " + sensRoom).getBytes());
                        communication.publish(PUBLISH_TOPIC + "/" + "Message:", message);
                    } else if (sensValue.equals("No Passage")) {
                        message.setPayload(("Fenster wurde geschlossen / im Raum: " + sensRoom).getBytes());
                        communication.publish(PUBLISH_TOPIC + "/" + "Message:", message);
                    }
                }
            }

            if (sendedSensTyp.equals("Humidity")) {
                if (!sensUID.equals(sendedUID)) {

                }
            }

        }
        
         // Person sitzt oder liegt auf dem Bett
            if (string.endsWith("Belegt:")) {
                sensValue = new String(mm.getPayload());
                if (sensValue.equals("Ja")) {
                    message.setPayload(("Bewohner liegt auf dem Bett").getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Message:", message);   
                }
                if (sensValue.equals("Bewohner sitzt nur")){
                    message.setPayload(("Bewohner sitzt auf dem Bett").getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Message:", message);
                }
            }
        
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    public static void main(String[] args) throws MqttException {
        Activity service = new Activity();

        // Subscribe via Broker the LoadCell Sensor
        service.communication.subscribe(SUBSCRIBE_SLC4_VALUE, 0);
        service.communication.subscribe(SUBSCRIBE_SLC5_VALUE, 0);

        // Subscribe via Broker the Ambiente Light Sensor
        service.communication.subscribe(SUBSCRIBE_SAL_VALUE, 0);

        // Subscribe via Broker the SoundIntensity Sensor
        service.communication.subscribe(SUBSCRIBE_SSI_VALUE, 0);

        // Subscribe via Broker the Distance IR 5 Sensor
        service.communication.subscribe(SUBSCRIBE_SDIR5_VALUE, 0);

        // Subscribe via Broker the Humidity Sensor
        service.communication.subscribe(SUBSCRIBE_SH_VALUE, 0);
    }

}
