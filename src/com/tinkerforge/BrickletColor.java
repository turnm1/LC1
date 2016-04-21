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
 * Measures color (RGB value), illuminance and color temperature
 */
public class BrickletColor extends Device {
	public final static int DEVICE_IDENTIFIER = 243;
	public final static String DEVICE_DISPLAY_NAME = "Color Bricklet";

	public final static byte FUNCTION_GET_COLOR = (byte)1;
	public final static byte FUNCTION_SET_COLOR_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_COLOR_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_COLOR_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_COLOR_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_COLOR = (byte)8;
	public final static byte CALLBACK_COLOR_REACHED = (byte)9;
	public final static byte FUNCTION_LIGHT_ON = (byte)10;
	public final static byte FUNCTION_LIGHT_OFF = (byte)11;
	public final static byte FUNCTION_IS_LIGHT_ON = (byte)12;
	public final static byte FUNCTION_SET_CONFIG = (byte)13;
	public final static byte FUNCTION_GET_CONFIG = (byte)14;
	public final static byte FUNCTION_GET_ILLUMINANCE = (byte)15;
	public final static byte FUNCTION_GET_COLOR_TEMPERATURE = (byte)16;
	public final static byte FUNCTION_SET_ILLUMINANCE_CALLBACK_PERIOD = (byte)17;
	public final static byte FUNCTION_GET_ILLUMINANCE_CALLBACK_PERIOD = (byte)18;
	public final static byte FUNCTION_SET_COLOR_TEMPERATURE_CALLBACK_PERIOD = (byte)19;
	public final static byte FUNCTION_GET_COLOR_TEMPERATURE_CALLBACK_PERIOD = (byte)20;
	public final static byte CALLBACK_ILLUMINANCE = (byte)21;
	public final static byte CALLBACK_COLOR_TEMPERATURE = (byte)22;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short LIGHT_ON = (short)0;
	public final static short LIGHT_OFF = (short)1;
	public final static short GAIN_1X = (short)0;
	public final static short GAIN_4X = (short)1;
	public final static short GAIN_16X = (short)2;
	public final static short GAIN_60X = (short)3;
	public final static short INTEGRATION_TIME_2MS = (short)0;
	public final static short INTEGRATION_TIME_24MS = (short)1;
	public final static short INTEGRATION_TIME_101MS = (short)2;
	public final static short INTEGRATION_TIME_154MS = (short)3;
	public final static short INTEGRATION_TIME_700MS = (short)4;

	private List<ColorListener> listenerColor = new CopyOnWriteArrayList<ColorListener>();
	private List<ColorReachedListener> listenerColorReached = new CopyOnWriteArrayList<ColorReachedListener>();
	private List<IlluminanceListener> listenerIlluminance = new CopyOnWriteArrayList<IlluminanceListener>();
	private List<ColorTemperatureListener> listenerColorTemperature = new CopyOnWriteArrayList<ColorTemperatureListener>();

	public class Color {
		public int r;
		public int g;
		public int b;
		public int c;

		public String toString() {
			return "[" + "r = " + r + ", " + "g = " + g + ", " + "b = " + b + ", " + "c = " + c + "]";
		}
	}

	public class ColorCallbackThreshold {
		public char option;
		public int minR;
		public int maxR;
		public int minG;
		public int maxG;
		public int minB;
		public int maxB;
		public int minC;
		public int maxC;

		public String toString() {
			return "[" + "option = " + option + ", " + "minR = " + minR + ", " + "maxR = " + maxR + ", " + "minG = " + minG + ", " + "maxG = " + maxG + ", " + "minB = " + minB + ", " + "maxB = " + maxB + ", " + "minC = " + minC + ", " + "maxC = " + maxC + "]";
		}
	}

	public class Config {
		public short gain;
		public short integrationTime;

		public String toString() {
			return "[" + "gain = " + gain + ", " + "integrationTime = " + integrationTime + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletColor#setColorCallbackPeriod(long)}. The parameter is the color
	 * of the sensor as RGBC.
	 * 
	 * {@link BrickletColor.ColorListener} is only triggered if the color has changed since the
	 * last triggering.
	 */
	public interface ColorListener extends DeviceListener {
		public void color(int r, int g, int b, int c);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletColor#setColorCallbackThreshold(char, int, int, int, int, int, int, int, int)} is reached.
	 * The parameter is the color
	 * of the sensor as RGBC.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletColor#setDebouncePeriod(long)}.
	 */
	public interface ColorReachedListener extends DeviceListener {
		public void colorReached(int r, int g, int b, int c);
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletColor#setIlluminanceCallbackPeriod(long)}. The parameter is the illuminance.
	 * See {@link BrickletColor#getIlluminance()} for how to interpret this value.
	 * 
	 * {@link BrickletColor.IlluminanceListener} is only triggered if the illuminance has changed since the
	 * last triggering.
	 */
	public interface IlluminanceListener extends DeviceListener {
		public void illuminance(long illuminance);
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletColor#setColorTemperatureCallbackPeriod(long)}. The parameter is the 
	 * color temperature in Kelvin.
	 * 
	 * {@link BrickletColor.ColorTemperatureListener} is only triggered if the color temperature has 
	 * changed since the last triggering.
	 */
	public interface ColorTemperatureListener extends DeviceListener {
		public void colorTemperature(int colorTemperature);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletColor(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_COLOR)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_COLOR_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_COLOR_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_COLOR_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_COLOR_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LIGHT_ON)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_LIGHT_OFF)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_LIGHT_ON)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIG)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIG)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ILLUMINANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_COLOR_TEMPERATURE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_ILLUMINANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_ILLUMINANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_COLOR_TEMPERATURE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_COLOR_TEMPERATURE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_COLOR)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_COLOR_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ILLUMINANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_COLOR_TEMPERATURE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_COLOR] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int r = IPConnection.unsignedShort(bb.getShort());
				int g = IPConnection.unsignedShort(bb.getShort());
				int b = IPConnection.unsignedShort(bb.getShort());
				int c = IPConnection.unsignedShort(bb.getShort());

				for(ColorListener listener: listenerColor) {
					listener.color(r, g, b, c);
				}
			}
		};

		callbacks[CALLBACK_COLOR_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int r = IPConnection.unsignedShort(bb.getShort());
				int g = IPConnection.unsignedShort(bb.getShort());
				int b = IPConnection.unsignedShort(bb.getShort());
				int c = IPConnection.unsignedShort(bb.getShort());

				for(ColorReachedListener listener: listenerColorReached) {
					listener.colorReached(r, g, b, c);
				}
			}
		};

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

		callbacks[CALLBACK_COLOR_TEMPERATURE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int colorTemperature = IPConnection.unsignedShort(bb.getShort());

				for(ColorTemperatureListener listener: listenerColorTemperature) {
					listener.colorTemperature(colorTemperature);
				}
			}
		};
	}

	/**
	 * Returns the measured color of the sensor. The values
	 * have a range of 0 to 65535.
	 * 
	 * The red (r), green (g), blue (b) and clear (c) colors are measured
	 * with four different photodiodes that are responsive at different
	 * wavelengths:
	 * 
	 * .. image:: /Images/Bricklets/bricklet_color_wavelength_chart_600.jpg
	 *    :scale: 100 %
	 *    :alt: Chart Responsivity / Wavelength
	 *    :align: center
	 *    :target: ../../_images/Bricklets/bricklet_color_wavelength_chart_600.jpg
	 * 
	 * If you want to get the color periodically, it is recommended 
	 * to use the listener {@link BrickletColor.ColorListener} and set the period with 
	 * {@link BrickletColor#setColorCallbackPeriod(long)}.
	 */
	public Color getColor() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_COLOR, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Color obj = new Color();
		obj.r = IPConnection.unsignedShort(bb.getShort());
		obj.g = IPConnection.unsignedShort(bb.getShort());
		obj.b = IPConnection.unsignedShort(bb.getShort());
		obj.c = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletColor.ColorListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletColor.ColorListener} is only triggered if the color has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setColorCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_COLOR_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletColor#setColorCallbackPeriod(long)}.
	 */
	public long getColorCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_COLOR_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletColor.ColorReachedListener} listener. 
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
	 * The default value is ('x', 0, 0, 0, 0, 0, 0, 0, 0).
	 */
	public void setColorCallbackThreshold(char option, int minR, int maxR, int minG, int maxG, int minB, int maxB, int minC, int maxC) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)25, FUNCTION_SET_COLOR_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)minR);
		bb.putShort((short)maxR);
		bb.putShort((short)minG);
		bb.putShort((short)maxG);
		bb.putShort((short)minB);
		bb.putShort((short)maxB);
		bb.putShort((short)minC);
		bb.putShort((short)maxC);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletColor#setColorCallbackThreshold(char, int, int, int, int, int, int, int, int)}.
	 */
	public ColorCallbackThreshold getColorCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_COLOR_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		ColorCallbackThreshold obj = new ColorCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.minR = IPConnection.unsignedShort(bb.getShort());
		obj.maxR = IPConnection.unsignedShort(bb.getShort());
		obj.minG = IPConnection.unsignedShort(bb.getShort());
		obj.maxG = IPConnection.unsignedShort(bb.getShort());
		obj.minB = IPConnection.unsignedShort(bb.getShort());
		obj.maxB = IPConnection.unsignedShort(bb.getShort());
		obj.minC = IPConnection.unsignedShort(bb.getShort());
		obj.maxC = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listener
	 * 
	 * * {@link BrickletColor.ColorReachedListener}
	 * 
	 * is triggered, if the threshold
	 * 
	 * * {@link BrickletColor#setColorCallbackThreshold(char, int, int, int, int, int, int, int, int)}
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
	 * Returns the debounce period as set by {@link BrickletColor#setDebouncePeriod(long)}.
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
	 * Turns the LED on.
	 */
	public void lightOn() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LIGHT_ON, this);

		sendRequest(bb.array());
	}

	/**
	 * Turns the LED off.
	 */
	public void lightOff() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_LIGHT_OFF, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns the state of the LED. Possible values are:
	 * 
	 * * 0: On
	 * * 1: Off
	 */
	public short isLightOn() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_IS_LIGHT_ON, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short light = IPConnection.unsignedByte(bb.get());

		return light;
	}

	/**
	 * Sets the configuration of the sensor. Gain and integration time
	 * can be configured in this way.
	 * 
	 * For configuring the gain:
	 * 
	 * * 0: 1x Gain
	 * * 1: 4x Gain
	 * * 2: 16x Gain
	 * * 3: 60x Gain
	 * 
	 * For configuring the integration time:
	 * 
	 * * 0: 2.4ms
	 * * 1: 24ms
	 * * 2: 101ms
	 * * 3: 154ms
	 * * 4: 700ms
	 * 
	 * Increasing the gain enables the sensor to detect a
	 * color from a higher distance.
	 * 
	 * The integration time provides a trade-off between conversion time
	 * and accuracy. With a longer integration time the values read will
	 * be more accurate but it will take longer time to get the conversion
	 * results.
	 * 
	 * The default values are 60x gain and 154ms integration time.
	 */
	public void setConfig(short gain, short integrationTime) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_CONFIG, this);
		bb.put((byte)gain);
		bb.put((byte)integrationTime);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletColor#setConfig(short, short)}.
	 */
	public Config getConfig() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIG, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Config obj = new Config();
		obj.gain = IPConnection.unsignedByte(bb.get());
		obj.integrationTime = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Returns the illuminance affected by the gain and integration time as
	 * set by {@link BrickletColor#setConfig(short, short)}. To get the illuminance in Lux apply this formula::
	 * 
	 *  lux = illuminance * 700 / gain / integration_time
	 * 
	 * To get a correct illuminance measurement make sure that the color
	 * values themself are not saturated. The color value (R, G or B)
	 * is saturated if it is equal to the maximum value of 65535.
	 * In that case you have to reduce the gain, see {@link BrickletColor#setConfig(short, short)}.
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
	 * Returns the color temperature in Kelvin.
	 * 
	 * To get a correct color temperature measurement make sure that the color
	 * values themself are not saturated. The color value (R, G or B)
	 * is saturated if it is equal to the maximum value of 65535.
	 * In that case you have to reduce the gain, see {@link BrickletColor#setConfig(short, short)}.
	 */
	public int getColorTemperature() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_COLOR_TEMPERATURE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int colorTemperature = IPConnection.unsignedShort(bb.getShort());

		return colorTemperature;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletColor.IlluminanceListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletColor.IlluminanceListener} is only triggered if the illuminance has changed since the
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
	 * Returns the period as set by {@link BrickletColor#setIlluminanceCallbackPeriod(long)}.
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
	 * Sets the period in ms with which the {@link BrickletColor.ColorTemperatureListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletColor.ColorTemperatureListener} is only triggered if the color temperature has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setColorTemperatureCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_COLOR_TEMPERATURE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletColor#setColorTemperatureCallbackPeriod(long)}.
	 */
	public long getColorTemperatureCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_COLOR_TEMPERATURE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
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
	 * Adds a Color listener.
	 */
	public void addColorListener(ColorListener listener) {
		listenerColor.add(listener);
	}

	/**
	 * Removes a Color listener.
	 */
	public void removeColorListener(ColorListener listener) {
		listenerColor.remove(listener);
	}

	/**
	 * Adds a ColorReached listener.
	 */
	public void addColorReachedListener(ColorReachedListener listener) {
		listenerColorReached.add(listener);
	}

	/**
	 * Removes a ColorReached listener.
	 */
	public void removeColorReachedListener(ColorReachedListener listener) {
		listenerColorReached.remove(listener);
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
	 * Adds a ColorTemperature listener.
	 */
	public void addColorTemperatureListener(ColorTemperatureListener listener) {
		listenerColorTemperature.add(listener);
	}

	/**
	 * Removes a ColorTemperature listener.
	 */
	public void removeColorTemperatureListener(ColorTemperatureListener listener) {
		listenerColorTemperature.remove(listener);
	}
}
