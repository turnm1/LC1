/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Turna
 */
public class DownTimer extends TimerTask{
   Timer timer=null;

   public DownTimer(Timer timer)
   {
      this.timer = timer;
   }

   @Override
   public void run()
   {
      System.out.println(new Date());
      if(timer!=null) timer.cancel();  // beendet den Timer
   }
}