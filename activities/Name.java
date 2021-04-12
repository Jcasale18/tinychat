package activities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {
    
    public static void main(String[] args) throws IOException{
        Socket client = new Socket("129.21.109.96", 12345);
        OutputStream output = client.getOutputStream();
        PrintWriter printer = new PrintWriter(output);
        printer.println("Joseph Casale");
        client.close();
        output.flush();
    }
}

