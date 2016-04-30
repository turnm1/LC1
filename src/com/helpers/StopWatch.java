/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author Turna
 */
public class StopWatch {
    
    Instant startTime, endTime;
    Duration duration;
    boolean isRunning = false;
    

    public void start() {
        if (isRunning) {
            throw new RuntimeException("Stopwatch is already running.");
        }
        this.isRunning = true;
        startTime = Instant.now();
    }

    public void stop() {
        this.endTime = Instant.now();
        if (!isRunning) {
            throw new RuntimeException("Stopwatch has not been started yet");
        }
        isRunning = false;
        Duration result = Duration.between(startTime, endTime);
        if (this.duration == null) {
            this.duration = result;
        } else {
            this.duration = duration.plus(result);
        }
    }

    public String getElapsedTime() {
        String s = String.format("%d:%02d%n", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
        return s;
    }
   

    public void reset() {
        if (this.isRunning) {
            this.stop();
        }
        this.duration = null;
    }
    
}
