package activities;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;


public class NetworkTime {
    
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("time.nist.gov", 13);
        System.out.println("connection made");

        InputStream input = client.getInputStream();
        System.out.println("got input stream");
        Scanner sc = new Scanner(input);
        System.out.println("Output from server:");
        while(sc.hasNext()){
            String message = sc.nextLine();
            System.out.print(message + " ");

        }
        sc.close();
        client.close();
    }
}
