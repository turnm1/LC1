/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;

import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.loadcell.ServiceLoadCell;
import com.sensor.loadcell.ServiceLoadCell1;
import com.sensor.loadcell.ServiceLoadCell2;
import com.sensor.loadcell.ServiceLoadCell3;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author reto
 */
public class BedAgent implements MqttCallback {

    // Subscrib Pathways
   private static ServiceLoadCell slc;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC_VALUE = slc.getTopicValue();
   private final static String SUBSCRIBE_SLC_DATE = slc.getTopicDate();

   private static ServiceLoadCell1 slc1;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC1_VALUE = slc1.getTopicValue();
   private final static String SUBSCRIBE_SLC1_DATE = slc1.getTopicDate();
   
   private static ServiceLoadCell2 slc2;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC2_VALUE = slc2.getTopicValue();
   private final static String SUBSCRIBE_SLC2_DATE = slc2.getTopicDate();
   
   private static ServiceLoadCell3 slc3;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC3_VALUE = slc3.getTopicValue();
   private final static String SUBSCRIBE_SLC3_DATE = slc3.getTopicDate();
   
  
    private static String sensTyp = "";
    private static String sensUID = "";
    private static String sensRoom = "";
    private static String sensDate = "";

    private static String sensValue = null;
    private static String valueDate = "";

    // Agent Pathways
    public final static String AGENT = "AGENT";
    public final static String CLIENT_ID = "BedActivity";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String PUBLISH_TOPIC = "leer";

    private final MQTTCommunication communication;

    public BedAgent() throws MqttException {
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
            String [] vd = valueDate.split("/",2);
            sensValue = vd[0];

             if (sendedSensTyp.equals("Load Cell")) {
                 if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                 sensUID = sendedUID;
                 sensRoom = sendedRoom;
                 System.out.println("Aktivity: Bewohner liegt auf dem Bett,Stuhl,Sofa / im Raum: " + sensRoom);
             }  }
        } 
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    public static void main(String[] args) throws MqttException {
        BedAgent service = new BedAgent();

        // Subscribe via Broker the LoadCell Sensor
                service.communication.subscribe(SUBSCRIBE_SLC_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC_DATE, 0);
                
                service.communication.subscribe(SUBSCRIBE_SLC1_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC1_DATE, 0);
                
                service.communication.subscribe(SUBSCRIBE_SLC2_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC2_DATE, 0);
                
                service.communication.subscribe(SUBSCRIBE_SLC3_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC3_DATE, 0);
              
    }

}
