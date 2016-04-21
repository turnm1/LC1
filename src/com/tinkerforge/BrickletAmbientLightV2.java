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
 * Measures ambient light up to 64000lux
 */
public class BrickletAmbientLightV2 extends Device {
	public final static int DEVICE_IDENTIFIER = 259;
	public final static String DEVICE_DISPLAY_NAME = "Ambient Light Bricklet 2.0";

	public final static byte FUNCTION_GET_ILLUMINANCE = (byte)1;
	public final static byte FUNCTION_SET_ILLUMINANCE_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_ILLUMINANCE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_ILLUMINANCE_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_ILLUMINANCE_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)8;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)9;
	public final static byte CALLBACK_ILLUMINANCE = (byte)10;
	public final static byte CALLBACK_ILLUMINANCE_REACHED = (byte)11;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short ILLUMINANCE_RANGE_UNLIMITED = (short)6;
	public final static short ILLUMINANCE_RANGE_64000LUX = (short)0;
	public final static short ILLUMINANCE_RANGE_32000LUX = (short)1;
	public final static short ILLUMINANCE_RANGE_16000LUX = (short)2;
	public final static short ILLUMINANCE_RANGE_8000LUX = (short)3;
	public final static short ILLUMINANCE_RANGE_1300LUX = (short)4;
	public final static short ILLUMINANCE_RANGE_600LUX = (short)5;
	public final static short INTEGRATION_TIME_50MS = (short)0;
	public final static short INTEGRATION_TIME_100MS = (short)1;
	public final static short INTEGRATION_TIME_150MS = (short)2;
	public final static short INTEGRATION_TIME_200MS = (short)3;
	public final static short INTEGRATION_TIME_250MS = (short)4;
	public final static short INTEGRATION_TIME_300MS = (short)5;
	public final static short INTEGRATION_TIME_350MS = (short)6;
	public final static short INTEGRATION_TIME_400MS = (short)7;

	private List<IlluminanceListener> listenerIlluminance = new CopyOnWriteArrayList<IlluminanceListener>();
	private List<IlluminanceReachedListener> listenerIlluminanceReached = new CopyOnWriteArrayList<IlluminanceReachedListener>();

	public class IlluminanceCallbackThreshold {
		public char option;
		public long min;
		public long max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class Configuration {
		public short illuminanceRange;
		public short integrationTime;

		public String toString() {
			return "[" + "illuminanceRange = " + illuminanceRange + ", " + "integrationTime = " + integrationTime + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletAmbientLightV2#setIlluminanceCallbackPeriod(long)}. The parameter is the illuminance of the
	 * ambient light sensor.
	 * 
	 * {@link BrickletAmbientLightV2.IlluminanceListener} is only triggered if the illuminance has changed since the
	 * last triggering.
	 */
	public interface IlluminanceListener extends DeviceListener {
		public void illuminance(long illuminance);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletAmbientLightV2#setIlluminanceCallbackThreshold(char, long, long)} is reached.
	 * The parameter is the illuminance of the ambient light sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletAmbientLightV2#setDebouncePeriod(long)}.
	 */
	public interface IlluminanceReachedListener extends DeviceListener {
		public void illuminanceReached(long illuminance);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletAmbientLightV2(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 1;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ILLUMINANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ILLUMINANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ILLUMINANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ILLUMINANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ILLUMINANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ILLUMINANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ILLUMINANCE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_ILLUMINANCE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				long illuminance = IPConnection.unsignedInt(bb.getInt());

				for(IlluminanceListener listener: listenerIlluminance) {
					listener.illuminance(illuminance);
				}
			}
		};

		callbacks[CALLBACK_ILLUMINANCE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				long illuminance = IPConnection.unsignedInt(bb.getInt());

				for(IlluminanceReachedListener listener: listenerIlluminanceReached) {
					listener.illuminanceReached(illuminance);
				}
			}
		};
	}

	/**
	 * Returns the illuminance of the ambient light sensor. The measurement range goes
	 * up to about 100000lux, but above 64000lux the precision starts to drop.
	 * The illuminance is given in lux/100, i.e. a value of 450000 means that an
	 * illuminance of 4500lux is measured.
	 * 
	 * .. versionchanged:: 2.0.2$nbsp;(Plugin)
	 *   An illuminance of 0lux indicates that the sensor is saturated and the
	 *   configuration should be modified, see {@link BrickletAmbientLightV2#setConfiguration(short, short)}.
	 * 
	 * If you want to get the illuminance periodically, it is recommended to use the
	 * listener {@link BrickletAmbientLightV2.IlluminanceListener} and set the period with 
	 * {@link BrickletAmbientLightV2#setIlluminanceCallbackPeriod(long)}.
	 */
	public long getIlluminance() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ILLUMINANCE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long illuminance = IPConnection.unsignedInt(bb.getInt());

		return illuminance;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletAmbientLightV2.IlluminanceListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletAmbientLightV2.IlluminanceListener} is only triggered if the illuminance has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setIlluminanceCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_ILLUMINANCE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletAmbientLightV2#setIlluminanceCallbackPeriod(long)}.
	 */
	public long getIlluminanceCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ILLUMINANCE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletAmbientLightV2.IlluminanceReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the illuminance is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the illuminance is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the illuminance is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the illuminance is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setIlluminanceCallbackThreshold(char option, long min, long max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_SET_ILLUMINANCE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putInt((int)min);
		bb.putInt((int)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletAmbientLightV2#setIlluminanceCallbackThreshold(char, long, long)}.
	 */
	public IlluminanceCallbackThreshold getIlluminanceCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_ILLUMINANCE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		IlluminanceCallbackThreshold obj = new IlluminanceCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedInt(bb.getInt());
		obj.max = IPConnection.unsignedInt(bb.getInt());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletAmbientLightV2.IlluminanceReachedListener},
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletAmbientLightV2#setIlluminanceCallbackThreshold(char, long, long)},
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
	 * Returns the debounce period as set by {@link BrickletAmbientLightV2#setDebouncePeriod(long)}.
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
	 * Sets the configuration. It is possible to configure an illuminance range
	 * between 0-600lux and 0-64000lux and an integration time between 50ms and 400ms.
	 * 
	 * .. versionadded:: 2.0.2$nbsp;(Plugin)
	 *   The unlimited illuminance range allows to measure up to about 100000lux, but
	 *   above 64000lux the precision starts to drop.
	 * 
	 * A smaller illuminance range increases the resolution of the data. A longer
	 * integration time will result in less noise on the data.
	 * 
	 * .. versionchanged:: 2.0.2$nbsp;(Plugin)
	 *   If the actual measure illuminance is out-of-range then the current illuminance
	 *   range maximum +0.01lux is reported by {@link BrickletAmbientLightV2#getIlluminance()} and the
	 *   {@link BrickletAmbientLightV2.IlluminanceListener} listener. For example, 800001 for the 0-8000lux range.
	 * 
	 * .. versionchanged:: 2.0.2$nbsp;(Plugin)
	 *   With a long integration time the sensor might be saturated before the measured
	 *   value reaches the maximum of the selected illuminance range. In this case 0lux
	 *   is reported by {@link BrickletAmbientLightV2#getIlluminance()} and the {@link BrickletAmbientLightV2.IlluminanceListener} listener.
	 * 
	 * If the measurement is out-of-range or the sensor is saturated then you should
	 * configure the next higher illuminance range. If the highest range is already
	 * in use, then start to reduce the integration time.
	 * 
	 * The default values are 0-8000lux illuminance range and 200ms integration time.
	 */
	public void setConfiguration(short illuminanceRange, short integrationTime) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)illuminanceRange);
		bb.put((byte)integrationTime);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletAmbientLightV2#setConfiguration(short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.illuminanceRange = IPConnection.unsignedByte(bb.get());
		obj.integrationTime = IPConnection.unsignedByte(bb.get());

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
	 * Adds a Illuminance listener.
	 */
	public void addIlluminanceListener(IlluminanceListener listener) {
		listenerIlluminance.add(listener);
	}

	/**
	 * Removes a Illuminance listener.
	 */
	public void removeIlluminanceListener(IlluminanceListener listener) {
		listenerIlluminance.remove(listener);
	}

	/**
	 * Adds a IlluminanceReached listener.
	 */
	public void addIlluminanceReachedListener(IlluminanceReachedListener listener) {
		listenerIlluminanceReached.add(listener);
	}

	/**
	 * Removes a IlluminanceReached listener.
	 */
	public void removeIlluminanceReachedListener(IlluminanceReachedListener listener) {
		listenerIlluminanceReached.remove(listener);
	}
}
