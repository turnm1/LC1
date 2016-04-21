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
 * Measures acceleration in three axis
 */
public class BrickletAccelerometer extends Device {
	public final static int DEVICE_IDENTIFIER = 250;
	public final static String DEVICE_DISPLAY_NAME = "Accelerometer Bricklet";

	public final static byte FUNCTION_GET_ACCELERATION = (byte)1;
	public final static byte FUNCTION_SET_ACCELERATION_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_ACCELERATION_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_ACCELERATION_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_ACCELERATION_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte FUNCTION_GET_TEMPERATURE = (byte)8;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)9;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)10;
	public final static byte FUNCTION_LED_ON = (byte)11;
	public final static byte FUNCTION_LED_OFF = (byte)12;
	public final static byte FUNCTION_IS_LED_ON = (byte)13;
	public final static byte CALLBACK_ACCELERATION = (byte)14;
	public final static byte CALLBACK_ACCELERATION_REACHED = (byte)15;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short DATA_RATE_OFF = (short)0;
	public final static short DATA_RATE_3HZ = (short)1;
	public final static short DATA_RATE_6HZ = (short)2;
	public final static short DATA_RATE_12HZ = (short)3;
	public final static short DATA_RATE_25HZ = (short)4;
	public final static short DATA_RATE_50HZ = (short)5;
	public final static short DATA_RATE_100HZ = (short)6;
	public final static short DATA_RATE_400HZ = (short)7;
	public final static short DATA_RATE_800HZ = (short)8;
	public final static short DATA_RATE_1600HZ = (short)9;
	public final static short FULL_SCALE_2G = (short)0;
	public final static short FULL_SCALE_4G = (short)1;
	public final static short FULL_SCALE_6G = (short)2;
	public final static short FULL_SCALE_8G = (short)3;
	public final static short FULL_SCALE_16G = (short)4;
	public final static short FILTER_BANDWIDTH_800HZ = (short)0;
	public final static short FILTER_BANDWIDTH_400HZ = (short)1;
	public final static short FILTER_BANDWIDTH_200HZ = (short)2;
	public final static short FILTER_BANDWIDTH_50HZ = (short)3;

	private List<AccelerationListener> listenerAcceleration = new CopyOnWriteArrayList<AccelerationListener>();
	private List<AccelerationReachedListener> listenerAccelerationReached = new CopyOnWriteArrayList<AccelerationReachedListener>();

	public class Acceleration {
		public short x;
		public short y;
		public short z;

		public String toString() {
			return "[" + "x = " + x + ", " + "y = " + y + ", " + "z = " + z + "]";
		}
	}

	public class AccelerationCallbackThreshold {
		public char option;
		public short minX;
		public short maxX;
		public short minY;
		public short maxY;
		public short minZ;
		public short maxZ;

		public String toString() {
			return "[" + "option = " + option + ", " + "minX = " + minX + ", " + "maxX = " + maxX + ", " + "minY = " + minY + ", " + "maxY = " + maxY + ", " + "minZ = " + minZ + ", " + "maxZ = " + maxZ + "]";
		}
	}

	public class Configuration {
		public short dataRate;
		public short fullScale;
		public short filterBandwidth;

		public String toString() {
			return "[" + "dataRate = " + dataRate + ", " + "fullScale = " + fullScale + ", " + "filterBandwidth = " + filterBandwidth + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletAccelerometer#setAccelerationCallbackPeriod(long)}. The parameters are the
	 * X, Y and Z acceleration.
	 * 
	 * {@link BrickletAccelerometer.AccelerationListener} is only triggered if the acceleration has changed since the
	 * last triggering.
	 */
	public interface AccelerationListener extends DeviceListener {
		public void acceleration(short x, short y, short z);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletAccelerometer#setAccelerationCallbackThreshold(char, short, short, short, short, short, short)} is reached.
	 * The parameters are the X, Y and Z acceleration.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletAccelerometer#setDebouncePeriod(long)}.
	 */
	public interface AccelerationReachedListener extends DeviceListener {
		public void accelerationReached(short x, short y, short z);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletAccelerometer(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 1;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ACCELERATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ACCELERATION_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ACCELERATION_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ACCELERATION_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ACCELERATION_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TEMPERATURE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LED_ON)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LED_OFF)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_LED_ON)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ACCELERATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ACCELERATION_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_ACCELERATION] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short x = (bb.getShort());
				short y = (bb.getShort());
				short z = (bb.getShort());

				for(AccelerationListener listener: listenerAcceleration) {
					listener.acceleration(x, y, z);
				}
			}
		};

		callbacks[CALLBACK_ACCELERATION_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short x = (bb.getShort());
				short y = (bb.getShort());
				short z = (bb.getShort());

				for(AccelerationReachedListener listener: listenerAccelerationReached) {
					listener.accelerationReached(x, y, z);
				}
			}
		};
	}

	/**
	 * Returns the acceleration in x, y and z direction. The values
	 * are given in g/1000 (1g = 9.80665m/s²), not to be confused with grams.
	 * 
	 * If you want to get the acceleration periodically, it is recommended 
	 * to use the listener {@link BrickletAccelerometer.AccelerationListener} and set the period with 
	 * {@link BrickletAccelerometer#setAccelerationCallbackPeriod(long)}.
	 */
	public Acceleration getAcceleration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ACCELERATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Acceleration obj = new Acceleration();
		obj.x = (bb.getShort());
		obj.y = (bb.getShort());
		obj.z = (bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletAccelerometer.AccelerationListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletAccelerometer.AccelerationListener} is only triggered if the acceleration has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setAccelerationCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_ACCELERATION_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletAccelerometer#setAccelerationCallbackPeriod(long)}.
	 */
	public long getAccelerationCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ACCELERATION_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletAccelerometer.AccelerationReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the acceleration is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the acceleration is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the acceleration is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the acceleration is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0, 0, 0, 0, 0).
	 */
	public void setAccelerationCallbackThreshold(char option, short minX, short maxX, short minY, short maxY, short minZ, short maxZ) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)21, FUNCTION_SET_ACCELERATION_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort(minX);
		bb.putShort(maxX);
		bb.putShort(minY);
		bb.putShort(maxY);
		bb.putShort(minZ);
		bb.putShort(maxZ);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletAccelerometer#setAccelerationCallbackThreshold(char, short, short, short, short, short, short)}.
	 */
	public AccelerationCallbackThreshold getAccelerationCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ACCELERATION_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		AccelerationCallbackThreshold obj = new AccelerationCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.minX = (bb.getShort());
		obj.maxX = (bb.getShort());
		obj.minY = (bb.getShort());
		obj.maxY = (bb.getShort());
		obj.minZ = (bb.getShort());
		obj.maxZ = (bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletAccelerometer.AccelerationReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletAccelerometer#setAccelerationCallbackThreshold(char, short, short, short, short, short, short)}
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
	 * Returns the debounce period as set by {@link BrickletAccelerometer#setDebouncePeriod(long)}.
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
	 * Returns the temperature of the accelerometer in °C.
	 */
	public short getTemperature() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TEMPERATURE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short temperature = (bb.getShort());

		return temperature;
	}

	/**
	 * Configures the data rate, full scale range and filter bandwidth.
	 * Possible values are:
	 * 
	 * * Data rate of 0Hz to 1600Hz.
	 * * Full scale range of -2G to +2G up to -16G to +16G.
	 * * Filter bandwidth between 50Hz and 800Hz.
	 * 
	 * Decreasing data rate or full scale range will also decrease the noise on 
	 * the data.
	 * 
	 * The default values are 100Hz data rate, -4G to +4G range and 200Hz
	 * filter bandwidth.
	 */
	public void setConfiguration(short dataRate, short fullScale, short filterBandwidth) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)11, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)dataRate);
		bb.put((byte)fullScale);
		bb.put((byte)filterBandwidth);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletAccelerometer#setConfiguration(short, short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.dataRate = IPConnection.unsignedByte(bb.get());
		obj.fullScale = IPConnection.unsignedByte(bb.get());
		obj.filterBandwidth = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Enables the LED on the Bricklet.
	 */
	public void ledOn() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LED_ON, this);

		sendRequest(bb.array());
	}

	/**
	 * Disables the LED on the Bricklet.
	 */
	public void ledOff() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LED_OFF, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns *true* if the LED is enabled, *false* otherwise.
	 */
	public boolean isLEDOn() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_IS_LED_ON, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		boolean on = (bb.get()) != 0;

		return on;
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
	 * Adds a Acceleration listener.
	 */
	public void addAccelerationListener(AccelerationListener listener) {
		listenerAcceleration.add(listener);
	}

	/**
	 * Removes a Acceleration listener.
	 */
	public void removeAccelerationListener(AccelerationListener listener) {
		listenerAcceleration.remove(listener);
	}

	/**
	 * Adds a AccelerationReached listener.
	 */
	public void addAccelerationReachedListener(AccelerationReachedListener listener) {
		listenerAccelerationReached.add(listener);
	}

	/**
	 * Removes a AccelerationReached listener.
	 */
	public void removeAccelerationReachedListener(AccelerationReachedListener listener) {
		listenerAccelerationReached.remove(listener);
	}
}
