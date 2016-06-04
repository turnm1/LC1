/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

/**
 *
 * @author Turna
 */
public class HostConnection {
   
   private static String MeteHome = "192.168.1.16";    //Mete
   private static String IPEingang = "";
   private static String IPKueche = "";
   private static String IPBad = "";
   private static String IPSchlafzimmer = "10.0.233.153";
   private static String IPSchlafzimmer_Bett = "10.0.233.155";
   private static String IPWohnzimmer = "10.0.233.156";
   private static String HostIPLocalhost = "localhost";
   private static int Port = 4223;
   
    public String getIPEingang(){
        return IPEingang;
    }
    
     public String getIPKueche(){
        return IPKueche;
    }
     
      public String getIPBad(){
        return IPBad;
    }
   
    public String getIPWohnzimmer(){
        return IPWohnzimmer;
    }
    
    public String getIPSchlafzimmer(){
        return IPSchlafzimmer;
    }
    
    public String getIPSchlafzimmer_Bett(){
        return IPSchlafzimmer_Bett;
    }
    
    public String getLocalhost(){
        return HostIPLocalhost;
    }
    
   public int getPort(){
        return Port;
    }

}

