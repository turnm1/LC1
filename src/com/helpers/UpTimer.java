/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Turna
 */
public class UpTimer extends TimerTask
{
   public void startT()
   {
       run();
   }

   @Override
   public void run()
   {
      System.out.println(new Date().getSeconds());
   }
}
