import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * A simple program to control my new smart bulb
 * 
 * @author John Armstrong
 *
 */
public class Main {

	/**
	 * Loop getting user input and responding to that input
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean complete = false;
		Scanner in = new Scanner(System.in);
		
		while(!complete) {
			System.out.println("");
			System.out.println("Hello Commander....");
			System.out.println("Enter in code");
			System.out.println("1: Light on");
			System.out.println("2: Light off");
			System.out.println("3: Warm White");
			System.out.println("4: Disco Mode!");
			System.out.println("5: Set Brightness");
			System.out.println("6: Exit");
			
			int resp = in.nextInt();
			
			switch(resp) {
			case 1:
				sendOrder(Command.on);
				break;
			case 2:
				sendOrder(Command.off);
				break;
			case 3:
				sendOrder(Command.warmWhite);
				break;
			case 4:
				sendOrder(Command.discoMode);
				break;
			case 5:
				System.out.println("\nEnter in a value for brightness (2 - 27)");
				int brightness = in.nextInt();
				if(brightness > 27 || brightness < 2)
					System.out.println("ERROR: You did not enter a value between 2 - 27");
				else
					sendOrder(Command.setBrightness(brightness));
				break;
			case 6:
				complete = true;
				System.out.println("Exiting.....");
				in.close();
				break;
			}
		}   
	}	    

	/**
	 * Send an order to the smart bulb
	 * @param order: A byte array of length 3 that represents the command for the smart bulb
	 */
	private static void sendOrder(byte[] order) {
		try{
			InetAddress serverAddr = InetAddress.getByName("255.255.255.255");
		    DatagramSocket socket = new DatagramSocket();
		    DatagramPacket packet = new DatagramPacket(order, order.length, serverAddr, 8899);
		    socket.send(packet);
		    socket.close();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
