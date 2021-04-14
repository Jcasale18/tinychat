package echo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Listener {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12347);
        while(true){
            Socket client = server.accept();
            System.out.println("Accepted client from " + client.getInetAddress());
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            Scanner ln = new Scanner(client.getInputStream());
            if(ln.hasNextLine()){
                String s = ln.nextLine();
                System.out.println(s);
            }
            pw.println("Sent from server");
            ln.close();
            pw.close();
        }
    }
}
