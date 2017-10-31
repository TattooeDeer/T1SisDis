package Server;

// Imports
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class MulticastSocketServer {
	final static String INET_ADDR = "224.0.0.3";
	final static int PORT = 8888;
	
	public static void main(String[] args) throws InterruptedException, IOException{
		// Obtener derecciona  al que conectarse
		InetAddress addr = InetAddress.getByName(INET_ADDR);
		
		
		// Abrir un datagramsocket, con el que se enviará data
		try(DatagramSocket serverSocket = new DatagramSocket()){
			for(int i = 0; i < 5; i++){
				String msg = "Sent message "+ i;
				
				//Creamos un paquete
				DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);
				serverSocket.send(msgPacket);
				
				System.out.println("Servidor envio un packete con el mensaje: " + msg);
				Thread.sleep(500);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}

	}

}
