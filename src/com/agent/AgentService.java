/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;


import com.tinkerforge.BrickletSoundIntensity;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.soundintensity.ServiceSoundIntensity;
import com.sensor.temperaturIr.ServiceTemperaturIr;


import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author reto
 */
public class AgentService implements MqttCallback {

    // Subscrib Pathways
    private static  ServiceSoundIntensity ssi;
    private final static String SUBSCIRBE_SSI = ssi.getTopic();
    private static  ServiceTemperaturIr stir;
    private final static String SUBSCIRBE_STEMPIR = stir.getTopic();
    
    // Agent Pathways
    public final static String AGENT = "AGENT"; 
    public final static String CLIENT_ID = "A_01";
    public final static String BASE_CONNECTION = AGENT+"/"+CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";
    public final static String PUBLISH_TOPIC = BASE_CONNECTION + "/publish";
  
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    

     private final MQTTCommunication communication;
    
    
    public AgentService() throws MqttException {
        communication = new MQTTCommunication();
        MQTTParameters parameters = new MQTTParameters();
        parameters.setClientID(CLIENT_ID);
        parameters.setIsCleanSession(false);
        parameters.setIsLastWillRetained(true);
        parameters.setLastWillMessage(STATUS_CONNECTION_OFFLINE.getBytes());
        parameters.setLastWillQoS(1);
        parameters.setServerURIs(URI.create("tcp://127.0.0.1:1883"));
        parameters.setWillTopic(STATUS_TOPIC_CONNECTION);
        parameters.setMqttCallback(this);
        communication.connect(parameters);
        communication.publishActualWill(STATUS_CONNECTION_ONLINE.getBytes());
        communication.subscribe(AGENT+"/#", 0);

    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Ouups, lost connection to subscirptions");
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    
    
    public static void main(String[] args) throws MqttException {
        AgentService service = new AgentService();
               
                     // EXAMPLE BUT DONT FUNCTION, BECAUSE WE HAVE NOT A TREADH / TRIGGER
             MqttMessage alertMessage = new MqttMessage();
                alertMessage.setPayload(("SEND A SMS & E-MAIL").getBytes());
                alertMessage.setRetained(true);
                alertMessage.setQos(0);
               
                // Subscribe via Broker the SoundIntensity Sensor (SI_01)
                service.communication.subscribe(SUBSCIRBE_SSI, 0);
                service.communication.subscribe("Sound Intensity/SI_01/Value: ", 0);
                
                // Publish message when intensity "greater than 1000"
                service.communication.publish(PUBLISH_TOPIC, alertMessage);
                
         
         
    }

}
