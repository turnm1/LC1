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
 * Measures weight with a load cell
 */
public class BrickletLoadCell extends Device {
	public final static int DEVICE_IDENTIFIER = 253;
	public final static String DEVICE_DISPLAY_NAME = "Load Cell Bricklet";

	public final static byte FUNCTION_GET_WEIGHT = (byte)1;
	public final static byte FUNCTION_SET_WEIGHT_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_WEIGHT_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_WEIGHT_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_WEIGHT_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte FUNCTION_SET_MOVING_AVERAGE = (byte)8;
	public final static byte FUNCTION_GET_MOVING_AVERAGE = (byte)9;
	public final static byte FUNCTION_LED_ON = (byte)10;
	public final static byte FUNCTION_LED_OFF = (byte)11;
	public final static byte FUNCTION_IS_LED_ON = (byte)12;
	public final static byte FUNCTION_CALIBRATE = (byte)13;
	public final static byte FUNCTION_TARE = (byte)14;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)15;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)16;
	public final static byte CALLBACK_WEIGHT = (byte)17;
	public final static byte CALLBACK_WEIGHT_REACHED = (byte)18;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short RATE_10HZ = (short)0;
	public final static short RATE_80HZ = (short)1;
	public final static short GAIN_128X = (short)0;
	public final static short GAIN_64X = (short)1;
	public final static short GAIN_32X = (short)2;

	private List<WeightListener> listenerWeight = new CopyOnWriteArrayList<WeightListener>();
	private List<WeightReachedListener> listenerWeightReached = new CopyOnWriteArrayList<WeightReachedListener>();

	public class WeightCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class Configuration {
		public short rate;
		public short gain;

		public String toString() {
			return "[" + "rate = " + rate + ", " + "gain = " + gain + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletLoadCell#setWeightCallbackPeriod(long)}. The parameter is the weight
	 * as measured by the load cell.
	 * 
	 * {@link BrickletLoadCell.WeightListener} is only triggered if the weight has changed since the
	 * last triggering.
	 */
	public interface WeightListener extends DeviceListener {
		public void weight(int weight);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletLoadCell#setWeightCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the weight as measured by the load cell.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletLoadCell#setDebouncePeriod(long)}.
	 */
	public interface WeightReachedListener extends DeviceListener {
		public void weightReached(int weight);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletLoadCell(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_WEIGHT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_WEIGHT_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_WEIGHT_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_WEIGHT_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_WEIGHT_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LED_ON)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LED_OFF)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_LED_ON)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CALIBRATE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_TARE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_WEIGHT)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_WEIGHT_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_WEIGHT] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int weight = (bb.getInt());

				for(WeightListener listener: listenerWeight) {
					listener.weight(weight);
				}
			}
		};

		callbacks[CALLBACK_WEIGHT_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int weight = (bb.getInt());

				for(WeightReachedListener listener: listenerWeightReached) {
					listener.weightReached(weight);
				}
			}
		};
	}

	/**
	 * Returns the currently measured weight in grams.
	 * 
	 * If you want to get the weight periodically, it is recommended 
	 * to use the listener {@link BrickletLoadCell.WeightListener} and set the period with 
	 * {@link BrickletLoadCell#setWeightCallbackPeriod(long)}.
	 */
	public int getWeight() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_WEIGHT, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int weight = (bb.getInt());

		return weight;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletLoadCell.WeightListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletLoadCell.WeightListener} is only triggered if the weight has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setWeightCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_WEIGHT_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletLoadCell#setWeightCallbackPeriod(long)}.
	 */
	public long getWeightCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_WEIGHT_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletLoadCell.WeightReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the weight is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the weight is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the weight is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the weight is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setWeightCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_SET_WEIGHT_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putInt(min);
		bb.putInt(max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletLoadCell#setWeightCallbackThreshold(char, int, int)}.
	 */
	public WeightCallbackThreshold getWeightCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_WEIGHT_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		WeightCallbackThreshold obj = new WeightCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = (bb.getInt());
		obj.max = (bb.getInt());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletLoadCell.WeightReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletLoadCell#setWeightCallbackThreshold(char, int, int)}
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
	 * Returns the debounce period as set by {@link BrickletLoadCell#setDebouncePeriod(long)}.
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
	 * for the weight value.
	 * 
	 * Setting the length to 1 will turn the averaging off. With less
	 * averaging, there is more noise on the data.
	 * 
	 * The range for the averaging is 1-40.
	 * 
	 * The default value is 4.
	 */
	public void setMovingAverage(short average) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_MOVING_AVERAGE, this);
		bb.put((byte)average);

		sendRequest(bb.array());
	}

	/**
	 * Returns the length moving average as set by {@link BrickletLoadCell#setMovingAverage(short)}.
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
	 * Turns the LED on.
	 */
	public void ledOn() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LED_ON, this);

		sendRequest(bb.array());
	}

	/**
	 * Turns the LED off.
	 */
	public void ledOff() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LED_OFF, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns *true* if the led is on, *false* otherwise.
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
	 * To calibrate your Load Cell Bricklet you have to
	 * 
	 * * empty the scale and call this function with 0 and
	 * * add a known weight to the scale and call this function with the weight in 
	 *   grams.
	 * 
	 * The calibration is saved in the EEPROM of the Bricklet and only
	 * needs to be done once.
	 * 
	 * We recommend to use the Brick Viewer for calibration, you don't need
	 * to call this function in your source code.
	 */
	public void calibrate(long weight) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_CALIBRATE, this);
		bb.putInt((int)weight);

		sendRequest(bb.array());
	}

	/**
	 * Sets the currently measured weight as tare weight.
	 */
	public void tare() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_TARE, this);

		sendRequest(bb.array());
	}

	/**
	 * The measurement rate and gain are configurable.
	 * 
	 * The rate can be either 10Hz or 80Hz. A faster rate will produce more noise.
	 * It is additionally possible to add a moving average
	 * (see {@link BrickletLoadCell#setMovingAverage(short)}) to the measurements.
	 * 
	 * The gain can be 128x, 64x or 32x. It represents a measurement range of
	 * ±20mV, ±40mV and ±80mV respectively. The Load Cell Bricklet uses an
	 * excitation voltage of 5V and most load cells use an output of 2mV/V. That
	 * means the voltage range is ±15mV for most load cells (i.e. gain of 128x
	 * is best). If you don't know what all of this means you should keep it at 
	 * 128x, it will most likely be correct.
	 * 
	 * The configuration is saved in the EEPROM of the Bricklet and only
	 * needs to be done once.
	 * 
	 * We recommend to use the Brick Viewer for configuration, you don't need
	 * to call this function in your source code.
	 * 
	 * The default rate is 10Hz and the default gain is 128x.
	 */
	public void setConfiguration(short rate, short gain) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)rate);
		bb.put((byte)gain);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletLoadCell#setConfiguration(short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.rate = IPConnection.unsignedByte(bb.get());
		obj.gain = IPConnection.unsignedByte(bb.get());

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
	 * Adds a Weight listener.
	 */
	public void addWeightListener(WeightListener listener) {
		listenerWeight.add(listener);
	}

	/**
	 * Removes a Weight listener.
	 */
	public void removeWeightListener(WeightListener listener) {
		listenerWeight.remove(listener);
	}

	/**
	 * Adds a WeightReached listener.
	 */
	public void addWeightReachedListener(WeightReachedListener listener) {
		listenerWeightReached.add(listener);
	}

	/**
	 * Removes a WeightReached listener.
	 */
	public void removeWeightReachedListener(WeightReachedListener listener) {
		listenerWeightReached.remove(listener);
	}
}
