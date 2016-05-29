/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.temperatur;

import com.tinkerforge.BrickletTemperature;
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
public class ServiceTemperatur5 implements MqttCallback{

    
    /*
    Pfad: Temperatur/qvy/status & value
    */
    private static final String UID = "t6W"; // Change to your UID
    private static final String ROOM = "Küche";
        
    public final static String BASE_SENSOR_ID = "Temperatur";
    public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+ROOM+"/"+UID;
    public final static String STATUS_TOPIC = CLIENT_ID + "/status";
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;


    
     public ServiceTemperatur5() throws MqttException {
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

     // Get the Topic Pathway for Temperatur
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
        System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    
    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String[] args) throws MqttException, Exception {
        
        ServiceTemperatur5 service=new ServiceTemperatur5();
                
        IPConnection ipcon = new IPConnection();
                    HostConnection hc = new HostConnection();
                    String HOST = hc.getLocalhost();
                    int PORT = hc.getPort();     
                    ipcon.connect(HOST, PORT); // Connect to brickd
                    // Don't use device before ipcon is connected
		
                    BrickletTemperature t = new BrickletTemperature(UID, ipcon); // Create device object


		// Add temperature reached listener (parameter has unit °C/100)
		t.addTemperatureReachedListener(new BrickletTemperature.TemperatureReachedListener() {
			public void temperatureReached(short temperature) {
				
                            DateInput di = new DateInput();
                            MqttMessage message=new MqttMessage();
                            
                            message.setPayload((temperature/100.0 + "/" + di.getDate()).getBytes());
                            message.setRetained(true);
                            message.setQos(0);
                            
                            service.communication.publish(getTopicValue(), message);
                            System.out.println(message);
                               
			}
		});

                // Add temperature listener (parameter has unit °C/100)
		t.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
			public void temperature(short temperature) {
				
                            DateInput di = new DateInput();
                            MqttMessage message=new MqttMessage();
                            
                            message.setPayload((temperature/100.0 + "/" + di.getDate()).getBytes());
                            message.setRetained(true);
                            message.setQos(0);
                            
                            service.communication.publish(getTopicValue(), message);
                            System.out.println(message);
                                
			}
		});
                
                
		// Configure threshold for temperature "greater than 30 °C" (unit is °C/100)
		t.setTemperatureCallbackThreshold('o', (short)(25*100), (short)(30*100));
                // Get threshold callbacks with a debounce time of 5 minutes = 300000ms (10000ms = 10sec)
		t.setDebouncePeriod(300000);
                
                // Set period for temperature callback to 1 hour = 3'600'000ms (1000ms = 1sek)
		// Note: The temperature callback is only called every second
		//       if the temperature has changed since the last call!
		t.setTemperatureCallbackPeriod(3600000);
                
    }
    
}
