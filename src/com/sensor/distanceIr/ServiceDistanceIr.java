/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.distanceIr;

import com.tinkerforge.BrickletDistanceIR;
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
public class ServiceDistanceIr implements MqttCallback{

    private static final String UID = "qt4"; // Change to your UID    
    
     public final static String BASE_SENSOR_ID = "Distanz IR";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;
    	
    
     public ServiceDistanceIr() throws MqttException {
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

    
    
    
    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String[] args) throws MqttException, Exception {
        
        ServiceDistanceIr service=new ServiceDistanceIr();
                
        
                IPConnection ipcon = new IPConnection();
                HostConnection hc = new HostConnection();
                String HOST = hc.getLocalhost();
                int PORT = hc.getPort();     
                ipcon.connect(HOST, PORT); // Connect to brickd
                // Don't use device before ipcon is connected
                
		BrickletDistanceIR dir = new BrickletDistanceIR(UID, ipcon); // Create device object

		
		// Get threshold callbacks with a debounce time of 10 seconds (10000ms)
		dir.setDebouncePeriod(500);

		// Add distance reached listener (parameter has unit mm)
		dir.addDistanceReachedListener(new BrickletDistanceIR.DistanceReachedListener() {
			public void distanceReached(int distance) {
				System.out.println("Passage Detected");
                                MqttMessage message=new MqttMessage();
                                message.setPayload(("Passage Detected").getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Passage: ", message);
                                
                                
                                DateInput di = new DateInput();
                                MqttMessage dateMessage = new MqttMessage();
                                dateMessage.setPayload((di.getDate()).getBytes());
                                dateMessage.setRetained(true);
                                dateMessage.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Date: ", dateMessage);
			}
		});
                
              	// Add distance listener (parameter has unit mm)
		dir.addDistanceListener(new BrickletDistanceIR.DistanceListener() {
			public void distance(int distance) {
                                if (distance >= 790)
                                {
                                System.out.println("No Passage");
                                MqttMessage message=new MqttMessage();
                                message.setPayload(("No Passage").getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Passage: ", message);
                                
                                
                                DateInput di = new DateInput();
                                MqttMessage dateMessage = new MqttMessage();
                                dateMessage.setPayload((di.getDate()).getBytes());
                                dateMessage.setRetained(true);
                                dateMessage.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Date: ", dateMessage);
                                }
			}
		});
                                
                
		// Configure threshold for distance "smaller than 30 cm" (unit is mm)
		dir.setDistanceCallbackThreshold('i', 5*10, 50*10);
                
                // Set period for distance callback to 0.2s (200ms)
		// Note: The distance callback is only called every 0.2 seconds
		//       if the distance has changed since the last call!
		dir.setDistanceCallbackPeriod(200);

    }
    
}
