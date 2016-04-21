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
 * Reads and writes NFC and RFID tags
 */
public class BrickletNFCRFID extends Device {
	public final static int DEVICE_IDENTIFIER = 246;
	public final static String DEVICE_DISPLAY_NAME = "NFC/RFID Bricklet";

	public final static byte FUNCTION_REQUEST_TAG_ID = (byte)1;
	public final static byte FUNCTION_GET_TAG_ID = (byte)2;
	public final static byte FUNCTION_GET_STATE = (byte)3;
	public final static byte FUNCTION_AUTHENTICATE_MIFARE_CLASSIC_PAGE = (byte)4;
	public final static byte FUNCTION_WRITE_PAGE = (byte)5;
	public final static byte FUNCTION_REQUEST_PAGE = (byte)6;
	public final static byte FUNCTION_GET_PAGE = (byte)7;
	public final static byte CALLBACK_STATE_CHANGED = (byte)8;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static short TAG_TYPE_MIFARE_CLASSIC = (short)0;
	public final static short TAG_TYPE_TYPE1 = (short)1;
	public final static short TAG_TYPE_TYPE2 = (short)2;
	public final static short STATE_INITIALIZATION = (short)0;
	public final static short STATE_IDLE = (short)128;
	public final static short STATE_ERROR = (short)192;
	public final static short STATE_REQUEST_TAG_ID = (short)2;
	public final static short STATE_REQUEST_TAG_ID_READY = (short)130;
	public final static short STATE_REQUEST_TAG_ID_ERROR = (short)194;
	public final static short STATE_AUTHENTICATING_MIFARE_CLASSIC_PAGE = (short)3;
	public final static short STATE_AUTHENTICATING_MIFARE_CLASSIC_PAGE_READY = (short)131;
	public final static short STATE_AUTHENTICATING_MIFARE_CLASSIC_PAGE_ERROR = (short)195;
	public final static short STATE_WRITE_PAGE = (short)4;
	public final static short STATE_WRITE_PAGE_READY = (short)132;
	public final static short STATE_WRITE_PAGE_ERROR = (short)196;
	public final static short STATE_REQUEST_PAGE = (short)5;
	public final static short STATE_REQUEST_PAGE_READY = (short)133;
	public final static short STATE_REQUEST_PAGE_ERROR = (short)197;
	public final static short KEY_A = (short)0;
	public final static short KEY_B = (short)1;

	private List<StateChangedListener> listenerStateChanged = new CopyOnWriteArrayList<StateChangedListener>();

	public class TagID {
		public short tagType;
		public short tidLength;
		public short[] tid = new short[7];

		public String toString() {
			return "[" + "tagType = " + tagType + ", " + "tidLength = " + tidLength + ", " + "tid = " + Arrays.toString(tid) + "]";
		}
	}

	public class State {
		public short state;
		public boolean idle;

		public String toString() {
			return "[" + "state = " + state + ", " + "idle = " + idle + "]";
		}
	}

	/**
	 * This listener is called if the state of the NFC/RFID Bricklet changes.
	 * See {@link BrickletNFCRFID#getState()} for more information about the possible states.
	 */
	public interface StateChangedListener extends DeviceListener {
		public void stateChanged(short state, boolean idle);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletNFCRFID(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_REQUEST_TAG_ID)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_TAG_ID)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_AUTHENTICATE_MIFARE_CLASSIC_PAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_WRITE_PAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_REQUEST_PAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_PAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_STATE_CHANGED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_STATE_CHANGED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short state = IPConnection.unsignedByte(bb.get());
				boolean idle = (bb.get()) != 0;

				for(StateChangedListener listener: listenerStateChanged) {
					listener.stateChanged(state, idle);
				}
			}
		};
	}

	/**
	 * To read or write a tag that is in proximity of the NFC/RFID Bricklet you 
	 * first have to call this function with the expected tag type as parameter.
	 * It is no problem if you don't know the tag type. You can cycle through 
	 * the available tag types until the tag gives an answer to the request.
	 * 
	 * Current the following tag types are supported:
	 * 
	 * * Mifare Classic
	 * * NFC Forum Type 1
	 * * NFC Forum Type 2
	 * 
	 * After you call {@link BrickletNFCRFID#requestTagID(short)} the NFC/RFID Bricklet will try to read 
	 * the tag ID from the tag. After this process is done the state will change.
	 * You can either register the {@link BrickletNFCRFID.StateChangedListener} listener or you can poll
	 * {@link BrickletNFCRFID#getState()} to find out about the state change.
	 * 
	 * If the state changes to *RequestTagIDError* it means that either there was 
	 * no tag present or that the tag is of an incompatible type. If the state 
	 * changes to *RequestTagIDReady* it means that a compatible tag was found 
	 * and that the tag ID could be read out. You can now get the tag ID by
	 * calling {@link BrickletNFCRFID#getTagID()}.
	 * 
	 * If two tags are in the proximity of the NFC/RFID Bricklet, this
	 * function will cycle through the tags. To select a specific tag you have
	 * to call {@link BrickletNFCRFID#requestTagID(short)} until the correct tag id is found.
	 * 
	 * In case of any *Error* state the selection is lost and you have to
	 * start again by calling {@link BrickletNFCRFID#requestTagID(short)}.
	 */
	public void requestTagID(short tagType) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_REQUEST_TAG_ID, this);
		bb.put((byte)tagType);

		sendRequest(bb.array());
	}

	/**
	 * Returns the tag type, tag ID and the length of the tag ID 
	 * (4 or 7 bytes are possible length). This function can only be called if the
	 * NFC/RFID is currently in one of the *Ready* states. The returned ID
	 * is the ID that was saved through the last call of {@link BrickletNFCRFID#requestTagID(short)}.
	 * 
	 * To get the tag ID of a tag the approach is as follows:
	 * 
	 * 1. Call {@link BrickletNFCRFID#requestTagID(short)}
	 * 2. Wait for state to change to *RequestTagIDReady* (see {@link BrickletNFCRFID#getState()} or
	 *    {@link BrickletNFCRFID.StateChangedListener})
	 * 3. Call {@link BrickletNFCRFID#getTagID()}
	 */
	public TagID getTagID() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_TAG_ID, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		TagID obj = new TagID();
		obj.tagType = IPConnection.unsignedByte(bb.get());
		obj.tidLength = IPConnection.unsignedByte(bb.get());
		for(int i = 0; i < 7; i++) {
			obj.tid[i] = IPConnection.unsignedByte(bb.get());
		}


		return obj;
	}

	/**
	 * Returns the current state of the NFC/RFID Bricklet.
	 * 
	 * On startup the Bricklet will be in the *Initialization* state. The
	 * initialization will only take about 20ms. After that it changes to *Idle*.
	 * 
	 * The functions of this Bricklet can be called in the *Idle* state and all of
	 * the *Ready* and *Error* states.
	 * 
	 * Example: If you call {@link BrickletNFCRFID#requestPage(int)}, the state will change to 
	 * *RequestPage* until the reading of the page is finished. Then it will change
	 * to either *RequestPageReady* if it worked or to *RequestPageError* if it
	 * didn't. If the request worked you can get the page by calling {@link BrickletNFCRFID#getPage()}.
	 * 
	 * The same approach is used analogously for the other API functions.
	 */
	public State getState() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_STATE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		State obj = new State();
		obj.state = IPConnection.unsignedByte(bb.get());
		obj.idle = (bb.get()) != 0;

		return obj;
	}

	/**
	 * Mifare Classic tags use authentication. If you want to read from or write to
	 * a Mifare Classic page you have to authenticate it beforehand.
	 * Each page can be authenticated with two keys: A (``key_number`` = 0) and B
	 * (``key_number`` = 1). A new Mifare Classic
	 * tag that has not yet been written to can can be accessed with key A
	 * and the default key ``[0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF]``.
	 * 
	 * The approach to read or write a Mifare Classic page is as follows:
	 * 
	 * 1. Call {@link BrickletNFCRFID#requestTagID(short)}
	 * 2. Wait for state to change to *RequestTagIDReady* (see {@link BrickletNFCRFID#getState()}
	 *    or {@link BrickletNFCRFID.StateChangedListener})
	 * 3. If looking for a specific tag then call {@link BrickletNFCRFID#getTagID()} and check if the
	 *    expected tag was found, if it was not found got back to step 1
	 * 4. Call {@link BrickletNFCRFID#authenticateMifareClassicPage(int, short, short[])} with page and key for the page
	 * 5. Wait for state to change to *AuthenticatingMifareClassicPageReady* (see
	 *    {@link BrickletNFCRFID#getState()} or {@link BrickletNFCRFID.StateChangedListener})
	 * 6. Call {@link BrickletNFCRFID#requestPage(int)} or {@link BrickletNFCRFID#writePage(int, short[])} to read/write page
	 */
	public void authenticateMifareClassicPage(int page, short keyNumber, short[] key) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)17, FUNCTION_AUTHENTICATE_MIFARE_CLASSIC_PAGE, this);
		bb.putShort((short)page);
		bb.put((byte)keyNumber);
		for(int i = 0; i < 6; i++) {
			bb.put((byte)key[i]);
		}


		sendRequest(bb.array());
	}

	/**
	 * Writes 16 bytes starting from the given page. How many pages are written
	 * depends on the tag type. The page sizes are as follows:
	 * 
	 * * Mifare Classic page size: 16 byte (one page is written)
	 * * NFC Forum Type 1 page size: 8 byte (two pages are written)
	 * * NFC Forum Type 2 page size: 4 byte (four pages are written)
	 * 
	 * The general approach for writing to a tag is as follows:
	 * 
	 * 1. Call {@link BrickletNFCRFID#requestTagID(short)}
	 * 2. Wait for state to change to *RequestTagIDReady* (see {@link BrickletNFCRFID#getState()} or
	 *    {@link BrickletNFCRFID.StateChangedListener})
	 * 3. If looking for a specific tag then call {@link BrickletNFCRFID#getTagID()} and check if the
	 *    expected tag was found, if it was not found got back to step 1
	 * 4. Call {@link BrickletNFCRFID#writePage(int, short[])} with page number and data
	 * 5. Wait for state to change to *WritePageReady* (see {@link BrickletNFCRFID#getState()} or
	 *    {@link BrickletNFCRFID.StateChangedListener})
	 * 
	 * If you use a Mifare Classic tag you have to authenticate a page before you
	 * can write to it. See {@link BrickletNFCRFID#authenticateMifareClassicPage(int, short, short[])}.
	 */
	public void writePage(int page, short[] data) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)26, FUNCTION_WRITE_PAGE, this);
		bb.putShort((short)page);
		for(int i = 0; i < 16; i++) {
			bb.put((byte)data[i]);
		}


		sendRequest(bb.array());
	}

	/**
	 * Reads 16 bytes starting from the given page and stores them into a buffer. 
	 * The buffer can then be read out with {@link BrickletNFCRFID#getPage()}.
	 * How many pages are read depends on the tag type. The page sizes are 
	 * as follows:
	 * 
	 * * Mifare Classic page size: 16 byte (one page is read)
	 * * NFC Forum Type 1 page size: 8 byte (two pages are read)
	 * * NFC Forum Type 2 page size: 4 byte (four pages are read)
	 * 
	 * The general approach for reading a tag is as follows:
	 * 
	 * 1. Call {@link BrickletNFCRFID#requestTagID(short)}
	 * 2. Wait for state to change to *RequestTagIDReady* (see {@link BrickletNFCRFID#getState()}
	 *    or {@link BrickletNFCRFID.StateChangedListener})
	 * 3. If looking for a specific tag then call {@link BrickletNFCRFID#getTagID()} and check if the
	 *    expected tag was found, if it was not found got back to step 1
	 * 4. Call {@link BrickletNFCRFID#requestPage(int)} with page number
	 * 5. Wait for state to change to *RequestPageReady* (see {@link BrickletNFCRFID#getState()}
	 *    or {@link BrickletNFCRFID.StateChangedListener})
	 * 6. Call {@link BrickletNFCRFID#getPage()} to retrieve the page from the buffer
	 * 
	 * If you use a Mifare Classic tag you have to authenticate a page before you
	 * can read it. See {@link BrickletNFCRFID#authenticateMifareClassicPage(int, short, short[])}.
	 */
	public void requestPage(int page) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_REQUEST_PAGE, this);
		bb.putShort((short)page);

		sendRequest(bb.array());
	}

	/**
	 * Returns 16 bytes of data from an internal buffer. To fill the buffer
	 * with specific pages you have to call {@link BrickletNFCRFID#requestPage(int)} beforehand.
	 */
	public short[] getPage() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_PAGE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short[] data = new short[16];
		for(int i = 0; i < 16; i++) {
			data[i] = IPConnection.unsignedByte(bb.get());
		}


		return data;
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
	 * Adds a StateChanged listener.
	 */
	public void addStateChangedListener(StateChangedListener listener) {
		listenerStateChanged.add(listener);
	}

	/**
	 * Removes a StateChanged listener.
	 */
	public void removeStateChangedListener(StateChangedListener listener) {
		listenerStateChanged.remove(listener);
	}
}
