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
 * Measures DC voltage between 0V and 42V
 */
public class BrickletAnalogInV2 extends Device {
	public final static int DEVICE_IDENTIFIER = 251;
	public final static String DEVICE_DISPLAY_NAME = "Analog In Bricklet 2.0";

	public final static byte FUNCTION_GET_VOLTAGE = (byte)1;
	public final static byte FUNCTION_GET_ANALOG_VALUE = (byte)2;
	public final static byte FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD = (byte)4;
	public final static byte FUNCTION_SET_ANALOG_VALUE_CALLBACK_PERIOD = (byte)5;
	public final static byte FUNCTION_GET_ANALOG_VALUE_CALLBACK_PERIOD = (byte)6;
	public final static byte FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD = (byte)7;
	public final static byte FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD = (byte)8;
	public final static byte FUNCTION_SET_ANALOG_VALUE_CALLBACK_THRESHOLD = (byte)9;
	public final static byte FUNCTION_GET_ANALOG_VALUE_CALLBACK_THRESHOLD = (byte)10;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)11;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)12;
	public final static byte FUNCTION_SET_MOVING_AVERAGE = (byte)13;
	public final static byte FUNCTION_GET_MOVING_AVERAGE = (byte)14;
	public final static byte CALLBACK_VOLTAGE = (byte)15;
	public final static byte CALLBACK_ANALOG_VALUE = (byte)16;
	public final static byte CALLBACK_VOLTAGE_REACHED = (byte)17;
	public final static byte CALLBACK_ANALOG_VALUE_REACHED = (byte)18;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';

	private List<VoltageListener> listenerVoltage = new CopyOnWriteArrayList<VoltageListener>();
	private List<AnalogValueListener> listenerAnalogValue = new CopyOnWriteArrayList<AnalogValueListener>();
	private List<VoltageReachedListener> listenerVoltageReached = new CopyOnWriteArrayList<VoltageReachedListener>();
	private List<AnalogValueReachedListener> listenerAnalogValueReached = new CopyOnWriteArrayList<AnalogValueReachedListener>();

	public class VoltageCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class AnalogValueCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletAnalogInV2#setVoltageCallbackPeriod(long)}. The parameter is the voltage of the
	 * sensor.
	 * 
	 * {@link BrickletAnalogInV2.VoltageListener} is only triggered if the voltage has changed since the
	 * last triggering.
	 */
	public interface VoltageListener extends DeviceListener {
		public void voltage(int voltage);
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletAnalogInV2#setAnalogValueCallbackPeriod(long)}. The parameter is the analog value of the
	 * sensor.
	 * 
	 * {@link BrickletAnalogInV2.AnalogValueListener} is only triggered if the voltage has changed since the
	 * last triggering.
	 */
	public interface AnalogValueListener extends DeviceListener {
		public void analogValue(int value);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletAnalogInV2#setVoltageCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the voltage of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletAnalogInV2#setDebouncePeriod(long)}.
	 */
	public interface VoltageReachedListener extends DeviceListener {
		public void voltageReached(int voltage);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletAnalogInV2#setAnalogValueCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the analog value of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletAnalogInV2#setDebouncePeriod(long)}.
	 */
	public interface AnalogValueReachedListener extends DeviceListener {
		public void analogValueReached(int value);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletAnalogInV2(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 1;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ANALOG_VALUE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ANALOG_VALUE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ANALOG_VALUE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ANALOG_VALUE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ANALOG_VALUE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VOLTAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ANALOG_VALUE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VOLTAGE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ANALOG_VALUE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_VOLTAGE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int voltage = IPConnection.unsignedShort(bb.getShort());

				for(VoltageListener listener: listenerVoltage) {
					listener.voltage(voltage);
				}
			}
		};

		callbacks[CALLBACK_ANALOG_VALUE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int value = IPConnection.unsignedShort(bb.getShort());

				for(AnalogValueListener listener: listenerAnalogValue) {
					listener.analogValue(value);
				}
			}
		};

		callbacks[CALLBACK_VOLTAGE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int voltage = IPConnection.unsignedShort(bb.getShort());

				for(VoltageReachedListener listener: listenerVoltageReached) {
					listener.voltageReached(voltage);
				}
			}
		};

		callbacks[CALLBACK_ANALOG_VALUE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int value = IPConnection.unsignedShort(bb.getShort());

				for(AnalogValueReachedListener listener: listenerAnalogValueReached) {
					listener.analogValueReached(value);
				}
			}
		};
	}

	/**
	 * Returns the measured voltage. The value is in mV and
	 * between 0V and 42V. The resolution is approximately 10mV.
	 * 
	 * If you want to get the voltage periodically, it is recommended to use the
	 * listener {@link BrickletAnalogInV2.VoltageListener} and set the period with
	 * {@link BrickletAnalogInV2#setVoltageCallbackPeriod(long)}.
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
	 * Returns the value as read by a 12-bit analog-to-digital converter.
	 * The value is between 0 and 4095.
	 * 
	 * If you want the analog value periodically, it is recommended to use the
	 * listener {@link BrickletAnalogInV2.AnalogValueListener} and set the period with
	 * {@link BrickletAnalogInV2#setAnalogValueCallbackPeriod(long)}.
	 */
	public int getAnalogValue() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ANALOG_VALUE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int value = IPConnection.unsignedShort(bb.getShort());

		return value;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletAnalogInV2.VoltageListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletAnalogInV2.VoltageListener} is only triggered if the voltage has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setVoltageCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_VOLTAGE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletAnalogInV2#setVoltageCallbackPeriod(long)}.
	 */
	public long getVoltageCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VOLTAGE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletAnalogInV2.AnalogValueListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletAnalogInV2.AnalogValueListener} is only triggered if the analog value has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setAnalogValueCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_ANALOG_VALUE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletAnalogInV2#setAnalogValueCallbackPeriod(long)}.
	 */
	public long getAnalogValueCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ANALOG_VALUE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletAnalogInV2.VoltageReachedListener} listener.
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
	public void setVoltageCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_VOLTAGE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletAnalogInV2#setVoltageCallbackThreshold(char, int, int)}.
	 */
	public VoltageCallbackThreshold getVoltageCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VOLTAGE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		VoltageCallbackThreshold obj = new VoltageCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the thresholds for the {@link BrickletAnalogInV2.AnalogValueReachedListener} listener.
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the analog value is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the analog value is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the analog value is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the analog value is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setAnalogValueCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_ANALOG_VALUE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletAnalogInV2#setAnalogValueCallbackThreshold(char, int, int)}.
	 */
	public AnalogValueCallbackThreshold getAnalogValueCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ANALOG_VALUE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		AnalogValueCallbackThreshold obj = new AnalogValueCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletAnalogInV2.VoltageReachedListener},
	 * * {@link BrickletAnalogInV2.AnalogValueReachedListener}
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletAnalogInV2#setVoltageCallbackThreshold(char, int, int)},
	 * * {@link BrickletAnalogInV2#setAnalogValueCallbackThreshold(char, int, int)}
	 * 
	 * keep being reached.
	 * 
	 * The default value is 100.
	 */
	public void setDebouncePeriod(long debounce) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_DEBOUNCE_PERIOD, this);
		bb.putInt((int)debounce);

		sendRequest(bb.array());
	}

	/**
	 * Returns the debounce period as set by {@link BrickletAnalogInV2#setDebouncePeriod(long)}.
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
	 * Sets the length of a `moving averaging &lt;https://en.wikipedia.org/wiki/Moving_average&gt;`__
	 * for the voltage.
	 * 
	 * Setting the length to 1 will turn the averaging off. With less
	 * averaging, there is more noise on the data.
	 * 
	 * The range for the averaging is 1-50.
	 * 
	 * The default value is 50.
	 */
	public void setMovingAverage(short average) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_MOVING_AVERAGE, this);
		bb.put((byte)average);

		sendRequest(bb.array());
	}

	/**
	 * Returns the length of the moving average as set by {@link BrickletAnalogInV2#setMovingAverage(short)}.
	 */
	public short getMovingAverage() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_MOVING_AVERAGE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short average = IPConnection.unsignedByte(bb.get());

		return average;
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
	 * Adds a AnalogValue listener.
	 */
	public void addAnalogValueListener(AnalogValueListener listener) {
		listenerAnalogValue.add(listener);
	}

	/**
	 * Removes a AnalogValue listener.
	 */
	public void removeAnalogValueListener(AnalogValueListener listener) {
		listenerAnalogValue.remove(listener);
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

	/**
	 * Adds a AnalogValueReached listener.
	 */
	public void addAnalogValueReachedListener(AnalogValueReachedListener listener) {
		listenerAnalogValueReached.add(listener);
	}

	/**
	 * Removes a AnalogValueReached listener.
	 */
	public void removeAnalogValueReachedListener(AnalogValueReachedListener listener) {
		listenerAnalogValueReached.remove(listener);
	}
}
