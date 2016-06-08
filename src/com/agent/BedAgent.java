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
   private static ServiceLoadCell slc;       
   private final static String SUBSCRIBE_SLC_VALUE = slc.getTopicValue();

   private static ServiceLoadCell1 slc1;          
   private final static String SUBSCRIBE_SLC1_VALUE = slc1.getTopicValue();
   
   private static ServiceLoadCell2 slc2;          
   private final static String SUBSCRIBE_SLC2_VALUE = slc2.getTopicValue();
   
   private static ServiceLoadCell3 slc3;          
   private final static String SUBSCRIBE_SLC3_VALUE = slc3.getTopicValue();
   
  
    private static String sensTyp = "";
    private static String sensUID = "";
    private static String sensRoom = "";
    private static String sensDate = "";

    private static int sensValue;
    private static String sensText = null;
    private static String valueDate = "";
    
    private static int ValueLU;
    private static String TextLU;
    private static int ValueRU;
    private static String TextRU;
    private static int ValueLO;
    private static String TextLO;
    private static int ValueRO;
    private static String TextRO;
    
    private static int LageLinks = 0;
    private static int LageRechts = 0;
    private static int LageUnten = 0;

    // Agent Pathways
    public final static String AGENT = "AGENT";
    public final static String CLIENT_ID = "BedActivity";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String PUBLISH_TOPIC = BASE_CONNECTION;

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
    public static String getTopicValue() {
        String value = BASE_CONNECTION + "/Belegt:";
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
            String [] vd = valueDate.split("/",3);
            sensValue = Integer.valueOf(vd[0]);
            sensText = vd[1];
            System.out.println(sensValue + " und " + sensText + " CHECK, pls!");

             if (sendedUID.equals("vdv")) {
                 if (sensText.equals("liegt")) {
                 ValueLU = sensValue;
                 TextLU = sensText;
             }  }
             if (sendedUID.equals("vcQ")) {
                 if (sensText.equals("liegt")) {
                 ValueRU = sensValue;
                 TextRU = sensText;
             }  }
             if (sendedUID.equals("vcn")) {
                 if (sensText.equals("liegt")) {
                 ValueLO = sensValue;
                 TextLO = sensText;
             }  }
             if (sendedUID.equals("vdT")) {
                 if (sensText.equals("liegt")) {
                 ValueRO = sensValue;
                 TextRO = sensText;
             }  }
             
             // Publish Belegung: Ja / Nein / Bewohner sitzt nur
             if (TextLU.equals("liegt") | TextRU.equals("liegt") | TextLO.equals("liegt") | TextRO.equals("liegt")){
                 message.setPayload("Bewohner sitzt nur".getBytes());
                 communication.publish(PUBLISH_TOPIC +"/Belegt:", message);
             } else if (TextLU.equals("liegt") | TextRU.equals("liegt") && TextLO.equals("liegt") && TextRO.equals("liegt")){
                 message.setPayload("Ja".getBytes());
                 communication.publish(PUBLISH_TOPIC +"/Belegt:", message);
                 
                 // Lage positionierung wenn Belegt ist
                 if (ValueLU > ValueRU && ValueLU > ValueRO){
                     LageLinks++;
                 }
                  if (ValueLO > ValueRU && ValueLO > ValueRO){
                     LageLinks++;
                 }
                 
                  if (ValueRO > ValueLU && ValueRO > ValueLO){
                     LageRechts++;
                 }
                   if (ValueRU > ValueLU && ValueRU > ValueLO){
                     LageRechts++;
                 }
                   
                  if (ValueLU > ValueLO && ValueRU > ValueRO | ValueLU > ValueRO && ValueRU > ValueLO){
                     LageUnten++;
                 }
                  
                 if (LageLinks == 2){
                    message.setPayload("Links".getBytes());
                    communication.publish(PUBLISH_TOPIC +"/Lage:", message);
                 } else if (LageRechts == 2){
                    message.setPayload("Rechts".getBytes());
                    communication.publish(PUBLISH_TOPIC +"/Lage:", message);
                 } else if (LageUnten == 1){
                    message.setPayload("Unten".getBytes());
                    communication.publish(PUBLISH_TOPIC +"/Lage:", message);
                 } else {
                    message.setPayload("Mitte".getBytes());
                    communication.publish(PUBLISH_TOPIC +"/Lage:", message);
                 }
                  
                 
             // Publish Belegung: Nein
             } else {
                 message.setPayload("Nein".getBytes());
                 communication.publish(PUBLISH_TOPIC +"/Belegt:", message);
                 LageLinks = 0;
                 LageRechts = 0;
                 LageUnten = 0;
             }
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
               
                service.communication.subscribe(SUBSCRIBE_SLC1_VALUE, 0);
               
                service.communication.subscribe(SUBSCRIBE_SLC2_VALUE, 0);
                
                service.communication.subscribe(SUBSCRIBE_SLC3_VALUE, 0);
               
    }

}
