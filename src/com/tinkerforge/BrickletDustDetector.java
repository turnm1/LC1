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
 * Measures dust density
 */
public class BrickletDustDetector extends Device {
	public final static int DEVICE_IDENTIFIER = 260;
	public final static String DEVICE_DISPLAY_NAME = "Dust Detector Bricklet";

	public final static byte FUNCTION_GET_DUST_DENSITY = (byte)1;
	public final static byte FUNCTION_SET_DUST_DENSITY_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_DUST_DENSITY_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_DUST_DENSITY_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_DUST_DENSITY_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_DUST_DENSITY = (byte)8;
	public final static byte CALLBACK_DUST_DENSITY_REACHED = (byte)9;
	public final static byte FUNCTION_SET_MOVING_AVERAGE = (byte)10;
	public final static byte FUNCTION_GET_MOVING_AVERAGE = (byte)11;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';

	private List<DustDensityListener> listenerDustDensity = new CopyOnWriteArrayList<DustDensityListener>();
	private List<DustDensityReachedListener> listenerDustDensityReached = new CopyOnWriteArrayList<DustDensityReachedListener>();

	public class DustDensityCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletDustDetector#setDustDensityCallbackPeriod(long)}. The parameter is the 
	 * dust density of the sensor.
	 * 
	 * {@link BrickletDustDetector.DustDensityListener} is only triggered if the dust density value has changed since the
	 * last triggering.
	 */
	public interface DustDensityListener extends DeviceListener {
		public void dustDensity(int dustDensity);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletDustDetector#setDustDensityCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the dust density of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletDustDetector#setDebouncePeriod(long)}.
	 */
	public interface DustDensityReachedListener extends DeviceListener {
		public void dustDensityReached(int dustDensity);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletDustDetector(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DUST_DENSITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DUST_DENSITY_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DUST_DENSITY_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DUST_DENSITY_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DUST_DENSITY_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DUST_DENSITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DUST_DENSITY_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_DUST_DENSITY] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int dustDensity = IPConnection.unsignedShort(bb.getShort());

				for(DustDensityListener listener: listenerDustDensity) {
					listener.dustDensity(dustDensity);
				}
			}
		};

		callbacks[CALLBACK_DUST_DENSITY_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int dustDensity = IPConnection.unsignedShort(bb.getShort());

				for(DustDensityReachedListener listener: listenerDustDensityReached) {
					listener.dustDensityReached(dustDensity);
				}
			}
		};
	}

	/**
	 * Returns the dust density in µg/m³.
	 * 
	 * If you want to get the dust density periodically, it is recommended 
	 * to use the listener {@link BrickletDustDetector.DustDensityListener} and set the period with 
	 * {@link BrickletDustDetector#setDustDensityCallbackPeriod(long)}.
	 */
	public int getDustDensity() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DUST_DENSITY, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int dustDensity = IPConnection.unsignedShort(bb.getShort());

		return dustDensity;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletDustDetector.DustDensityListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletDustDetector.DustDensityListener} is only triggered if the dust density has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setDustDensityCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_DUST_DENSITY_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletDustDetector#setDustDensityCallbackPeriod(long)}.
	 */
	public long getDustDensityCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DUST_DENSITY_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletDustDetector.DustDensityReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the dust density value is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the dust density value is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the dust density value is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the dust density value is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setDustDensityCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_DUST_DENSITY_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletDustDetector#setDustDensityCallbackThreshold(char, int, int)}.
	 */
	public DustDensityCallbackThreshold getDustDensityCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DUST_DENSITY_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DustDensityCallbackThreshold obj = new DustDensityCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletDustDetector.DustDensityReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletDustDetector#setDustDensityCallbackThreshold(char, int, int)}
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
	 * Returns the debounce period as set by {@link BrickletDustDetector#setDebouncePeriod(long)}.
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
	 * for the dust_density.
	 * 
	 * Setting the length to 0 will turn the averaging completely off. With less
	 * averaging, there is more noise on the data.
	 * 
	 * The range for the averaging is 0-100.
	 * 
	 * The default value is 100.
	 */
	public void setMovingAverage(short average) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_MOVING_AVERAGE, this);
		bb.put((byte)average);

		sendRequest(bb.array());
	}

	/**
	 * Returns the length moving average as set by {@link BrickletDustDetector#setMovingAverage(short)}.
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
	 * Adds a DustDensity listener.
	 */
	public void addDustDensityListener(DustDensityListener listener) {
		listenerDustDensity.add(listener);
	}

	/**
	 * Removes a DustDensity listener.
	 */
	public void removeDustDensityListener(DustDensityListener listener) {
		listenerDustDensity.remove(listener);
	}

	/**
	 * Adds a DustDensityReached listener.
	 */
	public void addDustDensityReachedListener(DustDensityReachedListener listener) {
		listenerDustDensityReached.add(listener);
	}

	/**
	 * Removes a DustDensityReached listener.
	 */
	public void removeDustDensityReachedListener(DustDensityReachedListener listener) {
		listenerDustDensityReached.remove(listener);
	}
}
