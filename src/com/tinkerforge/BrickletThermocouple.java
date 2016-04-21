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
 * Measures temperature with thermocouples
 */
public class BrickletThermocouple extends Device {
	public final static int DEVICE_IDENTIFIER = 266;
	public final static String DEVICE_DISPLAY_NAME = "Thermocouple Bricklet";

	public final static byte FUNCTION_GET_TEMPERATURE = (byte)1;
	public final static byte FUNCTION_SET_TEMPERATURE_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_TEMPERATURE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_TEMPERATURE_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_TEMPERATURE_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_TEMPERATURE = (byte)8;
	public final static byte CALLBACK_TEMPERATURE_REACHED = (byte)9;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)10;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)11;
	public final static byte FUNCTION_GET_ERROR_STATE = (byte)12;
	public final static byte CALLBACK_ERROR_STATE = (byte)13;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short AVERAGING_1 = (short)1;
	public final static short AVERAGING_2 = (short)2;
	public final static short AVERAGING_4 = (short)4;
	public final static short AVERAGING_8 = (short)8;
	public final static short AVERAGING_16 = (short)16;
	public final static short TYPE_B = (short)0;
	public final static short TYPE_E = (short)1;
	public final static short TYPE_J = (short)2;
	public final static short TYPE_K = (short)3;
	public final static short TYPE_N = (short)4;
	public final static short TYPE_R = (short)5;
	public final static short TYPE_S = (short)6;
	public final static short TYPE_T = (short)7;
	public final static short TYPE_G8 = (short)8;
	public final static short TYPE_G32 = (short)9;
	public final static short FILTER_OPTION_50HZ = (short)0;
	public final static short FILTER_OPTION_60HZ = (short)1;

	private List<TemperatureListener> listenerTemperature = new CopyOnWriteArrayList<TemperatureListener>();
	private List<TemperatureReachedListener> listenerTemperatureReached = new CopyOnWriteArrayList<TemperatureReachedListener>();
	private List<ErrorStateListener> listenerErrorState = new CopyOnWriteArrayList<ErrorStateListener>();

	public class TemperatureCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class Configuration {
		public short averaging;
		public short thermocoupleType;
		public short filter;

		public String toString() {
			return "[" + "averaging = " + averaging + ", " + "thermocoupleType = " + thermocoupleType + ", " + "filter = " + filter + "]";
		}
	}

	public class ErrorState {
		public boolean overUnder;
		public boolean openCircuit;

		public String toString() {
			return "[" + "overUnder = " + overUnder + ", " + "openCircuit = " + openCircuit + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * :func:`SetThermocoupleCallbackPeriod`. The parameter is the temperature
	 * of the thermocouple.
	 * 
	 * {@link BrickletThermocouple.TemperatureListener} is only triggered if the temperature has changed since the
	 * last triggering.
	 */
	public interface TemperatureListener extends DeviceListener {
		public void temperature(int temperature);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletThermocouple#setTemperatureCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the temperature of the thermocouple.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletThermocouple#setDebouncePeriod(long)}.
	 */
	public interface TemperatureReachedListener extends DeviceListener {
		public void temperatureReached(int temperature);
	}

	/**
	 * This Listener is triggered every time the error state changes 
	 * (see func:`GetErrorStatus`).
	 */
	public interface ErrorStateListener extends DeviceListener {
		public void errorState(boolean overUnder, boolean openCircuit);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletThermocouple(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TEMPERATURE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_TEMPERATURE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TEMPERATURE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_TEMPERATURE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TEMPERATURE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ERROR_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_TEMPERATURE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_TEMPERATURE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ERROR_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_TEMPERATURE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int temperature = (bb.getInt());

				for(TemperatureListener listener: listenerTemperature) {
					listener.temperature(temperature);
				}
			}
		};

		callbacks[CALLBACK_TEMPERATURE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int temperature = (bb.getInt());

				for(TemperatureReachedListener listener: listenerTemperatureReached) {
					listener.temperatureReached(temperature);
				}
			}
		};

		callbacks[CALLBACK_ERROR_STATE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				boolean overUnder = (bb.get()) != 0;
				boolean openCircuit = (bb.get()) != 0;

				for(ErrorStateListener listener: listenerErrorState) {
					listener.errorState(overUnder, openCircuit);
				}
			}
		};
	}

	/**
	 * Returns the temperature of the thermocouple. The value is given in °C/100,
	 * e.g. a value of 4223 means that a temperature of 42.23 °C is measured.
	 * 
	 * If you want to get the temperature periodically, it is recommended 
	 * to use the listener {@link BrickletThermocouple.TemperatureListener} and set the period with 
	 * {@link BrickletThermocouple#setTemperatureCallbackPeriod(long)}.
	 */
	public int getTemperature() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TEMPERATURE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int temperature = (bb.getInt());

		return temperature;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletThermocouple.TemperatureListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletThermocouple.TemperatureListener} is only triggered if the temperature has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setTemperatureCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_TEMPERATURE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletThermocouple#setTemperatureCallbackPeriod(long)}.
	 */
	public long getTemperatureCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TEMPERATURE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletThermocouple.TemperatureReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the temperature is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the temperature is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the temperature is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the temperature is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setTemperatureCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_SET_TEMPERATURE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putInt(min);
		bb.putInt(max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletThermocouple#setTemperatureCallbackThreshold(char, int, int)}.
	 */
	public TemperatureCallbackThreshold getTemperatureCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TEMPERATURE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		TemperatureCallbackThreshold obj = new TemperatureCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = (bb.getInt());
		obj.max = (bb.getInt());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletThermocouple.TemperatureReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletThermocouple#setTemperatureCallbackThreshold(char, int, int)}
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
	 * Returns the debounce period as set by {@link BrickletThermocouple#setDebouncePeriod(long)}.
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
	 * You can configure averaging size, thermocouple type and frequency
	 * filtering.
	 * 
	 * Available averaging sizes are 1, 2, 4, 8 and 16 samples.
	 * 
	 * As thermocouple type you can use B, E, J, K, N, R, S and T. If you have a
	 * different thermocouple or a custom thermocouple you can also use
	 * G8 and G32. With these types the returned value will not be in °C/100,
	 * it will be calculated by the following formulas:
	 * 
	 * * G8: ``value = 8 * 1.6 * 2^17 * Vin``
	 * * G32: ``value = 32 * 1.6 * 2^17 * Vin``
	 * 
	 * where Vin is the thermocouple input voltage.
	 * 
	 * The frequency filter can be either configured to 50Hz or to 60Hz. You should
	 * configure it according to your utility frequency.
	 * 
	 * The conversion time depends on the averaging and filter configuration, it can
	 * be calculated as follows:
	 * 
	 * * 60Hz: ``time = 82 + (samples - 1) * 16.67``
	 * * 50Hz: ``time = 98 + (samples - 1) * 20``
	 * 
	 * The default configuration is 16 samples, K type and 50Hz.
	 */
	public void setConfiguration(short averaging, short thermocoupleType, short filter) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)11, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)averaging);
		bb.put((byte)thermocoupleType);
		bb.put((byte)filter);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletThermocouple#setConfiguration(short, short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.averaging = IPConnection.unsignedByte(bb.get());
		obj.thermocoupleType = IPConnection.unsignedByte(bb.get());
		obj.filter = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Returns the current error state. There are two possible errors:
	 * 
	 * * Over/Under Voltage and
	 * * Open Circuit.
	 * 
	 * Over/Under Voltage happens for voltages below 0V or above 3.3V. In this case
	 * it is very likely that your thermocouple is defective. An Open Circuit error
	 * indicates that there is no thermocouple connected.
	 * 
	 * You can use the func:`ErrorState` listener to automatically get triggered
	 * when the error state changes.
	 */
	public ErrorState getErrorState() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ERROR_STATE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ErrorState obj = new ErrorState();
		obj.overUnder = (bb.get()) != 0;
		obj.openCircuit = (bb.get()) != 0;

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

	/**
	 * Adds a Temperature listener.
	 */
	public void addTemperatureListener(TemperatureListener listener) {
		listenerTemperature.add(listener);
	}

	/**
	 * Removes a Temperature listener.
	 */
	public void removeTemperatureListener(TemperatureListener listener) {
		listenerTemperature.remove(listener);
	}

	/**
	 * Adds a TemperatureReached listener.
	 */
	public void addTemperatureReachedListener(TemperatureReachedListener listener) {
		listenerTemperatureReached.add(listener);
	}

	/**
	 * Removes a TemperatureReached listener.
	 */
	public void removeTemperatureReachedListener(TemperatureReachedListener listener) {
		listenerTemperatureReached.remove(listener);
	}

	/**
	 * Adds a ErrorState listener.
	 */
	public void addErrorStateListener(ErrorStateListener listener) {
		listenerErrorState.add(listener);
	}

	/**
	 * Removes a ErrorState listener.
	 */
	public void removeErrorStateListener(ErrorStateListener listener) {
		listenerErrorState.remove(listener);
	}
}
