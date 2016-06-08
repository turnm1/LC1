/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.ambientlight;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.helpers.DateInput;
import com.helpers.HostConnection;
import com.tinkerforge.BrickletAmbientLightV2;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Turna
 */
public class ServiceAmbientLight2 implements MqttCallback{

    private final MQTTCommunication communication;   
    
    private static final String UID = "yh9"; // Change to your UID
    private final static String ROOM = "Wohnzimmer";
 
    
        public final static String BASE_SENSOR_ID = "Ambient Light";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+ROOM+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";
 
      
    /*
    Fixre addService() code
    */
     public ServiceAmbientLight2() throws MqttException {
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
     
     // Get the Topic Pathway for AmbienteLight
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
      // System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    
    /*
    Variabler Code unterschiedlich zur Sensor_typ
    */
    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String[] args) throws MqttException, Exception {
        
                ServiceAmbientLight2 service=new ServiceAmbientLight2();
                          
                IPConnection ipcon = new IPConnection();
                HostConnection hc = new HostConnection();
                String HOST = hc.getIPEingangIR();
                int PORT = hc.getPort();     
                ipcon.connect(HOST, PORT); // Connect to brickd
                // Don't use device before ipcon is connected
                
                BrickletAmbientLightV2 al = new BrickletAmbientLightV2(UID, ipcon); // Create device object
                
		// Get threshold callbacks with a debounce time of 5 minues (10000ms = 10sek)
		al.setDebouncePeriod(300000);

		// Add illuminance reached listener (parameter has unit Lux/10)
		al.addIlluminanceReachedListener(new BrickletAmbientLightV2.IlluminanceReachedListener() {
			public void illuminanceReached(long illuminance) {
				
                            DateInput di = new DateInput();
                            MqttMessage message=new MqttMessage();
                            
                            message.setPayload((""+illuminance/10.0 + "/" + di.getDate()).getBytes());
                            message.setRetained(true);
                            message.setQos(0);
                            
                            service.communication.publish(getTopicValue(), message);
                            System.out.println(message);
			}
		});

		// Configure threshold for illuminance push<50 out of to 170>push (unit is Lux/10)
		al.setIlluminanceCallbackThreshold('o', 5*10, 17*10);
    
    }
    
}
