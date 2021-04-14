package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class EchoClient {
    public static void main(String[] args) throws IOException{
        int port = 12347;
        System.out.println("[+] Attempting to make connected to prt " + port);
        Socket client = new Socket("localhost", port);
        System.out.println("[+] getting output stream...");
        PrintWriter printer = new PrintWriter(client.getOutputStream());
        Scanner scan = new Scanner(client.getInputStream());
        
        String message = "This is my message";
        printer.println(message);
        printer.flush();
        System.out.println("message sent");
        System.out.println(scan.nextLine());
        client.close();

    }
}
