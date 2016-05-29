/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mysql.communication;

import com.agent.AgentService;
import com.communication.MQTTCommunication;
import com.communication.MQTTParameters;
import db.mysql.connection.dbConnection;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Turna
 */
public class dbPush implements MqttCallback {

    public final static String BASE_SENSOR_ID = "Databank";
    public final static String STATUS_TOPIC = BASE_SENSOR_ID + "/status";
    public final static String STATUS_TOPIC_CONNECTION = STATUS_TOPIC + "/connection";
    public final static String STATUS_CONNECTION_OFFLINE = "offline";
    public final static String STATUS_CONNECTION_ONLINE = "online";

    public static Connection connection;
    private final MQTTCommunication communication;
    
    private static AgentService as;
    private final static String AGENT = as.getTopic();
    
    public static String sqlStatment = null;


    
    public dbPush() throws MqttException {
        communication = new MQTTCommunication();
        MQTTParameters parameters = new MQTTParameters();
        parameters.setClientID(BASE_SENSOR_ID);
        parameters.setIsCleanSession(false);
        parameters.setIsLastWillRetained(true);
        parameters.setLastWillMessage(STATUS_CONNECTION_OFFLINE.getBytes());
        parameters.setLastWillQoS(1);
        parameters.setServerURIs(URI.create("tcp://127.0.0.1:1883"));
        parameters.setWillTopic(STATUS_TOPIC_CONNECTION);
        parameters.setMqttCallback(this);
        communication.connect(parameters);
        communication.publishActualWill(STATUS_CONNECTION_ONLINE.getBytes());
        //communication.subscribe(BASE_SENSOR_ID + "/#", 0);
        parameters.getLastWillMessage();
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Ouups, lost connection to subscirptions");
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        //System.out.printf("Message has been delivered and is back again. Topic: %s, Message: %s \n", string, new String(mm.getPayload()));
       
        if (string.endsWith("sqlStatment:")){
            sqlStatment = new String(mm.getPayload());
            System.out.println(sqlStatment);
            String dbTable = "sensordata";
            connection();
            String sql = " INSERT INTO " + dbTable + " VALUES ("+sqlStatment+");";
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        System.out.println("Delivery is done.");
    }

    
    public static void connection() {
        try {
            String serverName = "localhost";
            String mydatabase = "aal_test";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "doctor";
            String password = "doctorpw";
            
            try {
            connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    public static void main(String[] args) throws MqttException {

        dbPush service = new dbPush();
        service.communication.subscribe("AGENT/#", 0);
       //service.communication.subscribe(AGENT+"/#", 0);

    }

}
