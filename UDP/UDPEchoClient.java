import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException{

        //SEND TO SERVER
        DatagramSocket sock = new DatagramSocket();
        String message = "Server takeover packet";

        InetAddress myself = InetAddress.getLocalHost();
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(),
                                        myself, 54321);  
        System.out.println("Sending to "+ myself);
        sock.send(outgoing);//sent to myself
/////////////////////////////////////////////////////////////
        //recieve from server
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        sock.receive(incoming);
        String received =new String( incoming.getData(), 0, incoming.getLength());

        System.out.println(received);
        sock.close();
                                       
    }    
}
