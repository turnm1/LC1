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
 * Measures two DC voltages between -35V and +35V with 24bit resolution each
 */
public class BrickletIndustrialDualAnalogIn extends Device {
	public final static int DEVICE_IDENTIFIER = 249;
	public final static String DEVICE_DISPLAY_NAME = "Industrial Dual Analog In Bricklet";

	public final static byte FUNCTION_GET_VOLTAGE = (byte)1;
	public final static byte FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte FUNCTION_SET_SAMPLE_RATE = (byte)8;
	public final static byte FUNCTION_GET_SAMPLE_RATE = (byte)9;
	public final static byte FUNCTION_SET_CALIBRATION = (byte)10;
	public final static byte FUNCTION_GET_CALIBRATION = (byte)11;
	public final static byte FUNCTION_GET_ADC_VALUES = (byte)12;
	public final static byte CALLBACK_VOLTAGE = (byte)13;
	public final static byte CALLBACK_VOLTAGE_REACHED = (byte)14;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short SAMPLE_RATE_976_SPS = (short)0;
	public final static short SAMPLE_RATE_488_SPS = (short)1;
	public final static short SAMPLE_RATE_244_SPS = (short)2;
	public final static short SAMPLE_RATE_122_SPS = (short)3;
	public final static short SAMPLE_RATE_61_SPS = (short)4;
	public final static short SAMPLE_RATE_4_SPS = (short)5;
	public final static short SAMPLE_RATE_2_SPS = (short)6;
	public final static short SAMPLE_RATE_1_SPS = (short)7;

	private List<VoltageListener> listenerVoltage = new CopyOnWriteArrayList<VoltageListener>();
	private List<VoltageReachedListener> listenerVoltageReached = new CopyOnWriteArrayList<VoltageReachedListener>();

	public class VoltageCallbackThreshold {
		public short channel;
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "channel = " + channel + ", " + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class Calibration {
		public int[] offset = new int[2];
		public int[] gain = new int[2];

		public String toString() {
			return "[" + "offset = " + Arrays.toString(offset) + ", " + "gain = " + Arrays.toString(gain) + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackPeriod(short, long)}. The parameter is the voltage of the
	 * channel.
	 * 
	 * {@link BrickletIndustrialDualAnalogIn.VoltageListener} is only triggered if the voltage has changed since the
	 * last triggering.
	 */
	public interface VoltageListener extends DeviceListener {
		public void voltage(short channel, int voltage);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackThreshold(short, char, int, int)} is reached.
	 * The parameter is the voltage of the channel.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletIndustrialDualAnalogIn#setDebouncePeriod(long)}.
	 */
	public interface VoltageReachedListener extends DeviceListener {
		public void voltageReached(short channel, int voltage);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletIndustrialDualAnalogIn(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_SAMPLE_RATE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_SAMPLE_RATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CALIBRATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CALIBRATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ADC_VALUES)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VOLTAGE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_VOLTAGE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short channel = IPConnection.unsignedByte(bb.get());
				int voltage = (bb.getInt());

				for(VoltageListener listener: listenerVoltage) {
					listener.voltage(channel, voltage);
				}
			}
		};

		callbacks[CALLBACK_VOLTAGE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short channel = IPConnection.unsignedByte(bb.get());
				int voltage = (bb.getInt());

				for(VoltageReachedListener listener: listenerVoltageReached) {
					listener.voltageReached(channel, voltage);
				}
			}
		};
	}

	/**
	 * Returns the voltage for the given channel in mV.
	 * 
	 * If you want to get the voltage periodically, it is recommended to use the
	 * listener {@link BrickletIndustrialDualAnalogIn.VoltageListener} and set the period with 
	 * {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackPeriod(short, long)}.
	 */
	public int getVoltage(short channel) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_GET_VOLTAGE, this);
		bb.put((byte)channel);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int voltage = (bb.getInt());

		return voltage;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletIndustrialDualAnalogIn.VoltageListener} listener is triggered
	 * periodically for the given channel. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletIndustrialDualAnalogIn.VoltageListener} is only triggered if the voltage has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setVoltageCallbackPeriod(short channel, long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD, this);
		bb.put((byte)channel);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackPeriod(short, long)}.
	 */
	public long getVoltageCallbackPeriod(short channel) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD, this);
		bb.put((byte)channel);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletIndustrialDualAnalogIn.VoltageReachedListener} listener for the given
	 * channel.
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the voltage is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the voltage is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the voltage is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the voltage is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setVoltageCallbackThreshold(short channel, char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)18, FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD, this);
		bb.put((byte)channel);
		bb.put((byte)option);
		bb.putInt(min);
		bb.putInt(max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackThreshold(short, char, int, int)}.
	 */
	public VoltageCallbackThreshold getVoltageCallbackThreshold(short channel) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD, this);
		bb.put((byte)channel);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		VoltageCallbackThreshold obj = new VoltageCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = (bb.getInt());
		obj.max = (bb.getInt());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletIndustrialDualAnalogIn.VoltageReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletIndustrialDualAnalogIn#setVoltageCallbackThreshold(short, char, int, int)}
	 * 
	 * keeps being reached.
	 * 
	 * The default value is 100.
	 */
	public void setDebouncePeriod(long debounce) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_DEBOUNCE_PERIOD, this);
		bb.putInt((int)debounce);

		sendRequest(bb.array());
	}

	/**
	 * Returns the debounce period as set by {@link BrickletIndustrialDualAnalogIn#setDebouncePeriod(long)}.
	 */
	public long getDebouncePeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DEBOUNCE_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long debounce = IPConnection.unsignedInt(bb.getInt());

		return debounce;
	}

	/**
	 * Sets the sample rate. The sample rate can be between 1 sample per second
	 * and 976 samples per second. Decreasing the sample rate will also decrease the
	 * noise on the data.
	 * 
	 * The default value is 6 (2 samples per second).
	 */
	public void setSampleRate(short rate) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_SAMPLE_RATE, this);
		bb.put((byte)rate);

		sendRequest(bb.array());
	}

	/**
	 * Returns the sample rate as set by {@link BrickletIndustrialDualAnalogIn#setSampleRate(short)}.
	 */
	public short getSampleRate() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_SAMPLE_RATE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short rate = IPConnection.unsignedByte(bb.get());

		return rate;
	}

	/**
	 * Sets offset and gain of MCP3911 internal calibration registers.
	 * 
	 * See MCP3911 datasheet 7.7 and 7.8. The Industrial Dual Analog In Bricklet
	 * is already factory calibrated by Tinkerforge. It should not be necessary
	 * for you to use this function
	 */
	public void setCalibration(int[] offset, int[] gain) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)24, FUNCTION_SET_CALIBRATION, this);
		for(int i = 0; i < 2; i++) {
			bb.putInt(offset[i]);
		}

		for(int i = 0; i < 2; i++) {
			bb.putInt(gain[i]);
		}


		sendRequest(bb.array());
	}

	/**
	 * Returns the calibration as set by {@link BrickletIndustrialDualAnalogIn#setCalibration(int[], int[])}.
	 */
	public Calibration getCalibration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CALIBRATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Calibration obj = new Calibration();
		for(int i = 0; i < 2; i++) {
			obj.offset[i] = (bb.getInt());
		}

		for(int i = 0; i < 2; i++) {
			obj.gain[i] = (bb.getInt());
		}


		return obj;
	}

	/**
	 * Returns the ADC values as given by the MCP3911 IC. This function
	 * is needed for proper calibration, see {@link BrickletIndustrialDualAnalogIn#setCalibration(int[], int[])}.
	 */
	public int[] getADCValues() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ADC_VALUES, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int[] value = new int[2];
		for(int i = 0; i < 2; i++) {
			value[i] = (bb.getInt());
		}


		return value;
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

	/**
	 * Adds a Voltage listener.
	 */
	public void addVoltageListener(VoltageListener listener) {
		listenerVoltage.add(listener);
	}

	/**
	 * Removes a Voltage listener.
	 */
	public void removeVoltageListener(VoltageListener listener) {
		listenerVoltage.remove(listener);
	}

	/**
	 * Adds a VoltageReached listener.
	 */
	public void addVoltageReachedListener(VoltageReachedListener listener) {
		listenerVoltageReached.add(listener);
	}

	/**
	 * Removes a VoltageReached listener.
	 */
	public void removeVoltageReachedListener(VoltageReachedListener listener) {
		listenerVoltageReached.remove(listener);
	}
}
