/*
 * Within this step, a service is using the MQTTCommunication.
 * It shows primitive state information about online / offline via last will topic
 */
package com.agent;



import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import com.sensor.DistanceUs.ServiceDistanceUs;
import com.sensor.ambientlight.ServiceAmbientLight;
import com.sensor.ambientlight.ServiceAmbientLight1;
import com.sensor.ambientlight.ServiceAmbientLight2;
import com.sensor.ambientlight.ServiceAmbientLight3;
import com.sensor.ambientlight.ServiceAmbientLight4;
import com.sensor.ambientlight.ServiceAmbientLight5;
import com.sensor.co2.ServiceCo2;
import com.sensor.co2.ServiceCo2_1;
import com.sensor.distanceIr.ServiceDistanceIr;
import com.sensor.distanceIr.ServiceDistanceIr1;
import com.sensor.distanceIr.ServiceDistanceIr2;
import com.sensor.distanceIr.ServiceDistanceIr3;
import com.sensor.distanceIr.ServiceDistanceIr4;
import com.sensor.distanceIr.ServiceDistanceIr5;
import com.sensor.humidity.ServiceHumidity;
import com.sensor.laserrangefinder.ServiceLaserRangeFinder;
import com.sensor.laserrangefinder.ServiceLaserRangeFinder1;
import com.sensor.loadcell.ServiceLoadCell;
import com.sensor.loadcell.ServiceLoadCell1;
import com.sensor.loadcell.ServiceLoadCell2;
import com.sensor.loadcell.ServiceLoadCell3;
import com.sensor.motiondetector.ServiceMotiondetector;
import com.sensor.motiondetector.ServiceMotiondetector5;
import com.sensor.soundintensity.ServiceSoundIntensity;
import com.sensor.temperatur.ServiceTemperatur;
import com.sensor.temperatur.ServiceTemperatur1;
import com.sensor.temperatur.ServiceTemperatur2;
import com.sensor.temperatur.ServiceTemperatur3;
import com.sensor.temperatur.ServiceTemperatur4;
import com.sensor.temperatur.ServiceTemperatur5;
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
   private final static String SUBRSCRIB_SSI_STATUS = ssi.getTopicStatus();
   
   // Humidity
   private static ServiceHumidity sh;
   private final static String SUBSCRIBE_SH_VALUE = sh.getTopicValue();
   private final static String SUBRSCRIB_SH_STATUS = sh.getTopicStatus();
   
   // Temperatur IR
   private static ServiceTemperaturIr stir;
   private final static String SUBSCRIBE_STIR_VALUE = stir.getTopicValue();
   private final static String SUBRSCRIB_STIR_STATUS = stir.getTopicStatus();
    
   // Temperatur
   private static ServiceTemperatur st;
   private final static String SUBSCRIBE_ST_VALUE = st.getTopicValue();
   private final static String SUBRSCRIB_ST_STATUS = st.getTopicStatus();
   private static ServiceTemperatur1 st1;
   private final static String SUBSCRIBE_ST1_VALUE = st1.getTopicValue();
   private final static String SUBRSCRIB_ST1_STATUS = st1.getTopicStatus();
   private static ServiceTemperatur2 st2;
   private final static String SUBSCRIBE_ST2_VALUE = st2.getTopicValue();
   private final static String SUBRSCRIB_ST2_STATUS = st2.getTopicStatus();
   private static ServiceTemperatur3 st3;
   private final static String SUBSCRIBE_ST3_VALUE = st3.getTopicValue();
   private final static String SUBRSCRIB_ST3_STATUS = st3.getTopicStatus();
   private static ServiceTemperatur4 st4;
   private final static String SUBSCRIBE_ST4_VALUE = st4.getTopicValue();
   private final static String SUBRSCRIB_ST4_STATUS = st4.getTopicStatus();
   private static ServiceTemperatur5 st5;
   private final static String SUBSCRIBE_ST5_VALUE = st5.getTopicValue();
   private final static String SUBRSCRIB_ST5_STATUS = st5.getTopicStatus();
 
   // Motion Detectore
   private static ServiceMotiondetector smd;
   private final static String SUBSCRIBE_SMD_VALUE = smd.getTopicValue();
   private final static String SUBRSCRIB_SMD_STATUS = smd.getTopicStatus();
   private static ServiceMotiondetector smd1;
   private final static String SUBSCRIBE_SMD1_VALUE = smd1.getTopicValue();
   private final static String SUBRSCRIB_SMD1_STATUS = smd1.getTopicStatus();
   private static ServiceMotiondetector smd2;
   private final static String SUBSCRIBE_SMD2_VALUE = smd2.getTopicValue();
   private final static String SUBRSCRIB_SMD2_STATUS = smd2.getTopicStatus();
   private static ServiceMotiondetector smd3;
   private final static String SUBSCRIBE_SMD3_VALUE = smd3.getTopicValue();
   private final static String SUBRSCRIB_SMD3_STATUS = smd3.getTopicStatus();
   private static ServiceMotiondetector smd4;
   private final static String SUBSCRIBE_SMD4_VALUE = smd4.getTopicValue();
   private final static String SUBRSCRIB_SMD4_STATUS = smd4.getTopicStatus();
   private static ServiceMotiondetector5 smd5;
   private final static String SUBSCRIBE_SMD5_VALUE = smd5.getTopicValue();
   private final static String SUBRSCRIB_SMD5_STATUS = smd5.getTopicStatus();
   
   // Load Cell
   private static ServiceLoadCell slc;
   private final static String SUBSCRIBE_SLC_VALUE = slc.getTopicValue();
   private final static String SUBRSCRIB_SLC_STATUS = slc.getTopicStatus();
   private static ServiceLoadCell1 slc1;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC1_VALUE = slc1.getTopicValue();
   private final static String SUBRSCRIB_SLC1_STATUS = slc1.getTopicStatus();
   private static ServiceLoadCell2 slc2;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC2_VALUE = slc2.getTopicValue();
   private final static String SUBRSCRIB_SLC2_STATUS = slc2.getTopicStatus();
   private static ServiceLoadCell3 slc3;          // Sitzen oder Liegen
   private final static String SUBSCRIBE_SLC3_VALUE = slc3.getTopicValue();
   private final static String SUBRSCRIB_SLC3_STATUS = slc3.getTopicStatus();
   
   // Laser Range Finder
   private static ServiceLaserRangeFinder srf;
   private final static String SUBSCRIBE_SRF_VALUE = srf.getTopicValue();
   private final static String SUBRSCRIB_SRF_STATUS = srf.getTopicStatus();
   private static ServiceLaserRangeFinder1 srf1;
   private final static String SUBSCRIBE_SRF1_VALUE = srf1.getTopicValue();
   private final static String SUBRSCRIB_SRF1_STATUS = srf1.getTopicStatus();
   
   // Distance US
   private static ServiceDistanceUs sdus;
   private final static String SUBSCRIBE_SDUS_VALUE = sdus.getTopicValue();
   private final static String SUBRSCRIB_SDUS_STATUS = sdus.getTopicStatus();
   
   // Dinstance IR
   private static ServiceDistanceIr sdir;
   private final static String SUBSCRIBE_SDIR_VALUE = sdir.getTopicValue();
   private final static String SUBRSCRIB_SDIR_STATUS = sdir.getTopicStatus();
   private static ServiceDistanceIr1 sdir1;
   private final static String SUBSCRIBE_SDIR1_VALUE = sdir1.getTopicValue();
   private final static String SUBRSCRIB_SDIR1_STATUS = sdir1.getTopicStatus();
   private static ServiceDistanceIr2 sdir2;
   private final static String SUBSCRIBE_SDIR2_VALUE = sdir2.getTopicValue();
   private final static String SUBRSCRIB_SDIR2_STATUS = sdir2.getTopicStatus();
   private static ServiceDistanceIr3 sdir3;
   private final static String SUBSCRIBE_SDIR3_VALUE = sdir3.getTopicValue();
   private final static String SUBRSCRIB_SDIR3_STATUS = sdir3.getTopicStatus();
   private static ServiceDistanceIr4 sdir4;
   private final static String SUBSCRIBE_SDIR4_VALUE = sdir4.getTopicValue();
   private final static String SUBRSCRIB_SDIR4_STATUS = sdir4.getTopicStatus();
   private static ServiceDistanceIr5 sdir5;
   private final static String SUBSCRIBE_SDIR5_VALUE = sdir5.getTopicValue();
   private final static String SUBRSCRIB_SDIR5_STATUS = sdir5.getTopicStatus();
   
   // CO2
   private static ServiceCo2 sco;
   private final static String SUBSCRIBE_SCO_VALUE = sco.getTopicValue();
   private final static String SUBRSCRIB_SCO_STATUS = sco.getTopicStatus();
   private static ServiceCo2_1 sco1;
   private final static String SUBSCRIBE_SCO1_VALUE = sco1.getTopicValue();
   private final static String SUBRSCRIB_SCO1_STATUS = sco1.getTopicStatus();

   
   // Ambiente Light
   private static ServiceAmbientLight sal;
   private final static String SUBSCRIBE_SAL_VALUE = sal.getTopicValue();
   private final static String SUBRSCRIB_SAL_STATUS = sal.getTopicStatus();
   private static ServiceAmbientLight1 sal1;
   private final static String SUBSCRIBE_SAL1_VALUE = sal1.getTopicValue();
   private final static String SUBRSCRIB_SAL1_STATUS = sal1.getTopicStatus();
   private static ServiceAmbientLight2 sal2;
   private final static String SUBSCRIBE_SAL2_VALUE = sal2.getTopicValue();
   private final static String SUBRSCRIB_SAL2_STATUS = sal2.getTopicStatus();
   private static ServiceAmbientLight3 sal3;
   private final static String SUBSCRIBE_SAL3_VALUE = sal3.getTopicValue();
   private final static String SUBRSCRIB_SAL3_STATUS = sal3.getTopicStatus();
   private static ServiceAmbientLight4 sal4;
   private final static String SUBSCRIBE_SAL4_VALUE = sal4.getTopicValue();
   private final static String SUBRSCRIB_SAL4_STATUS = sal4.getTopicStatus();
   private static ServiceAmbientLight5 sal5;
   private final static String SUBSCRIBE_SAL5_VALUE = sal5.getTopicValue();
   private final static String SUBRSCRIB_SAL5_STATUS = sal5.getTopicStatus();
    
   
    private static String sensTyp = "";
    private static String sensUID = null;
    private static String sensStatus = "";
    private static String sensRoom = null;
    private static String sensDate = "";
    private static String sensValue = null;
    private static String valueDate = "";
   
    // Agent Pathways
    public final static String AGENT = "AGENT"; 
    public final static String CLIENT_ID = "DBPusher";
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
         
       

        if (string.endsWith("connection")){
            sensStatus = new String(mm.getPayload());
        }
                
        if (string.endsWith("Value:")) {
            String[] res = string.split("/", 4);
            sensTyp = res[0];
            sensRoom = res[1];
            sensUID = res[2];
            
            valueDate = new String(mm.getPayload());
            String [] vd = valueDate.split("/",2);
            sensValue = vd[0];
            sensDate = vd[1];
            
            PUBLISH_TOPIC = BASE_CONNECTION + "/" + sensRoom + "/" + sensTyp +"/"+ sensUID;
            sql = "'"+ sensTyp + "', '" + sensUID + "', '" + sensRoom + "', '" + sensValue + "', '" + sensDate + "', '" + sensStatus + "'";
                
                if (!sensValue.equals(new String(mm.getPayload()))){
                   communication.publish(PUBLISH_TOPIC +"/sqlStatment:", sqlMessage); 
               }
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
                service.communication.subscribe(SUBRSCRIB_STIR_STATUS, 0);
                 
                // Subscribe via Broker the Humidity
                service.communication.subscribe(SUBSCRIBE_SH_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SH_STATUS, 0);
                
                
                // Subscribe via Broker the SoundIntensity Sensor
                service.communication.subscribe(SUBSCRIBE_SSI_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SSI_STATUS, 0);
                
                // Subscribe via Broker the Temperatur Sensor 
                service.communication.subscribe(SUBSCRIBE_ST_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_ST_STATUS, 0);
                
                // Subscribe via Broker the Ambiente Light Sensor
                service.communication.subscribe(SUBSCRIBE_SAL_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SAL_STATUS, 0);
                
                // Subscribe via Broker the Distance IR Sensor
                service.communication.subscribe(SUBSCRIBE_SDIR_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SDIR_STATUS, 0);
                service.communication.subscribe(SUBSCRIBE_SDIR5_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SDIR5_STATUS, 0);
                
                // Subscribe via Broker the Distance US Sensor
                service.communication.subscribe(SUBSCRIBE_SDUS_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SDUS_STATUS, 0);
                
                // Subscribe via Broker the Laser Range Finder Sensor
                service.communication.subscribe(SUBSCRIBE_SRF_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SRF_STATUS, 0);
                // Subscribe via Broker the Laser Range Finder Sensor 1
                service.communication.subscribe(SUBSCRIBE_SRF_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SRF_STATUS, 0);
                
                // Subscribe via Broker the LoadCell Sensor
                service.communication.subscribe(SUBSCRIBE_SLC_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SLC_STATUS, 0);
                // Subscribe via Broker the LoadCell 1 Sensor
                service.communication.subscribe(SUBSCRIBE_SLC1_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SLC1_STATUS, 0);
                // Subscribe via Broker the LoadCell 2 Sensor
                service.communication.subscribe(SUBSCRIBE_SLC2_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SLC2_STATUS, 0);
                // Subscribe via Broker the LoadCell 3 Sensor
                service.communication.subscribe(SUBSCRIBE_SLC3_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SLC3_STATUS, 0);
                
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD_STATUS, 0);
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD1_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD1_STATUS, 0);
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD2_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD2_STATUS, 0);
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD3_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD3_STATUS, 0);
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD4_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD4_STATUS, 0);
                // Subscribe via Broker the Motion Sensor
                service.communication.subscribe(SUBSCRIBE_SMD5_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SMD5_STATUS, 0);
                
                // Subscribe via Broker the CO Sensor
                service.communication.subscribe(SUBSCRIBE_SCO_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SCO_STATUS, 0);
                // Subscribe via Broker the CO Sensor 1
                service.communication.subscribe(SUBSCRIBE_SCO1_VALUE, 0);
                service.communication.subscribe(SUBRSCRIB_SCO1_STATUS, 0);
                           
   
    }
}
