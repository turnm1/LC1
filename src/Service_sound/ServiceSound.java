/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_sound;

import com.tinkerforge.BrickletSoundIntensity;
import com.tinkerforge.IPConnection;
/**
 *
 * @author Turna
 */
public class ServiceSound {
    
    private static final String HOST = "localhost";
    private static final int PORT = 4223;
    private static final String UID = "qSG"; // Change to your UID

    // Note: To make the example code cleaner we do not handle exceptions. Exceptions
    //       you might normally want to catch are described in the documentation
    public static void main(String args[]) throws Exception {
        IPConnection ipcon = new IPConnection(); // Create IP connection
        BrickletSoundIntensity si = new BrickletSoundIntensity(UID, ipcon); // Create device object

        ipcon.connect(HOST, PORT); // Connect to brickd
        // Don't use device before ipcon is connected

        // Get current intensity
        int intensity = si.getIntensity(); // Can throw com.tinkerforge.TimeoutException
        System.out.println("Intensity: " + intensity);

        System.out.println("Press key to exit"); System.in.read();
        ipcon.disconnect();
    }
    
}
