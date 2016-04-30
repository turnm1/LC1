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
   
   private static String HostIP ="192.168.1.16";
   private static String HostIPLocalhost = "localhost";
   private static int Port = 4223;
   
    public String getHostIP(){
        return HostIP;
    }
    
    public String getLocalhost(){
        return HostIPLocalhost;
    }
    
   public int getPort(){
        return Port;
    }

}

