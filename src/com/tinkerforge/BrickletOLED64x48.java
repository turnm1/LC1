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
 * 1.68cm (0.66") OLED with 64x48 pixels
 */
public class BrickletOLED64x48 extends Device {
	public final static int DEVICE_IDENTIFIER = 264;
	public final static String DEVICE_DISPLAY_NAME = "OLED 64x48 Bricklet";

	public final static byte FUNCTION_WRITE = (byte)1;
	public final static byte FUNCTION_NEW_WINDOW = (byte)2;
	public final static byte FUNCTION_CLEAR_DISPLAY = (byte)3;
	public final static byte FUNCTION_SET_DISPLAY_CONFIGURATION = (byte)4;
	public final static byte FUNCTION_GET_DISPLAY_CONFIGURATION = (byte)5;
	public final static byte FUNCTION_WRITE_LINE = (byte)6;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;



	public class DisplayConfiguration {
		public short contrast;
		public boolean invert;

		public String toString() {
			return "[" + "contrast = " + contrast + ", " + "invert = " + invert + "]";
		}
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletOLED64x48(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_NEW_WINDOW)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_CLEAR_DISPLAY)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DISPLAY_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISPLAY_CONFIGURATION)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE_LINE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
	}

	/**
	 * Appends 64 byte of data to the window as set by {@link BrickletOLED64x48#newWindow(short, short, short, short)}.
	 * 
	 * Each row has a height of 8 pixels which corresponds to one byte of data.
	 * 
	 * Example: if you call {@link BrickletOLED64x48#newWindow(short, short, short, short)} with column from 0 to 63 and row
	 * from 0 to 5 (the whole display) each call of {@link BrickletOLED64x48#write(short[])} (red arrow) will
	 * write one row.
	 * 
	 * .. image:: /Images/Bricklets/bricklet_oled_64x48_display.png
	 *    :scale: 100 %
	 *    :alt: Display pixel order
	 *    :align: center
	 *    :target: ../../_images/Bricklets/bricklet_oled_64x48_display.png
	 * 
	 * The LSB (D0) of each data byte is at the top and the MSB (D7) is at the 
	 * bottom of the row.
	 * 
	 * The next call of {@link BrickletOLED64x48#write(short[])} will write the second row and so on. To
	 * fill the whole display you need to call {@link BrickletOLED64x48#write(short[])} 6 times.
	 */
	public void write(short[] data) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)72, FUNCTION_WRITE, this);
		for(int i = 0; i < 64; i++) {
			bb.put((byte)data[i]);
		}


		sendRequest(bb.array());
	}

	/**
	 * Sets the window in which you can write with {@link BrickletOLED64x48#write(short[])}. One row
	 * has a height of 8 pixels.
	 * 
	 * The columns have a range of 0 to 63 and the rows have a range of 0 to 5.
	 */
	public void newWindow(short columnFrom, short columnTo, short rowFrom, short rowTo) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_NEW_WINDOW, this);
		bb.put((byte)columnFrom);
		bb.put((byte)columnTo);
		bb.put((byte)rowFrom);
		bb.put((byte)rowTo);

		sendRequest(bb.array());
	}

	/**
	 * Clears the current content of the window as set by {@link BrickletOLED64x48#newWindow(short, short, short, short)}.
	 */
	public void clearDisplay() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_CLEAR_DISPLAY, this);

		sendRequest(bb.array());
	}

	/**
	 * Sets the configuration of the display.
	 * 
	 * You can set a contrast value from 0 to 255 and you can invert the color
	 * (black/white) of the display.
	 * 
	 * The default values are contrast 143 and inverting off.
	 */
	public void setDisplayConfiguration(short contrast, boolean invert) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_DISPLAY_CONFIGURATION, this);
		bb.put((byte)contrast);
		bb.put((byte)(invert ? 1 : 0));

		sendRequest(bb.array());
	}

	/**
	 * Returns the configuration as set by {@link BrickletOLED64x48#setDisplayConfiguration(short, boolean)}.
	 */
	public DisplayConfiguration getDisplayConfiguration() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISPLAY_CONFIGURATION, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DisplayConfiguration obj = new DisplayConfiguration();
		obj.contrast = IPConnection.unsignedByte(bb.get());
		obj.invert = (bb.get()) != 0;

		return obj;
	}

	/**
	 * Writes text to a specific line (0 to 5) with a specific position 
	 * (0 to 12). The text can have a maximum of 13 characters.
	 * 
	 * For example: (1, 4, "Hello") will write *Hello* in the middle of the
	 * second line of the display.
	 * 
	 * You can draw to the display with {@link BrickletOLED64x48#write(short[])} and then add text to it
	 * afterwards.
	 * 
	 * The display uses a special 5x7 pixel charset. You can view the characters 
	 * of the charset in Brick Viewer.
	 */
	public void writeLine(short line, short position, String text) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)23, FUNCTION_WRITE_LINE, this);
		bb.put((byte)line);
		bb.put((byte)position);
		for(int i = 0; i < 13; i++) {
			try {
				bb.put((byte)text.charAt(i));
			} catch(Exception e) {
				bb.put((byte)0);
			}
		}


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
}
