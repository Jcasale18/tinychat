package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(54321);
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

        System.out.println("Recieving packet");
        server.receive(incoming);//will wait until incoming packet
        String message =new String(incoming.getData(), 0, incoming.getLength());
        System.out.println(message);

        //send back
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), incoming.getAddress(), incoming.getPort());
        System.out.println("About to send back");
        server.send(outgoing);//this will send. Since UDP, if client isn't receiving, it will still send

        server.close();
    }
}
