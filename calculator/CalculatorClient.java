package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter math operation (or nothing to exit): ");

        while(true){
            String op = scanner.nextLine().strip();
            if(op.equals("")){
                break;
            }
            InetAddress target = InetAddress.getByName("tony-audi.com");
            DatagramPacket outgoing = new DatagramPacket(op.getBytes(), op.length(), target, 12400);
            client.send(outgoing);
            byte[] buffer = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            client.receive(incoming);
            String result = new String(incoming.getData(), 0, incoming.getLength());
            System.out.print(result);
        }
        scanner.close();
        client.close();

    }
}
