/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.soundintensity;

import com.tinkerforge.BrickletSoundIntensity;
import com.tinkerforge.IPConnection;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.helpers.DateInput;
import com.helpers.HostConnection;
import com.sensor.temperaturIr.ServiceTemperaturIr;

import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author Turna
 */
public class ServiceSoundIntensity implements MqttCallback {

    // Subscrib Pathways
    private static  ServiceTemperaturIr stir;
    private final static String SUBSCIRBE_SSI = stir.getTopic();
    	private static final String UID = "mnn"; // Change to your UID
        
    // ServiceSoundIntensity Pathways
    public final static String BASE_SENSOR_ID = "Sound Intensity";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;

    
     public ServiceSoundIntensity() throws MqttException {
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
    
     // Get the Topic Pathway for SoundIntensity
    public static String getTopic(){
        String topicPath = CLIENT_ID+"/Value:";
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
        
         
        // New Service (Koenig)
        ServiceSoundIntensity service=new ServiceSoundIntensity();
          
                    IPConnection ipcon = new IPConnection();
                    HostConnection hc = new HostConnection();
                    String HOST = hc.getLocalhost();
                    int PORT = hc.getPort();     
                    ipcon.connect(HOST, PORT); // Connect to brickd
                    // Don't use device before ipcon is connected
                    
                    BrickletSoundIntensity si = new BrickletSoundIntensity(UID, ipcon); // Create device object

                

		// Get threshold callbacks with a debounce time of 1 second (1000ms)
		si.setDebouncePeriod(1000);

		// Add intensity reached listener
		si.addIntensityReachedListener(new BrickletSoundIntensity.IntensityReachedListener() {
		
                                        
                        public void intensityReached(int intensity) {
				System.out.println("Intensity: " + intensity);
                                
                                MqttMessage message = new MqttMessage();
                                message.setPayload((" " + intensity).getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Value: ", message);
                                
                                
                                DateInput di = new DateInput();
                                MqttMessage dateMessage = new MqttMessage();
                                dateMessage.setPayload((di.getDate()).getBytes());
                                dateMessage.setRetained(true);
                                dateMessage.setQos(0);
                                service.communication.publish(CLIENT_ID+"/Date: ", dateMessage);
                                                                                                                                                                                        
                                // FALSCHER ORT - ES MUSS EINE WEITERE METHODE EXISTIEREN MIT ZEITLICHER SUBSCRIBE! HIER WIRD NUR SUBSCRIBT, WENN EIN PUBLISH GEMACHT WIRD
                                // Subscribe via Broker from other Clients(publisher)
                                // service.communication.subscribe(SUBSCIRBE_SSI, 0);
                               
                                      
			}
		});

		// Configure threshold for intensity "greater than 800"
		si.setIntensityCallbackThreshold('>', 1000, 0);
    }
    
  
}
