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
 * Measures distance up to 40m with laser light
 */
public class BrickletLaserRangeFinder extends Device {
	public final static int DEVICE_IDENTIFIER = 255;
	public final static String DEVICE_DISPLAY_NAME = "Laser Range Finder Bricklet";

	public final static byte FUNCTION_GET_DISTANCE = (byte)1;
	public final static byte FUNCTION_GET_VELOCITY = (byte)2;
	public final static byte FUNCTION_SET_DISTANCE_CALLBACK_PERIOD = (byte)3;
	public final static byte FUNCTION_GET_DISTANCE_CALLBACK_PERIOD = (byte)4;
	public final static byte FUNCTION_SET_VELOCITY_CALLBACK_PERIOD = (byte)5;
	public final static byte FUNCTION_GET_VELOCITY_CALLBACK_PERIOD = (byte)6;
	public final static byte FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD = (byte)7;
	public final static byte FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD = (byte)8;
	public final static byte FUNCTION_SET_VELOCITY_CALLBACK_THRESHOLD = (byte)9;
	public final static byte FUNCTION_GET_VELOCITY_CALLBACK_THRESHOLD = (byte)10;
	public final static byte FUNCTION_SET_DEBOUNCE_PERIOD = (byte)11;
	public final static byte FUNCTION_GET_DEBOUNCE_PERIOD = (byte)12;
	public final static byte FUNCTION_SET_MOVING_AVERAGE = (byte)13;
	public final static byte FUNCTION_GET_MOVING_AVERAGE = (byte)14;
	public final static byte FUNCTION_SET_MODE = (byte)15;
	public final static byte FUNCTION_GET_MODE = (byte)16;
	public final static byte FUNCTION_ENABLE_LASER = (byte)17;
	public final static byte FUNCTION_DISABLE_LASER = (byte)18;
	public final static byte FUNCTION_IS_LASER_ENABLED = (byte)19;
	public final static byte CALLBACK_DISTANCE = (byte)20;
	public final static byte CALLBACK_VELOCITY = (byte)21;
	public final static byte CALLBACK_DISTANCE_REACHED = (byte)22;
	public final static byte CALLBACK_VELOCITY_REACHED = (byte)23;
	public final static byte FUNCTION_GET_IDENTITY = (byte)255;

	public final static char THRESHOLD_OPTION_OFF = 'x';
	public final static char THRESHOLD_OPTION_OUTSIDE = 'o';
	public final static char THRESHOLD_OPTION_INSIDE = 'i';
	public final static char THRESHOLD_OPTION_SMALLER = '<';
	public final static char THRESHOLD_OPTION_GREATER = '>';
	public final static short MODE_DISTANCE = (short)0;
	public final static short MODE_VELOCITY_MAX_13MS = (short)1;
	public final static short MODE_VELOCITY_MAX_32MS = (short)2;
	public final static short MODE_VELOCITY_MAX_64MS = (short)3;
	public final static short MODE_VELOCITY_MAX_127MS = (short)4;

	private List<DistanceListener> listenerDistance = new CopyOnWriteArrayList<DistanceListener>();
	private List<VelocityListener> listenerVelocity = new CopyOnWriteArrayList<VelocityListener>();
	private List<DistanceReachedListener> listenerDistanceReached = new CopyOnWriteArrayList<DistanceReachedListener>();
	private List<VelocityReachedListener> listenerVelocityReached = new CopyOnWriteArrayList<VelocityReachedListener>();

	public class DistanceCallbackThreshold {
		public char option;
		public int min;
		public int max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class VelocityCallbackThreshold {
		public char option;
		public short min;
		public short max;

		public String toString() {
			return "[" + "option = " + option + ", " + "min = " + min + ", " + "max = " + max + "]";
		}
	}

	public class MovingAverage {
		public short distanceAverageLength;
		public short velocityAverageLength;

		public String toString() {
			return "[" + "distanceAverageLength = " + distanceAverageLength + ", " + "velocityAverageLength = " + velocityAverageLength + "]";
		}
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletLaserRangeFinder#setDistanceCallbackPeriod(long)}. The parameter is the distance value
	 * of the sensor.
	 * 
	 * {@link BrickletLaserRangeFinder.DistanceListener} is only triggered if the distance value has changed since the
	 * last triggering.
	 */
	public interface DistanceListener extends DeviceListener {
		public void distance(int distance);
	}

	/**
	 * This listener is triggered periodically with the period that is set by
	 * {@link BrickletLaserRangeFinder#setVelocityCallbackPeriod(long)}. The parameter is the velocity value
	 * of the sensor.
	 * 
	 * {@link BrickletLaserRangeFinder.VelocityListener} is only triggered if the velocity has changed since the
	 * last triggering.
	 */
	public interface VelocityListener extends DeviceListener {
		public void velocity(short velocity);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletLaserRangeFinder#setDistanceCallbackThreshold(char, int, int)} is reached.
	 * The parameter is the distance value of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletLaserRangeFinder#setDebouncePeriod(long)}.
	 */
	public interface DistanceReachedListener extends DeviceListener {
		public void distanceReached(int distance);
	}

	/**
	 * This listener is triggered when the threshold as set by
	 * {@link BrickletLaserRangeFinder#setVelocityCallbackThreshold(char, short, short)} is reached.
	 * The parameter is the velocity value of the sensor.
	 * 
	 * If the threshold keeps being reached, the listener is triggered periodically
	 * with the period as set by {@link BrickletLaserRangeFinder#setDebouncePeriod(long)}.
	 */
	public interface VelocityReachedListener extends DeviceListener {
		public void velocityReached(short velocity);
	}

	/**
	 * Creates an object with the unique device ID \c uid. and adds it to
	 * the IP Connection \c ipcon.
	 */
	public BrickletLaserRangeFinder(String uid, IPConnection ipcon) {
		super(uid, ipcon);

		apiVersion[0] = 2;
		apiVersion[1] = 0;
		apiVersion[2] = 0;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VELOCITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DISTANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VELOCITY_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VELOCITY_CALLBACK_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_VELOCITY_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_VELOCITY_CALLBACK_THRESHOLD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_DEBOUNCE_PERIOD)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MOVING_AVERAGE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_SET_MODE)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_MODE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_ENABLE_LASER)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_DISABLE_LASER)] = RESPONSE_EXPECTED_FLAG_FALSE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_IS_LASER_ENABLED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(FUNCTION_GET_IDENTITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_TRUE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DISTANCE)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VELOCITY)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_DISTANCE_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;
		responseExpected[IPConnection.unsignedByte(CALLBACK_VELOCITY_REACHED)] = RESPONSE_EXPECTED_FLAG_ALWAYS_FALSE;

		callbacks[CALLBACK_DISTANCE] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int distance = IPConnection.unsignedShort(bb.getShort());

				for(DistanceListener listener: listenerDistance) {
					listener.distance(distance);
				}
			}
		};

		callbacks[CALLBACK_VELOCITY] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short velocity = (bb.getShort());

				for(VelocityListener listener: listenerVelocity) {
					listener.velocity(velocity);
				}
			}
		};

		callbacks[CALLBACK_DISTANCE_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				int distance = IPConnection.unsignedShort(bb.getShort());

				for(DistanceReachedListener listener: listenerDistanceReached) {
					listener.distanceReached(distance);
				}
			}
		};

		callbacks[CALLBACK_VELOCITY_REACHED] = new IPConnection.DeviceCallbackListener() {
			public void callback(byte[] data) {
				ByteBuffer bb = ByteBuffer.wrap(data, 8, data.length - 8);
				bb.order(ByteOrder.LITTLE_ENDIAN);

				short velocity = (bb.getShort());

				for(VelocityReachedListener listener: listenerVelocityReached) {
					listener.velocityReached(velocity);
				}
			}
		};
	}

	/**
	 * Returns the measured distance. The value has a range of 0 to 4000
	 * and is given in cm.
	 * 
	 * The Laser Range Finder Bricklet knows different modes. Distances
	 * are only measured in the distance measurement mode,
	 * see {@link BrickletLaserRangeFinder#setMode(short)}. Also the laser has to be enabled, see
	 * {@link BrickletLaserRangeFinder#enableLaser()}.
	 * 
	 * If you want to get the distance periodically, it is recommended to
	 * use the listener {@link BrickletLaserRangeFinder.DistanceListener} and set the period with 
	 * {@link BrickletLaserRangeFinder#setDistanceCallbackPeriod(long)}.
	 */
	public int getDistance() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		int distance = IPConnection.unsignedShort(bb.getShort());

		return distance;
	}

	/**
	 * Returns the measured velocity. The value has a range of 0 to 12700
	 * and is given in 1/100 m/s.
	 * 
	 * The Laser Range Finder Bricklet knows different modes. Velocity 
	 * is only measured in the velocity measurement modes, 
	 * see {@link BrickletLaserRangeFinder#setMode(short)}. Also the laser has to be enabled, see
	 * {@link BrickletLaserRangeFinder#enableLaser()}.
	 * 
	 * If you want to get the velocity periodically, it is recommended to
	 * use the listener {@link BrickletLaserRangeFinder.VelocityListener} and set the period with 
	 * {@link BrickletLaserRangeFinder#setVelocityCallbackPeriod(long)}.
	 */
	public short getVelocity() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VELOCITY, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short velocity = (bb.getShort());

		return velocity;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletLaserRangeFinder.DistanceListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletLaserRangeFinder.DistanceListener} is only triggered if the distance value has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setDistanceCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_DISTANCE_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletLaserRangeFinder#setDistanceCallbackPeriod(long)}.
	 */
	public long getDistanceCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the period in ms with which the {@link BrickletLaserRangeFinder.VelocityListener} listener is triggered
	 * periodically. A value of 0 turns the listener off.
	 * 
	 * {@link BrickletLaserRangeFinder.VelocityListener} is only triggered if the velocity value has changed since the
	 * last triggering.
	 * 
	 * The default value is 0.
	 */
	public void setVelocityCallbackPeriod(long period) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)12, FUNCTION_SET_VELOCITY_CALLBACK_PERIOD, this);
		bb.putInt((int)period);

		sendRequest(bb.array());
	}

	/**
	 * Returns the period as set by {@link BrickletLaserRangeFinder#setVelocityCallbackPeriod(long)}.
	 */
	public long getVelocityCallbackPeriod() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VELOCITY_CALLBACK_PERIOD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		long period = IPConnection.unsignedInt(bb.getInt());

		return period;
	}

	/**
	 * Sets the thresholds for the {@link BrickletLaserRangeFinder.DistanceReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the distance value is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the distance value is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the distance value is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the distance value is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setDistanceCallbackThreshold(char option, int min, int max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_DISTANCE_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort((short)min);
		bb.putShort((short)max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletLaserRangeFinder#setDistanceCallbackThreshold(char, int, int)}.
	 */
	public DistanceCallbackThreshold getDistanceCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_DISTANCE_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		DistanceCallbackThreshold obj = new DistanceCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = IPConnection.unsignedShort(bb.getShort());
		obj.max = IPConnection.unsignedShort(bb.getShort());

		return obj;
	}

	/**
	 * Sets the thresholds for the {@link BrickletLaserRangeFinder.VelocityReachedListener} listener. 
	 * 
	 * The following options are possible:
	 * 
	 * \verbatim
	 *  "Option", "Description"
	 * 
	 *  "'x'",    "Listener is turned off"
	 *  "'o'",    "Listener is triggered when the velocity is *outside* the min and max values"
	 *  "'i'",    "Listener is triggered when the velocity is *inside* the min and max values"
	 *  "'&lt;'",    "Listener is triggered when the velocity is smaller than the min value (max is ignored)"
	 *  "'&gt;'",    "Listener is triggered when the velocity is greater than the min value (max is ignored)"
	 * \endverbatim
	 * 
	 * The default value is ('x', 0, 0).
	 */
	public void setVelocityCallbackThreshold(char option, short min, short max) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)13, FUNCTION_SET_VELOCITY_CALLBACK_THRESHOLD, this);
		bb.put((byte)option);
		bb.putShort(min);
		bb.putShort(max);

		sendRequest(bb.array());
	}

	/**
	 * Returns the threshold as set by {@link BrickletLaserRangeFinder#setVelocityCallbackThreshold(char, short, short)}.
	 */
	public VelocityCallbackThreshold getVelocityCallbackThreshold() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_VELOCITY_CALLBACK_THRESHOLD, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		VelocityCallbackThreshold obj = new VelocityCallbackThreshold();
		obj.option = (char)(bb.get());
		obj.min = (bb.getShort());
		obj.max = (bb.getShort());

		return obj;
	}

	/**
	 * Sets the period in ms with which the threshold listeners
	 * 
	 * * {@link BrickletLaserRangeFinder.DistanceReachedListener},
	 * * {@link BrickletLaserRangeFinder.VelocityReachedListener},
	 * 
	 * are triggered, if the thresholds
	 * 
	 * * {@link BrickletLaserRangeFinder#setDistanceCallbackThreshold(char, int, int)},
	 * * {@link BrickletLaserRangeFinder#setVelocityCallbackThreshold(char, short, short)},
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
	 * Returns the debounce period as set by {@link BrickletLaserRangeFinder#setDebouncePeriod(long)}.
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
	 * for the distance and velocity.
	 * 
	 * Setting the length to 0 will turn the averaging completely off. With less
	 * averaging, there is more noise on the data.
	 * 
	 * The range for the averaging is 0-30.
	 * 
	 * The default value is 10.
	 */
	public void setMovingAverage(short distanceAverageLength, short velocityAverageLength) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)10, FUNCTION_SET_MOVING_AVERAGE, this);
		bb.put((byte)distanceAverageLength);
		bb.put((byte)velocityAverageLength);

		sendRequest(bb.array());
	}

	/**
	 * Returns the length moving average as set by {@link BrickletLaserRangeFinder#setMovingAverage(short, short)}.
	 */
	public MovingAverage getMovingAverage() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_MOVING_AVERAGE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		MovingAverage obj = new MovingAverage();
		obj.distanceAverageLength = IPConnection.unsignedByte(bb.get());
		obj.velocityAverageLength = IPConnection.unsignedByte(bb.get());

		return obj;
	}

	/**
	 * The LIDAR has five different modes. One mode is for distance
	 * measurements and four modes are for velocity measurements with
	 * different ranges.
	 * 
	 * The following modes are available:
	 * 
	 * * 0: Distance is measured with resolution 1.0 cm and range 0-400 cm
	 * * 1: Velocity is measured with resolution 0.1 m/s and range is 0-12.7 m/s
	 * * 2: Velocity is measured with resolution 0.25 m/s and range is 0-31.75 m/s
	 * * 3: Velocity is measured with resolution 0.5 m/s and range is 0-63.5 m/s
	 * * 4: Velocity is measured with resolution 1.0 m/s and range is 0-127 m/s
	 * 
	 * The default mode is 0 (distance is measured).
	 */
	public void setMode(short mode) throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)9, FUNCTION_SET_MODE, this);
		bb.put((byte)mode);

		sendRequest(bb.array());
	}

	/**
	 * Returns the mode as set by {@link BrickletLaserRangeFinder#setMode(short)}.
	 */
	public short getMode() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_GET_MODE, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		short mode = IPConnection.unsignedByte(bb.get());

		return mode;
	}

	/**
	 * Activates the laser of the LIDAR.
	 * 
	 * We recommend that you wait 250ms after enabling the laser before
	 * the first call of {@link BrickletLaserRangeFinder#getDistance()} to ensure stable measurements.
	 */
	public void enableLaser() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_ENABLE_LASER, this);

		sendRequest(bb.array());
	}

	/**
	 * Deactivates the laser of the LIDAR.
	 */
	public void disableLaser() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_DISABLE_LASER, this);

		sendRequest(bb.array());
	}

	/**
	 * Returns *true* if the laser is enabled, *false* otherwise.
	 */
	public boolean isLaserEnabled() throws TimeoutException, NotConnectedException {
		ByteBuffer bb = ipcon.createRequestPacket((byte)8, FUNCTION_IS_LASER_ENABLED, this);

		byte[] response = sendRequest(bb.array());

		bb = ByteBuffer.wrap(response, 8, response.length - 8);
		bb.order(ByteOrder.LITTLE_ENDIAN);

		boolean laserEnabled = (bb.get()) != 0;

		return laserEnabled;
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
	 * Adds a Distance listener.
	 */
	public void addDistanceListener(DistanceListener listener) {
		listenerDistance.add(listener);
	}

	/**
	 * Removes a Distance listener.
	 */
	public void removeDistanceListener(DistanceListener listener) {
		listenerDistance.remove(listener);
	}

	/**
	 * Adds a Velocity listener.
	 */
	public void addVelocityListener(VelocityListener listener) {
		listenerVelocity.add(listener);
	}

	/**
	 * Removes a Velocity listener.
	 */
	public void removeVelocityListener(VelocityListener listener) {
		listenerVelocity.remove(listener);
	}

	/**
	 * Adds a DistanceReached listener.
	 */
	public void addDistanceReachedListener(DistanceReachedListener listener) {
		listenerDistanceReached.add(listener);
	}

	/**
	 * Removes a DistanceReached listener.
	 */
	public void removeDistanceReachedListener(DistanceReachedListener listener) {
		listenerDistanceReached.remove(listener);
	}

	/**
	 * Adds a VelocityReached listener.
	 */
	public void addVelocityReachedListener(VelocityReachedListener listener) {
		listenerVelocityReached.add(listener);
	}

	/**
	 * Removes a VelocityReached listener.
	 */
	public void removeVelocityReachedListener(VelocityReachedListener listener) {
		listenerVelocityReached.remove(listener);
	}
}
