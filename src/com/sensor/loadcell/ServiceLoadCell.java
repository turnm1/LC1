/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.loadcell;

import com.tinkerforge.BrickletLoadCell;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.helpers.DateInput;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Turna
 */
public class ServiceLoadCell implements MqttCallback{
  
    public final static String SENSOR_TYP = "Load Cell"; 
    public final static String CLIENT_ID = "LC_01";
    public final static String BASE_SENSOR_ID = "/"+CLIENT_ID;
    public final static String STATUS_TOPIC = SENSOR_TYP + BASE_SENSOR_ID + "/status";
    
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;
    
        private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "vdT"; // Change to your UID
    
     public ServiceLoadCell() throws MqttException {
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
        
        ServiceLoadCell service=new ServiceLoadCell();
                
        
               IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletLoadCell lc = new BrickletLoadCell(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Get threshold callbacks with a debounce time of 1 second (1000ms)
		lc.setDebouncePeriod(1000);

		// Add weight reached listener (parameter has unit g)
		lc.addWeightReachedListener(new BrickletLoadCell.WeightReachedListener() {
			public void weightReached(int weight) {
				System.out.println("Weight: " + weight + " g");
                                MqttMessage message=new MqttMessage();
                                message.setPayload((""+ weight + " g").getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                service.communication.publish(SENSOR_TYP+BASE_SENSOR_ID+"/Value: ", message);
                                
                                DateInput di = new DateInput();
                                MqttMessage dateMessage = new MqttMessage();
                                dateMessage.setPayload((di.getDate()).getBytes());
                                dateMessage.setRetained(true);
                                dateMessage.setQos(0);
                                service.communication.publish(SENSOR_TYP+BASE_SENSOR_ID+"/Date: ", dateMessage);
			}
		});

		// Configure threshold for weight "greater than 200 g" (unit is g)
		lc.setWeightCallbackThreshold('>', 200, 0);

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
    }
    
}
