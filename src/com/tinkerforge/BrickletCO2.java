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
 * Measures CO2 concentration in ppm
 */
public class BrickletCO2 extends Device {
	public final static int DEVICE_IDENTIFIER = 262;
	public final static String DEVICE_DISPLAY_NAME = "CO2 Bricklet";

	public final static byte FUNCTION_GET_CO2_CONCENTRATION = (byte)1;
	public final static byte FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_PERIOD = (byte)2;
	public final static byte FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_THRESHOLD = (byte)4;
	public final static byte FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_THRESHOLD = (byte)5;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)6;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)7;
	public final static byte CALLBACK_CO2_CONCENTRATION = (byte)8;
	public final static byte CALLBACK_CO2_CONCENTRATION_REACHED = (byte)9;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';

	private List<CO2ConcentrationListener> listenerCO2Concentration = new CopyOnWriteArrayList<CO2ConcentrationListener>();
	private List<CO2ConcentrationReachedListener> listenerCO2ConcentrationReached = new CopyOnWriteArrayList<CO2ConcentrationReachedListener>();

	public class CO2ConcentrationCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletCO2#setCO2ConcentrationCallbackPeriod(long)}. The parameter is the CO2 concentration of the
	 * sensor.
	 * 
	 * {@link BrickletCO2.CO2ConcentrationListener} is only triggered if the CO2 concentration has changed since the
	 * last triggering.
	 */
	public interface CO2ConcentrationListener extends DeviceListener {
		public void co2Concentration(int co2Concentration);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletCO2#setCO2ConcentrationCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the CO2 concentration.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletCO2#setDebouncePeriod(long)}.
	 */
	public interface CO2ConcentrationReachedListener extends DeviceListener {
		public void co2ConcentrationReached(int co2Concentration);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletCO2(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CO2_CONCENTRATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_CO2_CONCENTRATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_CO2_CONCENTRATION_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_CO2_CONCENTRATION] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int co2Concentration = IPConnection.unsignedShort(bb.getShort());

				for(CO2ConcentrationListener listener: listenerCO2Concentration) {
					listener.co2Concentration(co2Concentration);
				}
			}
		};

		callbacks[CALLBACK_CO2_CONCENTRATION_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int co2Concentration = IPConnection.unsignedShort(bb.getShort());

				for(CO2ConcentrationReachedListener listener: listenerCO2ConcentrationReached) {
					listener.co2ConcentrationReached(co2Concentration);
				}
			}
		};
	}

	/**
	 * Returns the measured CO2 concentration. The value is in 
	 * `ppm (parts per million) &lt;https://en.wikipedia.org/wiki/Parts-per_notation&gt;`__
	 * and between 0 to 10000.
	 * 
	 * If you want to get the CO2 concentration periodically, it is recommended to use the
	 * listener {@link BrickletCO2.CO2ConcentrationListener} and set the period with
	 * {@link BrickletCO2#setCO2ConcentrationCallbackPeriod(long)}.
	 */
	public int getCO2Concentration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CO2_CONCENTRATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int co2Concentration = IPConnection.unsignedShort(bb.getShort());

		return co2Concentration;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletCO2.CO2ConcentrationListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletCO2.CO2ConcentrationListener} is only triggered if the CO2 concentration has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setCO2ConcentrationCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletCO2#setCO2ConcentrationCallbackPeriod(long)}.
	 */
	public long getCO2ConcentrationCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletCO2.CO2ConcentrationReachedListener} listener.
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the CO2 concentration is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the CO2 concentration is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the CO2 concentration is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the CO2 concentration is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setCO2ConcentrationCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_CO2_CONCENTRATION_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletCO2#setCO2ConcentrationCallbackThreshold(char, int, int)}.
	 */
	public CO2ConcentrationCallbackThreshold getCO2ConcentrationCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CO2_CONCENTRATION_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		CO2ConcentrationCallbackThreshold obj = new CO2ConcentrationCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletCO2.CO2ConcentrationReachedListener},
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletCO2#setCO2ConcentrationCallbackThreshold(char, int, int)},
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
	 * Returns the debounce period as set by {@link BrickletCO2#setDebouncePeriod(long)}.
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
	 * Adds a CO2Concentration listener.
	 */
	public void addCO2ConcentrationListener(CO2ConcentrationListener listener) {
		listenerCO2Concentration.add(listener);
	}

	/**
	 * Removes a CO2Concentration listener.
	 */
	public void removeCO2ConcentrationListener(CO2ConcentrationListener listener) {
		listenerCO2Concentration.remove(listener);
	}

	/**
	 * Adds a CO2ConcentrationReached listener.
	 */
	public void addCO2ConcentrationReachedListener(CO2ConcentrationReachedListener listener) {
		listenerCO2ConcentrationReached.add(listener);
	}

	/**
	 * Removes a CO2ConcentrationReached listener.
	 */
	public void removeCO2ConcentrationReachedListener(CO2ConcentrationReachedListener listener) {
		listenerCO2ConcentrationReached.remove(listener);
	}
}
