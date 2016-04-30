/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Turna
 */
public class DateInput {
     Date dt = new Date();
     SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S" );
     private String date = "";
     
     public String getDate(){
       df.setTimeZone( TimeZone.getDefault() );               
        date = df.format( dt );     
        return date;
     }
     
 }
