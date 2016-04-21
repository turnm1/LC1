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
 * Controls AC and DC Solid State Relays
 */
public class BrickletSolidStateRelay extends Device {
	public final static int DEVICE_IDENTIFIER = 244;
	public final static String DEVICE_DISPLAY_NAME = "Solid State Relay Bricklet";

	public final static byte FUNCTION_SET_STATE = (byte)1;
	public final static byte FUNCTION_GET_STATE = (byte)2;
	public final static byte FUNCTION_SET_MONOFLOP = (byte)3;
	public final static byte FUNCTION_GET_MONOFLOP = (byte)4;
	public final static byte CALLBACK_MONOFLOP_DONE = (byte)5;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;


	private List<MonoflopDoneListener> listenerMonoflopDone = new CopyOnWriteArrayList<MonoflopDoneListener>();

	public class Monoflop {
		public boolean state;
		public long time;
		public long timeRemaining;

		public String toString() {
			return "[" + "state = " + state + ", " + "time = " + time + ", " + "timeRemaining = " + timeRemaining + "]";
		}
	}

	/**
	 * This listener is triggered whenever the monoflop timer reaches 0. 
	 * The parameter is the current state of the relay 
	 * (the state after the monoflop).
	 */
	public interface MonoflopDoneListener extends DeviceListener {
		public void monoflopDone(boolean state);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletSolidStateRelay(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_STATE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_STATE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MONOFLOP)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MONOFLOP)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_MONOFLOP_DONE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_MONOFLOP_DONE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				boolean state = (bb.get()) != 0;

				for(MonoflopDoneListener listener: listenerMonoflopDone) {
					listener.monoflopDone(state);
				}
			}
		};
	}

	/**
	 * Sets the state of the relays *true* means on and *false* means off. 
	 * 
	 * Running monoflop timers will be overwritten if this function is called.
	 * 
	 * The default value is *false*.
	 */
	public void setState(boolean state) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_STATE, this);
		bb.put((byte)(state ? 1 : 0));

		sendRequest(bb.array());
	}

	/**
	 * Returns the state of the relay, *true* means on and *false* means off.
	 */
	public boolean getState() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_STATE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		boolean state = (bb.get()) != 0;

		return state;
	}

	/**
	 * The first parameter  is the desired state of the relay (*true* means on 
	 * and *false* means off). The second parameter indicates the time (in ms) that 
	 * the relay should hold the state.
	 * 
	 * If this function is called with the parameters (true, 1500):
	 * The relay will turn on and in 1.5s it will turn off again.
	 * 
	 * A monoflop can be used as a failsafe mechanism. For example: Lets assume you 
	 * have a RS485 bus and a Solid State Relay Bricklet connected to one of the slave 
	 * stacks. You can now call this function every second, with a time parameter
	 * of two seconds. The relay will be on all the time. If now the RS485 
	 * connection is lost, the relay will turn off in at most two seconds.
	 */
	public void setMonoflop(boolean state, long time) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_MONOFLOP, this);
		bb.put((byte)(state ? 1 : 0));
		bb.putInt((int)time);

		sendRequest(bb.array());
	}

	/**
	 * Returns the current state and the time as set by 
	 * {@link BrickletSolidStateRelay#setMonoflop(boolean, long)} as well as the remaining time until the state flips.
	 * 
	 * If the timer is not running currently, the remaining time will be returned
	 * as 0.
	 */
	public Monoflop getMonoflop() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_MONOFLOP, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		Monoflop obj = new Monoflop();
		obj.state = (bb.get()) != 0;
		obj.time = IPConnection.unsignedInt(bb.getInt());
		obj.timeRemaining = IPConnection.unsignedInt(bb.getInt());

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
	 * Adds a MonoflopDone listener.
	 */
	public void addMonoflopDoneListener(MonoflopDoneListener listener) {
		listenerMonoflopDone.add(listener);
	}

	/**
	 * Removes a MonoflopDone listener.
	 */
	public void removeMonoflopDoneListener(MonoflopDoneListener listener) {
		listenerMonoflopDone.remove(listener);
	}
}
