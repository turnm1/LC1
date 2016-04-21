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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generates configurable DC voltage and current, 0V to 10V and 4mA to 20mA
 */
public class BrickletIndustrialAnalogOut extends Device {
	public final static int DEVICE_IDENTIFIER = 258;
	public final static String DEVICE_DISPLAY_NAME = "Industrial Analog Out Bricklet";

	public final static byte FUNCTION_ENABLE = (byte)1;
	public final static byte FUNCTION_DISABLE = (byte)2;
	public final static byte FUNCTION_IS_ENABLED = (byte)3;
	public final static byte FUNCTION_SET_VOLTAGE = (byte)4;
	public final static byte FUNCTION_GET_VOLTAGE = (byte)5;
	public final static byte FUNCTION_SET_CURRENT = (byte)6;
	public final static byte FUNCTION_GET_CURRENT = (byte)7;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)8;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)9;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static short VOLTAGE_RANGE_0_TO_5V = (short)0;
	public final static short VOLTAGE_RANGE_0_TO_10V = (short)1;
	public final static short CURRENT_RANGE_4_TO_20MA = (short)0;
	public final static short CURRENT_RANGE_0_TO_20MA = (short)1;
	public final static short CURRENT_RANGE_0_TO_24MA = (short)2;


	public class Configuration {
		public short voltageRange;
		public short currentRange;

		public String toString() {
			return "[" + "voltageRange = " + voltageRange + ", " + "currentRange = " + currentRange + "]";
		}
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletIndustrialAnalogOut(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ENABLE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_DISABLE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_ENABLED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CURRENT)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CURRENT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
	}

	/**
	 * Enables the output of voltage and current.
	 * 
	 * The default is disabled.
	 */
	public void enable() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_ENABLE, this);

		sendRequest(bb.array());
	}

	/**
	 * Disables the output of voltage and current.
	 * 
	 * The default is disabled.
	 */
	public void disable() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_DISABLE, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns *true* if output of voltage and current is enabled, *false* otherwise.
	 */
	public boolean isEnabled() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_IS_ENABLED, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		boolean enabled = (bb.get()) != 0;

		return enabled;
	}

	/**
	 * Sets the output voltage in mV.
	 * 
	 * The output voltage and output current are linked. Changing the output voltage
	 * also changes the output current.
	 */
	public void setVoltage(int voltage) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_VOLTAGE, this);
		bb.putShort((short)voltage);

		sendRequest(bb.array());
	}

	/**
	 * Returns the voltage as set by {@link BrickletIndustrialAnalogOut#setVoltage(int)}.
	 */
	public int getVoltage() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VOLTAGE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int voltage = IPConnection.unsignedShort(bb.getShort());

		return voltage;
	}

	/**
	 * Sets the output current in µA.
	 * 
	 * The output current and output voltage are linked. Changing the output current
	 * also changes the output voltage.
	 */
	public void setCurrent(int current) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_CURRENT, this);
		bb.putShort((short)current);

		sendRequest(bb.array());
	}

	/**
	 * Returns the current as set by {@link BrickletIndustrialAnalogOut#setCurrent(int)}.
	 */
	public int getCurrent() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CURRENT, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int current = IPConnection.unsignedShort(bb.getShort());

		return current;
	}

	/**
	 * Configures the voltage and current range.
	 * 
	 * Possible voltage ranges are:
	 * 
	 * * 0V to 5V
	 * * 0V to 10V (default)
	 * 
	 * Possible current ranges are:
	 * 
	 * * 4mA to 20mA (default)
	 * * 0mA to 20mA
	 * * 0mA to 24mA
	 * 
	 * The resolution will always be 12 bit. This means, that the
	 * precision is higher with a smaller range.
	 */
	public void setConfiguration(short voltageRange, short currentRange) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)voltageRange);
		bb.put((byte)currentRange);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletIndustrialAnalogOut#setConfiguration(short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.voltageRange = IPConnection.unsignedByte(bb.get());
		obj.currentRange = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Returns the UID, the UID where the Bricklet is connected to, 
	 * the position, the hardware and firmware version as well as the
	 * device identifier.
	 * 
	 * The position can be 'a', 'b', 'c' or 'd'.
	 * 
	 * The device identifier numbers can be found :ref:`here &lt;device_identifier&gt;`.
	 * |device_identifier_constant|
	 */
	public Identity getIdentity() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_IDENTITY, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Identity obj = new Identity();
		obj.uid = IPConnection.string(bb, 8);
		obj.connectedUid = IPConnection.string(bb, 8);
		obj.position = (char)(bb.get());
		for(int i = 0; i < 3; i++) {
			obj.hardwareVersion[i] = IPConnection.unsignedByte(bb.get());
		}

		for(int i = 0; i < 3; i++) {
			obj.firmwareVersion[i] = IPConnection.unsignedByte(bb.get());
		}

		obj.deviceIdentifier = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}
}
