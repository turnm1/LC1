/* ***********************************************************
 * This file was automatically generated on 2016-02-10.      *
 *                                                           *
 * Java Bindings Version 2.1.8                               *
 *                                                           *
 * If you have a bugfix for this file and want to commit it, *
 * please fix the bug in the generator. You can find a link  *
 * to the generators git repository on tinkerforge.com       *
 *************************************************************/

package com.tinkerforge;

public class DeviceFactory {
	public static Class<? extends Device> getDeviceClass(int deviceIdentifier) {
		switch (deviceIdentifier) {
		case BrickDC.DEVICE_IDENTIFIER: return BrickDC.class;
		case BrickIMU.DEVICE_IDENTIFIER: return BrickIMU.class;
		case BrickIMUV2.DEVICE_IDENTIFIER: return BrickIMUV2.class;
		case BrickMaster.DEVICE_IDENTIFIER: return BrickMaster.class;
		case BrickRED.DEVICE_IDENTIFIER: return BrickRED.class;
		case BrickServo.DEVICE_IDENTIFIER: return BrickServo.class;
		case BrickStepper.DEVICE_IDENTIFIER: return BrickStepper.class;
		case BrickletAccelerometer.DEVICE_IDENTIFIER: return BrickletAccelerometer.class;
		case BrickletAmbientLight.DEVICE_IDENTIFIER: return BrickletAmbientLight.class;
		case BrickletAmbientLightV2.DEVICE_IDENTIFIER: return BrickletAmbientLightV2.class;
		case BrickletAnalogIn.DEVICE_IDENTIFIER: return BrickletAnalogIn.class;
		case BrickletAnalogInV2.DEVICE_IDENTIFIER: return BrickletAnalogInV2.class;
		case BrickletAnalogOut.DEVICE_IDENTIFIER: return BrickletAnalogOut.class;
		case BrickletAnalogOutV2.DEVICE_IDENTIFIER: return BrickletAnalogOutV2.class;
		case BrickletBarometer.DEVICE_IDENTIFIER: return BrickletBarometer.class;
		case BrickletCO2.DEVICE_IDENTIFIER: return BrickletCO2.class;
		case BrickletColor.DEVICE_IDENTIFIER: return BrickletColor.class;
		case BrickletCurrent12.DEVICE_IDENTIFIER: return BrickletCurrent12.class;
		case BrickletCurrent25.DEVICE_IDENTIFIER: return BrickletCurrent25.class;
		case BrickletDistanceIR.DEVICE_IDENTIFIER: return BrickletDistanceIR.class;
		case BrickletDistanceUS.DEVICE_IDENTIFIER: return BrickletDistanceUS.class;
		case BrickletDualButton.DEVICE_IDENTIFIER: return BrickletDualButton.class;
		case BrickletDualRelay.DEVICE_IDENTIFIER: return BrickletDualRelay.class;
		case BrickletDustDetector.DEVICE_IDENTIFIER: return BrickletDustDetector.class;
		case BrickletGPS.DEVICE_IDENTIFIER: return BrickletGPS.class;
		case BrickletHallEffect.DEVICE_IDENTIFIER: return BrickletHallEffect.class;
		case BrickletHumidity.DEVICE_IDENTIFIER: return BrickletHumidity.class;
		case BrickletIO16.DEVICE_IDENTIFIER: return BrickletIO16.class;
		case BrickletIO4.DEVICE_IDENTIFIER: return BrickletIO4.class;
		case BrickletIndustrialAnalogOut.DEVICE_IDENTIFIER: return BrickletIndustrialAnalogOut.class;
		case BrickletIndustrialDigitalIn4.DEVICE_IDENTIFIER: return BrickletIndustrialDigitalIn4.class;
		case BrickletIndustrialDigitalOut4.DEVICE_IDENTIFIER: return BrickletIndustrialDigitalOut4.class;
		case BrickletIndustrialDual020mA.DEVICE_IDENTIFIER: return BrickletIndustrialDual020mA.class;
		case BrickletIndustrialDualAnalogIn.DEVICE_IDENTIFIER: return BrickletIndustrialDualAnalogIn.class;
		case BrickletIndustrialQuadRelay.DEVICE_IDENTIFIER: return BrickletIndustrialQuadRelay.class;
		case BrickletJoystick.DEVICE_IDENTIFIER: return BrickletJoystick.class;
		case BrickletLCD16x2.DEVICE_IDENTIFIER: return BrickletLCD16x2.class;
		case BrickletLCD20x4.DEVICE_IDENTIFIER: return BrickletLCD20x4.class;
		case BrickletLEDStrip.DEVICE_IDENTIFIER: return BrickletLEDStrip.class;
		case BrickletLaserRangeFinder.DEVICE_IDENTIFIER: return BrickletLaserRangeFinder.class;
		case BrickletLine.DEVICE_IDENTIFIER: return BrickletLine.class;
		case BrickletLinearPoti.DEVICE_IDENTIFIER: return BrickletLinearPoti.class;
		case BrickletLoadCell.DEVICE_IDENTIFIER: return BrickletLoadCell.class;
		case BrickletMoisture.DEVICE_IDENTIFIER: return BrickletMoisture.class;
		case BrickletMotionDetector.DEVICE_IDENTIFIER: return BrickletMotionDetector.class;
		case BrickletMultiTouch.DEVICE_IDENTIFIER: return BrickletMultiTouch.class;
		case BrickletNFCRFID.DEVICE_IDENTIFIER: return BrickletNFCRFID.class;
		case BrickletOLED128x64.DEVICE_IDENTIFIER: return BrickletOLED128x64.class;
		case BrickletOLED64x48.DEVICE_IDENTIFIER: return BrickletOLED64x48.class;
		case BrickletPTC.DEVICE_IDENTIFIER: return BrickletPTC.class;
		case BrickletPiezoBuzzer.DEVICE_IDENTIFIER: return BrickletPiezoBuzzer.class;
		case BrickletPiezoSpeaker.DEVICE_IDENTIFIER: return BrickletPiezoSpeaker.class;
		case BrickletRS232.DEVICE_IDENTIFIER: return BrickletRS232.class;
		case BrickletRealTimeClock.DEVICE_IDENTIFIER: return BrickletRealTimeClock.class;
		case BrickletRemoteSwitch.DEVICE_IDENTIFIER: return BrickletRemoteSwitch.class;
		case BrickletRotaryEncoder.DEVICE_IDENTIFIER: return BrickletRotaryEncoder.class;
		case BrickletRotaryPoti.DEVICE_IDENTIFIER: return BrickletRotaryPoti.class;
		case BrickletSegmentDisplay4x7.DEVICE_IDENTIFIER: return BrickletSegmentDisplay4x7.class;
		case BrickletSolidStateRelay.DEVICE_IDENTIFIER: return BrickletSolidStateRelay.class;
		case BrickletSoundIntensity.DEVICE_IDENTIFIER: return BrickletSoundIntensity.class;
		case BrickletTemperature.DEVICE_IDENTIFIER: return BrickletTemperature.class;
		case BrickletTemperatureIR.DEVICE_IDENTIFIER: return BrickletTemperatureIR.class;
		case BrickletThermocouple.DEVICE_IDENTIFIER: return BrickletThermocouple.class;
		case BrickletTilt.DEVICE_IDENTIFIER: return BrickletTilt.class;
		case BrickletUVLight.DEVICE_IDENTIFIER: return BrickletUVLight.class;
		case BrickletVoltage.DEVICE_IDENTIFIER: return BrickletVoltage.class;
		case BrickletVoltageCurrent.DEVICE_IDENTIFIER: return BrickletVoltageCurrent.class;
		default: throw new IllegalArgumentException("Unknown device identifier: " + deviceIdentifier);
		}
	}

	public static String getDeviceDisplayName(int deviceIdentifier) {
		switch (deviceIdentifier) {
		case BrickDC.DEVICE_IDENTIFIER: return BrickDC.DEVICE_DISPLAY_NAME;
		case BrickIMU.DEVICE_IDENTIFIER: return BrickIMU.DEVICE_DISPLAY_NAME;
		case BrickIMUV2.DEVICE_IDENTIFIER: return BrickIMUV2.DEVICE_DISPLAY_NAME;
		case BrickMaster.DEVICE_IDENTIFIER: return BrickMaster.DEVICE_DISPLAY_NAME;
		case BrickRED.DEVICE_IDENTIFIER: return BrickRED.DEVICE_DISPLAY_NAME;
		case BrickServo.DEVICE_IDENTIFIER: return BrickServo.DEVICE_DISPLAY_NAME;
		case BrickStepper.DEVICE_IDENTIFIER: return BrickStepper.DEVICE_DISPLAY_NAME;
		case BrickletAccelerometer.DEVICE_IDENTIFIER: return BrickletAccelerometer.DEVICE_DISPLAY_NAME;
		case BrickletAmbientLight.DEVICE_IDENTIFIER: return BrickletAmbientLight.DEVICE_DISPLAY_NAME;
		case BrickletAmbientLightV2.DEVICE_IDENTIFIER: return BrickletAmbientLightV2.DEVICE_DISPLAY_NAME;
		case BrickletAnalogIn.DEVICE_IDENTIFIER: return BrickletAnalogIn.DEVICE_DISPLAY_NAME;
		case BrickletAnalogInV2.DEVICE_IDENTIFIER: return BrickletAnalogInV2.DEVICE_DISPLAY_NAME;
		case BrickletAnalogOut.DEVICE_IDENTIFIER: return BrickletAnalogOut.DEVICE_DISPLAY_NAME;
		case BrickletAnalogOutV2.DEVICE_IDENTIFIER: return BrickletAnalogOutV2.DEVICE_DISPLAY_NAME;
		case BrickletBarometer.DEVICE_IDENTIFIER: return BrickletBarometer.DEVICE_DISPLAY_NAME;
		case BrickletCO2.DEVICE_IDENTIFIER: return BrickletCO2.DEVICE_DISPLAY_NAME;
		case BrickletColor.DEVICE_IDENTIFIER: return BrickletColor.DEVICE_DISPLAY_NAME;
		case BrickletCurrent12.DEVICE_IDENTIFIER: return BrickletCurrent12.DEVICE_DISPLAY_NAME;
		case BrickletCurrent25.DEVICE_IDENTIFIER: return BrickletCurrent25.DEVICE_DISPLAY_NAME;
		case BrickletDistanceIR.DEVICE_IDENTIFIER: return BrickletDistanceIR.DEVICE_DISPLAY_NAME;
		case BrickletDistanceUS.DEVICE_IDENTIFIER: return BrickletDistanceUS.DEVICE_DISPLAY_NAME;
		case BrickletDualButton.DEVICE_IDENTIFIER: return BrickletDualButton.DEVICE_DISPLAY_NAME;
		case BrickletDualRelay.DEVICE_IDENTIFIER: return BrickletDualRelay.DEVICE_DISPLAY_NAME;
		case BrickletDustDetector.DEVICE_IDENTIFIER: return BrickletDustDetector.DEVICE_DISPLAY_NAME;
		case BrickletGPS.DEVICE_IDENTIFIER: return BrickletGPS.DEVICE_DISPLAY_NAME;
		case BrickletHallEffect.DEVICE_IDENTIFIER: return BrickletHallEffect.DEVICE_DISPLAY_NAME;
		case BrickletHumidity.DEVICE_IDENTIFIER: return BrickletHumidity.DEVICE_DISPLAY_NAME;
		case BrickletIO16.DEVICE_IDENTIFIER: return BrickletIO16.DEVICE_DISPLAY_NAME;
		case BrickletIO4.DEVICE_IDENTIFIER: return BrickletIO4.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialAnalogOut.DEVICE_IDENTIFIER: return BrickletIndustrialAnalogOut.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialDigitalIn4.DEVICE_IDENTIFIER: return BrickletIndustrialDigitalIn4.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialDigitalOut4.DEVICE_IDENTIFIER: return BrickletIndustrialDigitalOut4.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialDual020mA.DEVICE_IDENTIFIER: return BrickletIndustrialDual020mA.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialDualAnalogIn.DEVICE_IDENTIFIER: return BrickletIndustrialDualAnalogIn.DEVICE_DISPLAY_NAME;
		case BrickletIndustrialQuadRelay.DEVICE_IDENTIFIER: return BrickletIndustrialQuadRelay.DEVICE_DISPLAY_NAME;
		case BrickletJoystick.DEVICE_IDENTIFIER: return BrickletJoystick.DEVICE_DISPLAY_NAME;
		case BrickletLCD16x2.DEVICE_IDENTIFIER: return BrickletLCD16x2.DEVICE_DISPLAY_NAME;
		case BrickletLCD20x4.DEVICE_IDENTIFIER: return BrickletLCD20x4.DEVICE_DISPLAY_NAME;
		case BrickletLEDStrip.DEVICE_IDENTIFIER: return BrickletLEDStrip.DEVICE_DISPLAY_NAME;
		case BrickletLaserRangeFinder.DEVICE_IDENTIFIER: return BrickletLaserRangeFinder.DEVICE_DISPLAY_NAME;
		case BrickletLine.DEVICE_IDENTIFIER: return BrickletLine.DEVICE_DISPLAY_NAME;
		case BrickletLinearPoti.DEVICE_IDENTIFIER: return BrickletLinearPoti.DEVICE_DISPLAY_NAME;
		case BrickletLoadCell.DEVICE_IDENTIFIER: return BrickletLoadCell.DEVICE_DISPLAY_NAME;
		case BrickletMoisture.DEVICE_IDENTIFIER: return BrickletMoisture.DEVICE_DISPLAY_NAME;
		case BrickletMotionDetector.DEVICE_IDENTIFIER: return BrickletMotionDetector.DEVICE_DISPLAY_NAME;
		case BrickletMultiTouch.DEVICE_IDENTIFIER: return BrickletMultiTouch.DEVICE_DISPLAY_NAME;
		case BrickletNFCRFID.DEVICE_IDENTIFIER: return BrickletNFCRFID.DEVICE_DISPLAY_NAME;
		case BrickletOLED128x64.DEVICE_IDENTIFIER: return BrickletOLED128x64.DEVICE_DISPLAY_NAME;
		case BrickletOLED64x48.DEVICE_IDENTIFIER: return BrickletOLED64x48.DEVICE_DISPLAY_NAME;
		case BrickletPTC.DEVICE_IDENTIFIER: return BrickletPTC.DEVICE_DISPLAY_NAME;
		case BrickletPiezoBuzzer.DEVICE_IDENTIFIER: return BrickletPiezoBuzzer.DEVICE_DISPLAY_NAME;
		case BrickletPiezoSpeaker.DEVICE_IDENTIFIER: return BrickletPiezoSpeaker.DEVICE_DISPLAY_NAME;
		case BrickletRS232.DEVICE_IDENTIFIER: return BrickletRS232.DEVICE_DISPLAY_NAME;
		case BrickletRealTimeClock.DEVICE_IDENTIFIER: return BrickletRealTimeClock.DEVICE_DISPLAY_NAME;
		case BrickletRemoteSwitch.DEVICE_IDENTIFIER: return BrickletRemoteSwitch.DEVICE_DISPLAY_NAME;
		case BrickletRotaryEncoder.DEVICE_IDENTIFIER: return BrickletRotaryEncoder.DEVICE_DISPLAY_NAME;
		case BrickletRotaryPoti.DEVICE_IDENTIFIER: return BrickletRotaryPoti.DEVICE_DISPLAY_NAME;
		case BrickletSegmentDisplay4x7.DEVICE_IDENTIFIER: return BrickletSegmentDisplay4x7.DEVICE_DISPLAY_NAME;
		case BrickletSolidStateRelay.DEVICE_IDENTIFIER: return BrickletSolidStateRelay.DEVICE_DISPLAY_NAME;
		case BrickletSoundIntensity.DEVICE_IDENTIFIER: return BrickletSoundIntensity.DEVICE_DISPLAY_NAME;
		case BrickletTemperature.DEVICE_IDENTIFIER: return BrickletTemperature.DEVICE_DISPLAY_NAME;
		case BrickletTemperatureIR.DEVICE_IDENTIFIER: return BrickletTemperatureIR.DEVICE_DISPLAY_NAME;
		case BrickletThermocouple.DEVICE_IDENTIFIER: return BrickletThermocouple.DEVICE_DISPLAY_NAME;
		case BrickletTilt.DEVICE_IDENTIFIER: return BrickletTilt.DEVICE_DISPLAY_NAME;
		case BrickletUVLight.DEVICE_IDENTIFIER: return BrickletUVLight.DEVICE_DISPLAY_NAME;
		case BrickletVoltage.DEVICE_IDENTIFIER: return BrickletVoltage.DEVICE_DISPLAY_NAME;
		case BrickletVoltageCurrent.DEVICE_IDENTIFIER: return BrickletVoltageCurrent.DEVICE_DISPLAY_NAME;
		default: throw new IllegalArgumentException("Unknown device identifier: " + deviceIdentifier);
		}
	}

	public static Device createDevice(int deviceIdentifier, String uid, IPConnection ipcon) throws Exception {
		return getDeviceClass(deviceIdentifier).getConstructor(String.class, IPConnection.class).newInstance(uid, ipcon);
	}
}
