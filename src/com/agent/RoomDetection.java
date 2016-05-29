/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;

import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.helpers.Room;
import com.sensor.distanceIr.ServiceDistanceIr;
import com.sensor.distanceIr.ServiceDistanceIr1;
import com.sensor.distanceIr.ServiceDistanceIr5;
import com.sensor.laserrangefinder.ServiceLaserRangeFinder;
import com.sensor.motiondetector.ServiceMotiondetector;
import com.sensor.motiondetector.ServiceMotiondetector1;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author reto
 */
public class RoomDetection implements MqttCallback {

    // Subscrib Pathways
    private static ServiceMotiondetector smd;
    private final static String SUBSCRIBE_SMD_VALUE = smd.getTopicValue();

    private static ServiceMotiondetector1 smd1;
    private final static String SUBSCRIBE_SMD1_VALUE = smd1.getTopicValue();

    private static ServiceLaserRangeFinder srf;
    private final static String SUBSCRIBE_SRF_VALUE = srf.getTopicValue();

    private static ServiceDistanceIr sdir;
    private final static String SUBSCRIBE_SDIR_VALUE = sdir.getTopicValue();
    private static ServiceDistanceIr5 sdir5;
    private final static String SUBSCRIBE_SDIR5_VALUE = sdir5.getTopicValue();

    private static ServiceDistanceIr1 sdir1;
    private final static String SUBSCRIBE_SDIR1_VALUE = sdir1.getTopicValue();


    Room r = new Room();
    
    private static String sensUID = "xxx";
    private static String sensRoom = "leave Home";
    private static String sensValue = null;
    private static String valueDate = "";

    // Agent Pathways
    public final static String AGENT = "AGENT";
    public final static String CLIENT_ID = "RoomDetection";
    public final static String BASE_CONNECTION = AGENT + "/" + CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";

    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static String RoomLocation = "leer";
    public final static String PUBLISH_TOPIC = BASE_CONNECTION;

    private final MQTTCommunication communication;

    public RoomDetection() throws MqttException {
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
           
        MqttMessage messageRoomEntry = new MqttMessage();
        messageRoomEntry.setRetained(true);
        messageRoomEntry.setQos(0);
            
        MqttMessage messageRoomLeave = new MqttMessage();
        messageRoomLeave.setRetained(true);
        messageRoomLeave.setQos(0);

        MqttMessage messageRoomLocation = new MqttMessage();
        messageRoomLocation.setRetained(true);
        messageRoomLocation.setQos(0);
        
        MqttMessage motionMessage = new MqttMessage();
        motionMessage.setRetained(true);
        motionMessage.setQos(0);
            
            
        if (string.endsWith("Value:")) {
            String[] res = string.split("/", 4);
            String sendedRoom = res[1];
            String sendedSensTyp = res[0];
            String sendedUID = res[2];

            valueDate = new String(mm.getPayload());
            String [] vd = valueDate.split("/",2);
            sensValue = vd[0];

            if (sendedSensTyp.equals("Distanz IR")) {
                if (!sensUID.equals(sendedUID) && !sensRoom.equals(sendedRoom)) {
                    r.setNewUID(sendedUID);
                    r.setLastUID(sensUID);
                    messageRoomLeave.setPayload((sensRoom).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Leave:", messageRoomLeave);
                    r.setLastRoom(sensRoom);
                    System.out.println(r.getLastRoom());
                    sensRoom = sendedRoom;
                    messageRoomEntry.setPayload((sendedRoom).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Entry:", messageRoomEntry);
                    r.setNewRoom(sendedRoom);
                    r.setRoomLocation(sendedRoom);
                    messageRoomLocation.setPayload((r.getRoomLocation()).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Room Location", messageRoomLocation);
                } else if (r.getNewUID().equals(sendedUID) && sensValue.equals("Passage Detected")){
                    //r.setNewUID(r.getLastUID());
                    r.setNewUID(sensUID);
                    sensUID = r.getLastUID();
                    messageRoomLeave.setPayload((r.getNewRoom()).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Leave:", messageRoomLeave);
                   // r.setLastUID(r.getNewRoom());
                    messageRoomEntry.setPayload((r.getLastRoom()).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Entry:", messageRoomEntry);
                    sensRoom = r.getLastRoom();
                    messageRoomLocation.setPayload((r.getLastRoom()).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Room Location", messageRoomLocation);
                    r.setNewRoom(r.getLastRoom());
                }
            }

            if (sendedSensTyp.equals("Motion Detector")) {
               
                if (r.getRoomLocation().equals(sendedRoom)) {
                    motionMessage.setPayload((sensValue).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Motion in Room", motionMessage);
                } else if (!r.getRoomLocation().equals(sendedRoom)){
                    if(!r.getLastRoom().equals(sendedRoom)){
                    messageRoomLocation.setPayload((sendedRoom).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Room Location", messageRoomLocation);
                    motionMessage.setPayload((sensValue).getBytes());
                    communication.publish(PUBLISH_TOPIC + "/" + "Motion in Room", motionMessage);
                    }
                        
                }
                
          //      if (!sensUID.equals(sendedUID)) {
          //          sensUID = sendedUID;
          //          if (r.getRoomLocation().equals(sendedRoom)) {
          //              sensRoom = sendedRoom;
          //              RoomLocation = sensRoom;
          //              messageRoomLocation.setPayload((RoomLocation).getBytes());
          //             communication.publish(PUBLISH_TOPIC + "/" + "Room Location", messageRoomLocation);
          //          }
          //      }
          
//                if (r.getRoomLocation().equals(sendedRoom)) {
//                    MqttMessage motionMessage = new MqttMessage();
//                    motionMessage.setRetained(true);
//                    motionMessage.setQos(0);
//                    motionMessage.setPayload((sensValue).getBytes());
//                    communication.publish(PUBLISH_TOPIC + "/" + "Motion in Room", motionMessage);
//                }
            }
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    public static void main(String[] args) throws MqttException {
        RoomDetection service = new RoomDetection();

        // Subscribe via Broker the Distance IR Sensor
        service.communication.subscribe(SUBSCRIBE_SDIR_VALUE, 0);
        service.communication.subscribe(SUBSCRIBE_SDIR5_VALUE, 0);

        service.communication.subscribe(SUBSCRIBE_SDIR1_VALUE, 0);

        // Subscribe via Broker the Laser Range Finder Sensor
        service.communication.subscribe(SUBSCRIBE_SRF_VALUE, 0);

        // Subscribe via Broker the Motion Sensor
        service.communication.subscribe(SUBSCRIBE_SMD_VALUE, 0);
        service.communication.subscribe(SUBSCRIBE_SMD1_VALUE, 0);


    }

}
