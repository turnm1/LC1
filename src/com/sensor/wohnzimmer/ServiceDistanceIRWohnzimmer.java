/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.wohnzimmer;

import com.tinkerforge.BrickletDistanceIR;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Turna
 */
public class ServiceDistanceIRWohnzimmer implements MqttCallback{

    public final static String CLIENT_ID="Wohnzimmer001";
    
    public final static String BASE_TOPIC = "Service";
    public final static String STATUS_TOPIC = BASE_TOPIC + "/status";
    
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;
    
        private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "qt4"; // Change to your UID
    
     public ServiceDistanceIRWohnzimmer() throws MqttException {
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
        communication.subscribe(BASE_TOPIC+"/#", 0);

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
        
        ServiceDistanceIRWohnzimmer service=new ServiceDistanceIRWohnzimmer();
                
        
                IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletDistanceIR dir = new BrickletDistanceIR(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Get threshold callbacks with a debounce time of 10 seconds (10000ms)
		dir.setDebouncePeriod(500);

		// Add distance reached listener (parameter has unit mm)
		dir.addDistanceReachedListener(new BrickletDistanceIR.DistanceReachedListener() {
			public void distanceReached(int distance) {
				System.out.println("Distance: " + distance/10.0 + " cm");
                                MqttMessage message=new MqttMessage();
                                message.setPayload((""+distance/10.0).getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                communication.publish("Distanz", message);
			}
		});

		// Configure threshold for distance "smaller than 30 cm" (unit is mm)
		dir.setDistanceCallbackThreshold('<', 60*10, 0);
                

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
    }
    
}
