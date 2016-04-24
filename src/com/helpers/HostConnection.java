/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

import java.util.Scanner;

/**
 *
 * @author Turna
 */
public class HostConnection {
   
   public static String HostIP ="";
   public static int Port;
   
    public static void setHostIP(){
        Scanner sc = new Scanner(System.in);
        HostIP = sc.next();
    }
    
    public String getHostIP(){
        return HostIP;
    }
 
    public static void setPort(){
        Scanner sc = new Scanner(System.in);
        String stringPort = sc.next();
        Port = Integer.parseInt(stringPort);
    }
    
   public int getPort(){
        return Port;
    }

    
 public static void main(String[] args)
  {
    System.out.println("Host IP eingeben: ");
    setHostIP();
    System.out.println("Port eingeben: ");
    setPort();
    System.out.println("Gespeicherte Verbindung:");
    System.out.println("HostIP: "+HostIP);
    System.out.println("Port: "+Port);
  }
}

