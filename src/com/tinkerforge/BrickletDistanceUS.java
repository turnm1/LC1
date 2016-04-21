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
 * Measures distance between 2cm and 400cm with ultrasound
 */
public class BrickletDistanceUS extends Device {
	public final static int DEVICE_IDENTIFIER = 229;
	public final static String DEVICE_DISPLAY_NAME = "Distance US Bricklet";

	public final static byte FUNCTION_GET_DISTANCE_VALUE = (byte)1;
	public final static byte FUNCTION_SET_DISTANCE_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_DISTANCE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_DISTANCE = (byte)8;
	public final static byte CALLBACK_DISTANCE_REACHED = (byte)9;
	public final static byte FUNCTION_SET_MOVING_AVERAGE = (byte)10;
	public final static byte FUNCTION_GET_MOVING_AVERAGE = (byte)11;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';

	private List<DistanceListener> listenerDistance = new CopyOnWriteArrayList<DistanceListener>();
	private List<DistanceReachedListener> listenerDistanceReached = new CopyOnWriteArrayList<DistanceReachedListener>();

	public class DistanceCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletDistanceUS#setDistanceCallbackPeriod(long)}. The parameter is the distance value
	 * of the sensor.
	 * 
	 * {@link BrickletDistanceUS.DistanceListener} is only triggered if the distance value has changed since the
	 * last triggering.
	 */
	public interface DistanceListener extends DeviceListener {
		public void distance(int distance);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletDistanceUS#setDistanceCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the distance value of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletDistanceUS#setDebouncePeriod(long)}.
	 */
	public interface DistanceReachedListener extends DeviceListener {
		public void distanceReached(int distance);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletDistanceUS(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 1;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE_VALUE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DISTANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DISTANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DISTANCE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_DISTANCE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int distance = IPConnection.unsignedShort(bb.getShort());

				for(DistanceListener listener: listenerDistance) {
					listener.distance(distance);
				}
			}
		};

		callbacks[CALLBACK_DISTANCE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int distance = IPConnection.unsignedShort(bb.getShort());

				for(DistanceReachedListener listener: listenerDistanceReached) {
					listener.distanceReached(distance);
				}
			}
		};
	}

	/**
	 * Returns the current distance value measured by the sensor. The value has a
	 * range of 0 to 4095. A small value corresponds to a small distance, a big
	 * value corresponds to a big distance. The relation between the measured distance
	 * value and the actual distance is affected by the 5V supply voltage (deviations
	 * in the supply voltage result in deviations in the distance values) and is
	 * non-linear (resolution is bigger at close range).
	 * 
	 * If you want to get the distance value periodically, it is recommended to
	 * use the listener {@link BrickletDistanceUS.DistanceListener} and set the period with 
	 * {@link BrickletDistanceUS#setDistanceCallbackPeriod(long)}.
	 */
	public int getDistanceValue() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE_VALUE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int distance = IPConnection.unsignedShort(bb.getShort());

		return distance;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletDistanceUS.DistanceListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletDistanceUS.DistanceListener} is only triggered if the distance value has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setDistanceCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_DISTANCE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletDistanceUS#setDistanceCallbackPeriod(long)}.
	 */
	public long getDistanceCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletDistanceUS.DistanceReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the distance value is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the distance value is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the distance value is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the distance value is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setDistanceCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletDistanceUS#setDistanceCallbackThreshold(char, int, int)}.
	 */
	public DistanceCallbackThreshold getDistanceCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DistanceCallbackThreshold obj = new DistanceCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletDistanceUS.DistanceReachedListener},
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletDistanceUS#setDistanceCallbackThreshold(char, int, int)},
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
	 * Returns the debounce period as set by {@link BrickletDistanceUS#setDebouncePeriod(long)}.
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
	 * for the distance value.
	 * 
	 * Setting the length to 0 will turn the averaging completely off. With less
	 * averaging, there is more noise on the data.
	 * 
	 * The range for the averaging is 0-100.
	 * 
	 * The default value is 20.
	 */
	public void setMovingAverage(short average) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_MOVING_AVERAGE, this);
		bb.put((byte)average);

		sendRequest(bb.array());
	}

	/**
	 * Returns the length moving average as set by {@link BrickletDistanceUS#setMovingAverage(short)}.
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
	 * Adds a Distance listener.
	 */
	public void addDistanceListener(DistanceListener listener) {
		listenerDistance.add(listener);
	}

	/**
	 * Removes a Distance listener.
	 */
	public void removeDistanceListener(DistanceListener listener) {
		listenerDistance.remove(listener);
	}

	/**
	 * Adds a DistanceReached listener.
	 */
	public void addDistanceReachedListener(DistanceReachedListener listener) {
		listenerDistanceReached.add(listener);
	}

	/**
	 * Removes a DistanceReached listener.
	 */
	public void removeDistanceReachedListener(DistanceReachedListener listener) {
		listenerDistanceReached.remove(listener);
	}
}
