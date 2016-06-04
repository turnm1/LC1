/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.loadcell.chair;

import com.sensor.loadcell.*;
import com.tinkerforge.BrickletLoadCell;
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
public class ServiceLoadCell4 implements MqttCallback{
  
    private static final String UID = "***"; // Vorne links
    private static final String ROOM = "Wohnzimmer";
    
    public final static String BASE_SENSOR_ID = "Load Cell";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+ROOM+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";

    
    private final MQTTCommunication communication;

    
     public ServiceLoadCell4() throws MqttException {
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
     
     // Get the Topic Pathway for Loadcell
     public static String getTopicValue(){
       String value = CLIENT_ID+"/Value:";
       return value;
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
        System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    
    
    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String[] args) throws MqttException, Exception {
        
        ServiceLoadCell4 service=new ServiceLoadCell4();
                
        
              IPConnection ipcon = new IPConnection();
                HostConnection hc = new HostConnection();
                String HOST = hc.getIPSchlafzimmer_Bett();
                int PORT = hc.getPort();     
                ipcon.connect(HOST, PORT); // Connect to brickd
                // Don't use device before ipcon is connected
                
		BrickletLoadCell lc = new BrickletLoadCell(UID, ipcon); // Create device object


		// Get threshold callbacks with a debounce time of 1 second (1000ms)
		lc.setDebouncePeriod(1000);

		// Add weight reached listener (parameter has unit g)
		lc.addWeightReachedListener(new BrickletLoadCell.WeightReachedListener() {
			public void weightReached(int weight) {
                            
                            MqttMessage message=new MqttMessage();
                            DateInput di = new DateInput();
                            message.setRetained(true);
                            message.setQos(0);
                            
                            if (weight >= 200){
                                message.setPayload(("sitzen" + "/" + di.getDate()).getBytes());
                                service.communication.publish(getTopicValue(), message);
                            } else if (weight < 200){
                                message.setPayload(("aufgestanden" + "/" + di.getDate()).getBytes());
                                service.communication.publish(getTopicValue(), message);
                            }
                            
                                
			}
		});

		// Configure threshold for weight "greater than 1kg g" (1kg = 1000g)
		lc.setWeightCallbackThreshold('>', 5000, 0);

    }
    
}
