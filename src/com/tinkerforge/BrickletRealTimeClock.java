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
 * Battery-backed real-time clock
 */
public class BrickletRealTimeClock extends Device {
	public final static int DEVICE_IDENTIFIER = 268;
	public final static String DEVICE_DISPLAY_NAME = "Real-Time Clock Bricklet";

	public final static byte FUNCTION_SET_DATE_TIME = (byte)1;
	public final static byte FUNCTION_GET_DATE_TIME = (byte)2;
	public final static byte FUNCTION_GET_TIMESTAMP = (byte)3;
	public final static byte FUNCTION_SET_OFFSET = (byte)4;
	public final static byte FUNCTION_GET_OFFSET = (byte)5;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static short WEEKDAY_MONDAY = (short)1;
	public final static short WEEKDAY_TUESDAY = (short)2;
	public final static short WEEKDAY_WEDNESDAY = (short)3;
	public final static short WEEKDAY_THURSDAY = (short)4;
	public final static short WEEKDAY_FRIDAY = (short)5;
	public final static short WEEKDAY_SATURDAY = (short)6;
	public final static short WEEKDAY_SUNDAY = (short)7;


	public class DateTime {
		public int year;
		public short month;
		public short day;
		public short hour;
		public short minute;
		public short second;
		public short centisecond;
		public short weekday;

		public String toString() {
			return "[" + "year = " + year + ", " + "month = " + month + ", " + "day = " + day + ", " + "hour = " + hour + ", " + "minute = " + minute + ", " + "second = " + second + ", " + "centisecond = " + centisecond + ", " + "weekday = " + weekday + "]";
		}
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletRealTimeClock(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DATE_TIME)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DATE_TIME)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TIMESTAMP)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_OFFSET)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_OFFSET)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
	}

	/**
	 * Sets the current date (including weekday) and the current time with hundredths
	 * of a second resolution.
	 * 
	 * Possible value ranges:
	 * 
	 * * Year: 2000 to 2099
	 * * Month: 1 to 12 (January to December)
	 * * Day: 1 to 31
	 * * Hour: 0 to 23
	 * * Minute: 0 to 59
	 * * Second: 0 to 59
	 * * Centisecond: 0 to 99
	 * * Weekday: 1 to 7 (Monday to Sunday)
	 * 
	 * If the backup battery is installed then the real-time clock keeps date and
	 * time even if the Bricklet is not powered by a Brick.
	 * 
	 * The real-time clock handles leap year and inserts the 29th of February
	 * accordingly. But leap seconds, time zones and daylight saving time are not
	 * handled.
	 */
	public void setDateTime(int year, short month, short day, short hour, short minute, short second, short centisecond, short weekday) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_SET_DATE_TIME, this);
		bb.putShort((short)year);
		bb.put((byte)month);
		bb.put((byte)day);
		bb.put((byte)hour);
		bb.put((byte)minute);
		bb.put((byte)second);
		bb.put((byte)centisecond);
		bb.put((byte)weekday);

		sendRequest(bb.array());
	}

	/**
	 * Returns the current date (including weekday) and the current time of the
	 * real-time clock with hundredths of a second resolution.
	 */
	public DateTime getDateTime() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DATE_TIME, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DateTime obj = new DateTime();
		obj.year = IPConnection.unsignedShort(bb.getShort());
		obj.month = IPConnection.unsignedByte(bb.get());
		obj.day = IPConnection.unsignedByte(bb.get());
		obj.hour = IPConnection.unsignedByte(bb.get());
		obj.minute = IPConnection.unsignedByte(bb.get());
		obj.second = IPConnection.unsignedByte(bb.get());
		obj.centisecond = IPConnection.unsignedByte(bb.get());
		obj.weekday = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * Returns the current date and the time of the real-time clock converted to
	 * milliseconds. The timestamp has an effective resolution of hundredths of a
	 * second.
	 */
	public long getTimestamp() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TIMESTAMP, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long timestamp = (bb.getLong());

		return timestamp;
	}

	/**
	 * Sets the offset the real-time clock should compensate for in 2.17 ppm steps
	 * between -277.76 ppm (-128) and +275.59 ppm (127).
	 * 
	 * The real-time clock time can deviate from the actual time due to the frequency
	 * deviation of its 32.768 kHz crystal. Even without compensation (factory
	 * default) the resulting time deviation should be at most ±20 ppm (±52.6
	 * seconds per month).
	 * 
	 * This deviation can be calculated by comparing the same duration measured by the
	 * real-time clock (``rtc_duration``) an accurate reference clock
	 * (``ref_duration``).
	 * 
	 * For best results the configured offset should be set to 0 ppm first and then a
	 * duration of at least 6 hours should be measured.
	 * 
	 * The new offset (``new_offset``) can be calculated from the currently configured
	 * offset (``current_offset``) and the measured durations as follow::
	 * 
	 *   new_offset = current_offset - round(1000000 * (rtc_duration - ref_duration) / rtc_duration / 2.17)
	 * 
	 * If you want to calculate the offset, then we recommend using the calibration
	 * dialog in Brick Viewer, instead of doing it manually.
	 * 
	 * The offset is saved in the EEPROM of the Bricklet and only needs to be
	 * configured once.
	 */
	public void setOffset(byte offset) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_OFFSET, this);
		bb.put(offset);

		sendRequest(bb.array());
	}

	/**
	 * Returns the offset as set by {@link BrickletRealTimeClock#setOffset(byte)}.
	 */
	public byte getOffset() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_OFFSET, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		byte offset = (bb.get());

		return offset;
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
