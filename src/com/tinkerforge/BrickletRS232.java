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
 * Communicates with RS232 devices
 */
public class BrickletRS232 extends Device {
	public final static int DEVICE_IDENTIFIER = 254;
	public final static String DEVICE_DISPLAY_NAME = "RS232 Bricklet";

	public final static byte FUNCTION_WRITE = (byte)1;
	public final static byte FUNCTION_READ = (byte)2;
	public final static byte FUNCTION_ENABLE_READ_CALLBACK = (byte)3;
	public final static byte FUNCTION_DISABLE_READ_CALLBACK = (byte)4;
	public final static byte FUNCTION_IS_READ_CALLBACK_ENABLED = (byte)5;
	public final static byte FUNCTION_SET_CONFIGURATION = (byte)6;
	public final static byte FUNCTION_GET_CONFIGURATION = (byte)7;
	public final static byte CALLBACK_READ_CALLBACK = (byte)8;
	public final static byte CALLBACK_ERROR_CALLBACK = (byte)9;
	public final static byte FUNCTION_SET_BREAK_CONDITION = (byte)10;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static short BAUDRATE_300 = (short)0;
	public final static short BAUDRATE_600 = (short)1;
	public final static short BAUDRATE_1200 = (short)2;
	public final static short BAUDRATE_2400 = (short)3;
	public final static short BAUDRATE_4800 = (short)4;
	public final static short BAUDRATE_9600 = (short)5;
	public final static short BAUDRATE_14400 = (short)6;
	public final static short BAUDRATE_19200 = (short)7;
	public final static short BAUDRATE_28800 = (short)8;
	public final static short BAUDRATE_38400 = (short)9;
	public final static short BAUDRATE_57600 = (short)10;
	public final static short BAUDRATE_115200 = (short)11;
	public final static short BAUDRATE_230400 = (short)12;
	public final static short PARITY_NONE = (short)0;
	public final static short PARITY_ODD = (short)1;
	public final static short PARITY_EVEN = (short)2;
	public final static short PARITY_FORCED_PARITY_1 = (short)3;
	public final static short PARITY_FORCED_PARITY_0 = (short)4;
	public final static short STOPBITS_1 = (short)1;
	public final static short STOPBITS_2 = (short)2;
	public final static short WORDLENGTH_5 = (short)5;
	public final static short WORDLENGTH_6 = (short)6;
	public final static short WORDLENGTH_7 = (short)7;
	public final static short WORDLENGTH_8 = (short)8;
	public final static short HARDWARE_FLOWCONTROL_OFF = (short)0;
	public final static short HARDWARE_FLOWCONTROL_ON = (short)1;
	public final static short SOFTWARE_FLOWCONTROL_OFF = (short)0;
	public final static short SOFTWARE_FLOWCONTROL_ON = (short)1;
	public final static short ERROR_OVERRUN = (short)1;
	public final static short ERROR_PARITY = (short)2;
	public final static short ERROR_FRAMING = (short)4;

	private List<ReadCallbackListener> listenerReadCallback = new CopyOnWriteArrayList<ReadCallbackListener>();
	private List<ErrorCallbackListener> listenerErrorCallback = new CopyOnWriteArrayList<ErrorCallbackListener>();

	public class Read {
		public char[] message = new char[60];
		public short length;

		public String toString() {
			return "[" + "message = " + Arrays.toString(message) + ", " + "length = " + length + "]";
		}
	}

	public class Configuration {
		public short baudrate;
		public short parity;
		public short stopbits;
		public short wordlength;
		public short hardwareFlowcontrol;
		public short softwareFlowcontrol;

		public String toString() {
			return "[" + "baudrate = " + baudrate + ", " + "parity = " + parity + ", " + "stopbits = " + stopbits + ", " + "wordlength = " + wordlength + ", " + "hardwareFlowcontrol = " + hardwareFlowcontrol + ", " + "softwareFlowcontrol = " + softwareFlowcontrol + "]";
		}
	}

	/**
	 * This listener is called if new data is available. The message has
	 * a maximum size of 60 characters. The actual length of the message
	 * is given in addition.
	 * 
	 * To enable this listener, use {@link BrickletRS232#enableReadCallback()}.
	 */
	public interface ReadCallbackListener extends DeviceListener {
		public void readCallback(char[] message, short length);
	}

	/**
	 * This listener is called if an error occurs. 
	 * Possible errors are overrun, parity or framing error.
	 * 
	 * .. versionadded:: 2.0.1$nbsp;(Plugin)
	 */
	public interface ErrorCallbackListener extends DeviceListener {
		public void errorCallback(short error);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletRS232(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 2;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_READ)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ENABLE_READ_CALLBACK)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_DISABLE_READ_CALLBACK)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_READ_CALLBACK_ENABLED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_BREAK_CONDITION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_READ_CALLBACK)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_ERROR_CALLBACK)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_READ_CALLBACK] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				char[] message = new char[60];
				for(int i = 0; i < 60; i++) {
					message[i] = (char)(bb.get());
				}

				short length = IPConnection.unsignedByte(bb.get());

				for(ReadCallbackListener listener: listenerReadCallback) {
					listener.readCallback(message, length);
				}
			}
		};

		callbacks[CALLBACK_ERROR_CALLBACK] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short error = IPConnection.unsignedByte(bb.get());

				for(ErrorCallbackListener listener: listenerErrorCallback) {
					listener.errorCallback(error);
				}
			}
		};
	}

	/**
	 * Writes a string of up to 60 characters to the RS232 interface. The string
	 * can be binary data, ASCII or similar is not necessary.
	 * 
	 * The length of the string has to be given as an additional parameter.
	 * 
	 * The return value is the number of bytes that could be written.
	 * 
	 * See :func:`SetConfigurations` for configuration possibilities
	 * regarding baudrate, parity and so on.
	 */
	public short write(char[] message, short length) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)69, FUNCTION_WRITE, this);
		for(int i = 0; i < 60; i++) {
			bb.put((byte)message[i]);
		}

		bb.put((byte)length);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short written = IPConnection.unsignedByte(bb.get());

		return written;
	}

	/**
	 * Returns the currently buffered message. The maximum length
	 * of message is 60. If the length is given as 0, there was no
	 * new data available.
	 * 
	 * Instead of polling with this function, you can also use
	 * callbacks. See {@link BrickletRS232#enableReadCallback()} and {@link BrickletRS232.ReadCallbackListener}.
	 */
	public Read read() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_READ, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Read obj = new Read();
		for(int i = 0; i < 60; i++) {
			obj.message[i] = (char)(bb.get());
		}

		obj.length = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Enables the {@link BrickletRS232.ReadCallbackListener}.
	 * 
	 * By default the listener is disabled.
	 */
	public void enableReadCallback() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_ENABLE_READ_CALLBACK, this);

		sendRequest(bb.array());
	}

	/**
	 * Disables the {@link BrickletRS232.ReadCallbackListener}.
	 * 
	 * By default the listener is disabled.
	 */
	public void disableReadCallback() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_DISABLE_READ_CALLBACK, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns *true* if the {@link BrickletRS232.ReadCallbackListener} is enabled,
	 * *false* otherwise.
	 */
	public boolean isReadCallbackEnabled() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_IS_READ_CALLBACK_ENABLED, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		boolean enabled = (bb.get()) != 0;

		return enabled;
	}

	/**
	 * Sets the configuration for the RS232 communication. Available options:
	 * 
	 * * Baudrate between 300 and 230400 baud.
	 * * Parity of none, odd, even or forced parity.
	 * * Stopbits can be 1 or 2.
	 * * Word length of 5 to 8.
	 * * Hard-/Software flow control can each be on or off.
	 * 
	 * The default is: 115200 baud, parity none, 1 stop bit, word length 8, hard-/software flow control off.
	 */
	public void setConfiguration(short baudrate, short parity, short stopbits, short wordlength, short hardwareFlowcontrol, short softwareFlowcontrol) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)14, FUNCTION_SET_CONFIGURATION, this);
		bb.put((byte)baudrate);
		bb.put((byte)parity);
		bb.put((byte)stopbits);
		bb.put((byte)wordlength);
		bb.put((byte)hardwareFlowcontrol);
		bb.put((byte)softwareFlowcontrol);

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletRS232#setConfiguration(short, short, short, short, short, short)}.
	 */
	public Configuration getConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Configuration obj = new Configuration();
		obj.baudrate = IPConnection.unsignedByte(bb.get());
		obj.parity = IPConnection.unsignedByte(bb.get());
		obj.stopbits = IPConnection.unsignedByte(bb.get());
		obj.wordlength = IPConnection.unsignedByte(bb.get());
		obj.hardwareFlowcontrol = IPConnection.unsignedByte(bb.get());
		obj.softwareFlowcontrol = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Sets a break condition (the TX output is forced to a logic 0 state). 
	 * The parameter sets the hold-time of the break condition (in ms). 
	 * 
	 * .. versionadded:: 2.0.2$nbsp;(Plugin)
	 */
	public void setBreakCondition(int breakTime) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_BREAK_CONDITION, this);
		bb.putShort((short)breakTime);

		sendRequest(bb.array());
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
	 * Adds a ReadCallback listener.
	 */
	public void addReadCallbackListener(ReadCallbackListener listener) {
		listenerReadCallback.add(listener);
	}

	/**
	 * Removes a ReadCallback listener.
	 */
	public void removeReadCallbackListener(ReadCallbackListener listener) {
		listenerReadCallback.remove(listener);
	}

	/**
	 * Adds a ErrorCallback listener.
	 */
	public void addErrorCallbackListener(ErrorCallbackListener listener) {
		listenerErrorCallback.add(listener);
	}

	/**
	 * Removes a ErrorCallback listener.
	 */
	public void removeErrorCallbackListener(ErrorCallbackListener listener) {
		listenerErrorCallback.remove(listener);
	}
}
