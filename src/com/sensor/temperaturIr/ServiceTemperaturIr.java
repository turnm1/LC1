/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.temperaturIr;

import com.tinkerforge.BrickletTemperatureIR;
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
public class ServiceTemperaturIr implements MqttCallback{

    public final static String SENSOR_TYP = "Temperatur IR"; 
    public final static String CLIENT_ID = "TIR_01";
    public final static String BASE_SENSOR_ID = "/"+CLIENT_ID;
    public final static String STATUS_TOPIC = SENSOR_TYP + BASE_SENSOR_ID + "/status";
    
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;
    
        private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "qCb"; // Change to your UID
    
     public ServiceTemperaturIr() throws MqttException {
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

       // Get the Topic Pathway for TemperaturIr
    public static String getTopic(){
       String topicPath = SENSOR_TYP+BASE_SENSOR_ID+"/Value:";
       return topicPath;
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
        
        ServiceTemperaturIr service=new ServiceTemperaturIr();
                
        
               	IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletTemperatureIR tir = new BrickletTemperatureIR(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Add object temperature reached listener (parameter has unit °C/10)
		tir.addObjectTemperatureReachedListener(new BrickletTemperatureIR.ObjectTemperatureReachedListener() {
			public void objectTemperatureReached(short temperature) {
				System.out.println("Object Temperature: " + temperature/10.0 + " °C");
                                MqttMessage message=new MqttMessage();
                                message.setPayload((" " + temperature/10.0 + " °C").getBytes());
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

		// Configure threshold for object temperature "greater than 100 °C" (unit is °C/10)
		tir.setObjectTemperatureCallbackThreshold('>', (short)(10*10), (short)0);
                
                // Set emissivity to 0.98 (emissivity of water, 65535 * 0.98 = 64224.299)
		tir.setEmissivity(64224);

		// Get threshold callbacks with a debounce time of 10 seconds (10000ms)
		tir.setDebouncePeriod(1000);

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
	}
    }
    
