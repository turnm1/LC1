/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.motiondetector;

import com.tinkerforge.BrickletMotionDetector;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.helpers.DateInput;
import com.helpers.HostConnection;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Turna
 */
public class ServiceMotiondetector2 implements MqttCallback{

    	private static final String UID = "wt9"; // Change to your UID
        private static final String ROOM ="Wohnzimmer";
        
  public final static String BASE_SENSOR_ID = "Motion Detector";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+ROOM+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";

    
    private final MQTTCommunication communication;
    
    
     public ServiceMotiondetector2() throws MqttException {
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
        communication.subscribe(BASE_SENSOR_ID+"/#", 0);
        parameters.getLastWillMessage();

    }
     
     // Get the Topic Pathway for Motiondetector
    public static String getTopicValue(){
       String value = CLIENT_ID+"/Value:";
       return value;
    }
    
    public static String getTopicDate(){
       String date = CLIENT_ID+"/Date:";
       return date;
    }
    
    public static String getTopicStatus(){
        String status = STATUS_TOPIC_CONNECTION;
        return status;
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Ouups, lost connection to subscirptions");
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
      //  System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }
   
 
    
    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String[] args) throws MqttException, Exception {
        
                ServiceMotiondetector2 service=new ServiceMotiondetector2();
                               
        
                IPConnection ipcon = new IPConnection();
                HostConnection hc = new HostConnection();
                String HOST = hc.getIPWohnzimmer();
                int PORT = hc.getPort();     
                ipcon.connect(HOST, PORT); // Connect to brickd
                // Don't use device before ipcon is connected
                
		BrickletMotionDetector md = new BrickletMotionDetector(UID, ipcon); // Create device object

              
		// Add motion detected listener
		md.addMotionDetectedListener(new BrickletMotionDetector.MotionDetectedListener() {
			public void motionDetected() {

                            DateInput di = new DateInput();
                            MqttMessage message=new MqttMessage();
                            message.setPayload(("Motion Detected" + "/" + di.getDate()).getBytes());
                            message.setRetained(true);
                            message.setQos(0);
                            service.communication.publish(getTopicValue(), message);
                           
                        }
		});
                
              
		// Add detection cycle ended listener
		md.addDetectionCycleEndedListener(new BrickletMotionDetector.DetectionCycleEndedListener() {
			public void detectionCycleEnded() {

                            DateInput di = new DateInput();
                            MqttMessage message=new MqttMessage();
                            message.setPayload(("Motion Ended" + "/" + di.getDate()).getBytes());
                            message.setRetained(true);
                            message.setQos(0);
                            service.communication.publish(getTopicValue(), message);
                            
                         }
		});        
    }
    
}
