/**
 * A class used to hold all the smart bulb commands
 * 
 * @author John Armstrong
 *
 */
public class Command {
	public static final byte[] off = {0x41, 0x00, 0x55};
	public static final byte[] on = {0x42, 0x00, 0x55};
}
