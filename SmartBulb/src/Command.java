/**
 * A class used to hold all the smart bulb commands
 * 
 * @author John Armstrong
 *
 */
public class Command {
	public static final byte[] off = {0x41, 0x00, 0x55};
	public static final byte[] on = {0x42, 0x00, 0x55};
	public static final byte[] discoMode = {0x4D, 0x00, 0x55};
	public static final byte[] warmWhite = {(byte) 0xC2, 0x00, 0x55};
	
	/**
	 * Change brightness level
	 * @param brightness: Choose a level from 2 - 27
	 * @return byte command
	 */
	public static byte[] setBrightness(int brightness) {
		String v = "0x" + Integer.toHexString(brightness);
		byte value = Byte.decode(v);
		byte[] command = {0x4E, value, 0x55};
		return command;
	}
}
