/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;

import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.ambientlight.ServiceAmbientLight;
import com.sensor.loadcell.ServiceLoadCell;
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
   private final static String SUBSCRIBE_SAL_DATE = sal.getTopicDate();
   private final static String SUBRSCRIB_SAL_STATUS = sal.getTopicStatus();

   private static ServiceLoadCell slc;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC_VALUE = slc.getTopicValue();
   private final static String SUBSCRIBE_SLC_DATE = slc.getTopicDate();
   private final static String SUBRSCRIB_SLC_STATUS = slc.getTopicStatus();

   private static  ServiceSoundIntensity ssi;   // Wasserhahn auf/zu
   private final static String SUBSCRIBE_SSI_VALUE = ssi.getTopicValue();
   private final static String SUBSCRIBE_SSI_DATE = ssi.getTopicDate();
   private final static String SUBRSCRIB_SSI_STATUS = ssi.getTopicStatus();
   
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
    public final static String CLIENT_ID = "Activity";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String PUBLISH_TOPIC = "leer";

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
            String [] vd = valueDate.split("/",2);
            sensValue = vd[0];

             if (sendedSensTyp.equals("Load Cell")) {
                 if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                 sensUID = sendedUID;
                 sensRoom = sendedRoom;
                 System.out.println("Aktivity: Bewohner liegt auf dem Bett,Stuhl,Sofa / im Raum: " + sensRoom);
             }  }
             
             if (sendedSensTyp.equals("Ambient Light")){
                 if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                 sensUID = sendedUID;
                 sensRoom = sendedRoom;
                 System.out.println("Aktivity: Licht wurde "+ sensValue + " / im Raum: " + sensRoom);
             }  }
             
             if (sendedSensTyp.equals("CO2")) {
                 if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                 sensUID = sendedUID;
                 sensRoom = sendedRoom;
                 System.out.println("Co2 Gehalt: " + sensValue + " / im Raum: " + sensRoom);
             }  }
        
            if (sendedSensTyp.equals("Distance IR")) {
                if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                sensUID = sendedUID;
                sensRoom = sendedRoom;
                if (sensValue.equals("Passage Detected")) {
                    System.out.println("Fenster wurde geöffnet / im Raum: " + sensRoom);
                } else if (sensValue.equals("No Passage")) {
                    System.out.println("Fenster wurde geschlossen / im Raum: " + sensRoom);
                }
                }
            }
            
            if (sendedSensTyp.equals("Humidity")) {
                if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                    
                }
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
                service.communication.subscribe(SUBSCRIBE_SLC_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC_DATE, 0);
                
                // Subscribe via Broker the Ambiente Light Sensor
                service.communication.subscribe(SUBSCRIBE_SAL_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SAL_DATE, 0);
                
                // Subscribe via Broker the SoundIntensity Sensor
                service.communication.subscribe(SUBSCRIBE_SSI_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SSI_DATE, 0);

    }

}
