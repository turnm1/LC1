/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sensor.laserrangefinder;

import com.tinkerforge.BrickletLaserRangeFinder;
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
public class ServiceLaserRangeFinder1 implements MqttCallback{

    private static final String UID = "qt4"; // Change to your UID
    private static final String ROOM = "Wohnzimmer";
    
    public final static String BASE_SENSOR_ID = "Laser Range";
        public final static String CLIENT_ID = BASE_SENSOR_ID+"/"+ROOM+"/"+UID;
        public final static String STATUS_TOPIC = CLIENT_ID + "/status";
        public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
        public final static String STATUS_CONNECTION_OFFLINE="offline";
        public final static String STATUS_CONNECTION_ONLINE="online";
    
    private final MQTTCommunication communication;
    
    
     public ServiceLaserRangeFinder1() throws MqttException {
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
     
     // Get the Topic Pathway for LaserRangeFinder
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
        
        ServiceLaserRangeFinder1 service=new ServiceLaserRangeFinder1();
                
        
               IPConnection ipcon = new IPConnection();
                HostConnection hc = new HostConnection();
                String HOST = hc.getIPWohnzimmer();
                int PORT = hc.getPort();     
                ipcon.connect(HOST, PORT); // Connect to brickd
                // Don't use device before ipcon is connected
                
		BrickletLaserRangeFinder lrf = new BrickletLaserRangeFinder(UID, ipcon); // Create device object


		// Turn laser on and wait 250ms for very first measurement to be ready
		lrf.enableLaser();
		Thread.sleep(250);

		// Add distance listener (parameter has unit cm)
		lrf.addDistanceListener(new BrickletLaserRangeFinder.DistanceListener() {
			public void distance(int distance) {
				System.out.println("Distance: " + distance + " cm");
                                MqttMessage message=new MqttMessage();
                                message.setPayload((""+ distance + " cm").getBytes());
                                message.setRetained(true);
                                message.setQos(0);
                                service.communication.publish(getTopicValue(), message);
                                
                                DateInput di = new DateInput();
                                MqttMessage dateMessage = new MqttMessage();
                                dateMessage.setPayload((di.getDate()).getBytes());
                                dateMessage.setRetained(true);
                                dateMessage.setQos(0);
                                service.communication.publish(getTopicDate(), dateMessage);
			}
		});

		// Set period for distance callback to 0.2s (200ms)
		// Note: The distance callback is only called every 0.2 seconds
		//       if the distance has changed since the last call!
		lrf.setDistanceCallbackPeriod(200);
                lrf.disableLaser(); // Turn laser off
    }
    
}
