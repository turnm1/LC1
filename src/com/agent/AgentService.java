/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;



import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.DistanceUs.ServiceDistanceUs;
import com.sensor.ambientlight.ServiceAmbientLight2;
import com.sensor.co2.ServiceCo2;
import com.sensor.distanceIr.ServiceDistanceIr;
import com.sensor.humidity.ServiceHumidity;
import com.sensor.laserrangefinder.ServiceLaserRangeFinder;
import com.sensor.loadcell.ServiceLoadCell;
import com.sensor.motiondetector.ServiceMotiondetector;
import com.sensor.soundintensity.ServiceSoundIntensity;
import com.sensor.temperatur.ServiceTemperatur;
import com.sensor.temperaturIr.ServiceTemperaturIr;


import java.net.URI;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author reto
 */
public class AgentService implements MqttCallback{

  
    // Subscrib Pathways
   private static  ServiceSoundIntensity ssi;
   private final static String SUBSCRIBE_SSI_VALUE = ssi.getTopicValue();
   private final static String SUBSCRIBE_SSI_DATE = ssi.getTopicDate();
   private final static String SUBRSCRIB_SSI_STATUS = ssi.getTopicStatus();
   
   private static ServiceHumidity sh;
   private final static String SUBSCRIBE_SH_VALUE = sh.getTopicValue();
   private final static String SUBSCRIBE_SH_DATE = sh.getTopicDate();
   private final static String SUBRSCRIB_SH_STATUS = sh.getTopicStatus();
   
   private static ServiceTemperaturIr stir;
   private final static String SUBSCRIBE_STIR_VALUE = stir.getTopicValue();
   private final static String SUBSCRIBE_STIR_DATE = stir.getTopicDate();
   private final static String SUBRSCRIB_STIR_STATUS = stir.getTopicStatus();
    
   private static ServiceTemperatur st;
   private final static String SUBSCRIBE_ST_VALUE = st.getTopicValue();
   private final static String SUBSCRIBE_ST_DATE = st.getTopicDate();
   private final static String SUBRSCRIB_ST_STATUS = st.getTopicStatus();
 
   private static ServiceMotiondetector smd;
   private final static String SUBSCRIBE_SMD_VALUE = smd.getTopicValue();
   private final static String SUBSCRIBE_SMD_DATE = smd.getTopicDate();
   private final static String SUBRSCRIB_SMD_STATUS = smd.getTopicStatus();
   
   private static ServiceLoadCell slc;
   private final static String SUBSCRIBE_SLC_VALUE = slc.getTopicValue();
   private final static String SUBSCRIBE_SLC_DATE = slc.getTopicDate();
   private final static String SUBRSCRIB_SLC_STATUS = slc.getTopicStatus();
   
   private static ServiceLaserRangeFinder srf;
   private final static String SUBSCRIBE_SRF_VALUE = srf.getTopicValue();
   private final static String SUBSCRIBE_SRF_DATE = srf.getTopicDate();
   private final static String SUBRSCRIB_SRF_STATUS = srf.getTopicStatus();
   
   private static ServiceDistanceUs sdus;
   private final static String SUBSCRIBE_SDUS_VALUE = sdus.getTopicValue();
   private final static String SUBSCRIBE_SDUS_DATE = sdus.getTopicDate();
   private final static String SUBRSCRIB_SDUS_STATUS = sdus.getTopicStatus();
   
   private static ServiceDistanceIr sdir;
   private final static String SUBSCRIBE_SDIR_VALUE = sdir.getTopicValue();
   private final static String SUBSCRIBE_SDIR_DATE = sdir.getTopicDate();
   private final static String SUBRSCRIB_SDIR_STATUS = sdir.getTopicStatus();
   
   private static ServiceCo2 sco;
   private final static String SUBSCRIBE_SCO_VALUE = sco.getTopicValue();
   private final static String SUBSCRIBE_SCO_DATE = sco.getTopicDate();
   private final static String SUBRSCRIB_SCO_STATUS = sco.getTopicStatus();
   
   private static ServiceAmbientLight2 sal;
   private final static String SUBSCRIBE_SAL_VALUE = sal.getTopicValue();
   private final static String SUBSCRIBE_SAL_DATE = sal.getTopicDate();
   private final static String SUBRSCRIB_SAL_STATUS = sal.getTopicStatus();
    
   
    private static String sensTyp = null;
    private static String sensUID = null;
    private static String sensStatus = null;
    private static String sensRoom = null;
    private static String sensDate = null;
    private static String sensValue = null;
   
    // Agent Pathways
    public final static String AGENT = "AGENT"; 
    public final static String CLIENT_ID = "A_01";
    public final static String BASE_CONNECTION = AGENT+"/"+CLIENT_ID;
    public final static String STATUS_TOPIC = BASE_CONNECTION + "/status";
  
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE="offline";
    public final static String STATUS_CONNECTION_ONLINE="online";
    

    public static String sql = "leer";
    public static String PUBLISH_TOPIC = "leer";
    
     private final MQTTCommunication communication;
    
    
    public AgentService() throws MqttException {
        communication = new MQTTCommunication();
        MQTTParameters parameters = new MQTTParameters();
        parameters.setClientID(CLIENT_ID);
        parameters.setIsCleanSession(true);
        parameters.setIsLastWillRetained(true);
        parameters.setLastWillMessage(STATUS_CONNECTION_OFFLINE.getBytes());
        parameters.setLastWillQoS(1);
        parameters.setServerURIs(URI.create("tcp://127.0.0.1:1883"));
        parameters.setWillTopic(STATUS_TOPIC_CONNECTION);
        parameters.setMqttCallback(this);
        communication.connect(parameters);
        communication.publishActualWill(STATUS_CONNECTION_ONLINE.getBytes());
        communication.subscribe(AGENT+"/#", 0);
        parameters.getLastWillMessage();

    }
    
    // Get the Topic Pathway for Agent
    public static String getTopic(){
       String value = BASE_CONNECTION+"/";
       return value;
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Ouups, lost connection to subscirptions");
        
        if (sensStatus.equals("offline")){
                MqttMessage alertMessage = new MqttMessage();    
                alertMessage.setRetained(true);
                alertMessage.setQos(0);
                alertMessage.setPayload(("Sensor ist OFFLINE!").getBytes());
                    if (sensStatus.equals("online")){
                    alertMessage.setPayload(("Sensor ist Online!").getBytes());
                    communication.publish(PUBLISH_TOPIC +"/SensorStatus",alertMessage);
                    }
                communication.publish(PUBLISH_TOPIC +"/SensorStatus",alertMessage);
                } 
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        
         MqttMessage sqlMessage = new MqttMessage();
            sqlMessage.setPayload((sql).getBytes());
            sqlMessage.setRetained(true);
            sqlMessage.setQos(0);
            communication.publish(PUBLISH_TOPIC +"/sqlStatment:", sqlMessage); 
        

        if (string.endsWith("connection")){
            sensStatus = new String(mm.getPayload());
        }
                
        if (string.endsWith("Value:")) {
            String[] res = string.split("/", 4);
            sensTyp = res[0];
            sensRoom = res[1];
            sensUID = res[2];
            sensValue = new String(mm.getPayload());
            PUBLISH_TOPIC = BASE_CONNECTION + "/" + sensRoom + "/" + sensTyp +"/"+ sensUID;
        }
        
        if (string.endsWith("Date:")) {
            sensDate = new String(mm.getPayload());
        }    

        if (sensTyp != null && sensUID != null && sensRoom != null && sensValue != null && sensDate != null && sensStatus != null){
            sql = "'"+ sensTyp + "', '" + sensUID + "', '" + sensRoom + "', '" + sensValue + "', '" + sensDate + "', '" + sensStatus + "'";   
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    public static void main(String[] args) throws MqttException {
        AgentService service = new AgentService();    
            
                
        
        
                // Subscribe via Broker the Temperatur IR
                service.communication.subscribe(SUBSCRIBE_STIR_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_STIR_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_STIR_STATUS, 0);
                 
                // Subscribe via Broker the Humidity
                service.communication.subscribe(SUBSCRIBE_SH_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SH_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SH_STATUS, 0);
                
                
                // Subscribe via Broker the SoundIntensity Sensor
                service.communication.subscribe(SUBSCRIBE_SSI_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SSI_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SSI_STATUS, 0);
                
                // Subscribe via Broker the Temperatur Sensor 
                service.communication.subscribe(SUBSCRIBE_ST_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_ST_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_ST_STATUS, 0);
                
                // Subscribe via Broker the Ambiente Light Sensor
                service.communication.subscribe(SUBSCRIBE_SAL_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SAL_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SAL_STATUS, 0);
                
                // Subscribe via Broker the Distance IR Sensor
                service.communication.subscribe(SUBSCRIBE_SDIR_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SDIR_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SDIR_STATUS, 0);
                
                // Subscribe via Broker the Distance US Sensor
                service.communication.subscribe(SUBSCRIBE_SDUS_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SDUS_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SDUS_STATUS, 0);
                
                // Subscribe via Broker the Laser Range Finder Sensor
                service.communication.subscribe(SUBSCRIBE_SRF_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SRF_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SRF_STATUS, 0);
                
                // Subscribe via Broker the LoadCell Sensor
                service.communication.subscribe(SUBSCRIBE_SLC_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SLC_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SLC_STATUS, 0);
                
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SMD_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD_STATUS, 0);
                
                // Subscribe via Broker the CO Sensor
                service.communication.subscribe(SUBSCRIBE_SCO_VALUE, 0);
                service.communication.subscribe(SUBSCRIBE_SCO_DATE, 0);
                service.communication.subscribe(SUBRSCRIB_SCO_STATUS, 0);
                
                              
    }

}
