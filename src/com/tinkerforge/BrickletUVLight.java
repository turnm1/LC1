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
 * Measures UV light
 */
public class BrickletUVLight extends Device {
	public final static int DEVICE_IDENTIFIER = 265;
	public final static String DEVICE_DISPLAY_NAME = "UV Light Bricklet";

	public final static byte FUNCTION_GET_UV_LIGHT = (byte)1;
	public final static byte FUNCTION_SET_UV_LIGHT_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_UV_LIGHT_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_UV_LIGHT_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_UV_LIGHT_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_UV_LIGHT = (byte)8;
	public final static byte CALLBACK_UV_LIGHT_REACHED = (byte)9;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';

	private List<UVLightListener> listenerUVLight = new CopyOnWriteArrayList<UVLightListener>();
	private List<UVLightReachedListener> listenerUVLightReached = new CopyOnWriteArrayList<UVLightReachedListener>();

	public class UVLightCallbackThreshold {
		public char option;
		public long min;
		public long max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletUVLight#setUVLightCallbackPeriod(long)}. The parameter is the UV Light 
	 * intensity of the sensor.
	 * 
	 * {@link BrickletUVLight.UVLightListener} is only triggered if the intensity has changed since the
	 * last triggering.
	 */
	public interface UVLightListener extends DeviceListener {
		public void uvLight(long uvLight);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletUVLight#setUVLightCallbackThreshold(char, long, long)} is reached.
	 * The parameter is the UV Light intensity of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletUVLight#setDebouncePeriod(long)}.
	 */
	public interface UVLightReachedListener extends DeviceListener {
		public void uvLightReached(long uvLight);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletUVLight(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_UV_LIGHT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_UV_LIGHT_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_UV_LIGHT_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_UV_LIGHT_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_UV_LIGHT_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_UV_LIGHT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_UV_LIGHT_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_UV_LIGHT] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				long uvLight = IPConnection.unsignedInt(bb.getInt());

				for(UVLightListener listener: listenerUVLight) {
					listener.uvLight(uvLight);
				}
			}
		};

		callbacks[CALLBACK_UV_LIGHT_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				long uvLight = IPConnection.unsignedInt(bb.getInt());

				for(UVLightReachedListener listener: listenerUVLightReached) {
					listener.uvLightReached(uvLight);
				}
			}
		};
	}

	/**
	 * Returns the UV light intensity of the sensor, the intensity is given
	 * in µW/cm².
	 * 
	 * To get UV Index you have to divide the value by 250. For example, a UV Light
	 * intensity of 500µW/cm² is equivalent to an UV Index of 2.
	 * 
	 * If you want to get the intensity periodically, it is recommended to use the
	 * listener {@link BrickletUVLight.UVLightListener} and set the period with 
	 * {@link BrickletUVLight#setUVLightCallbackPeriod(long)}.
	 */
	public long getUVLight() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_UV_LIGHT, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long uvLight = IPConnection.unsignedInt(bb.getInt());

		return uvLight;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletUVLight.UVLightListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletUVLight.UVLightListener} is only triggered if the intensity has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setUVLightCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_UV_LIGHT_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletUVLight#setUVLightCallbackPeriod(long)}.
	 */
	public long getUVLightCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_UV_LIGHT_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletUVLight.UVLightReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the intensity is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the intensity is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the intensity is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the intensity is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setUVLightCallbackThreshold(char option, long min, long max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_SET_UV_LIGHT_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putInt((int)min);
		bb.putInt((int)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletUVLight#setUVLightCallbackThreshold(char, long, long)}.
	 */
	public UVLightCallbackThreshold getUVLightCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_UV_LIGHT_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		UVLightCallbackThreshold obj = new UVLightCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedInt(bb.getInt());
		obj.max = IPConnection.unsignedInt(bb.getInt());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletUVLight.UVLightReachedListener},
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletUVLight#setUVLightCallbackThreshold(char, long, long)},
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
	 * Returns the debounce period as set by {@link BrickletUVLight#setDebouncePeriod(long)}.
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
	 * Adds a UVLight listener.
	 */
	public void addUVLightListener(UVLightListener listener) {
		listenerUVLight.add(listener);
	}

	/**
	 * Removes a UVLight listener.
	 */
	public void removeUVLightListener(UVLightListener listener) {
		listenerUVLight.remove(listener);
	}

	/**
	 * Adds a UVLightReached listener.
	 */
	public void addUVLightReachedListener(UVLightReachedListener listener) {
		listenerUVLightReached.add(listener);
	}

	/**
	 * Removes a UVLightReached listener.
	 */
	public void removeUVLightReachedListener(UVLightReachedListener listener) {
		listenerUVLightReached.remove(listener);
	}
}
