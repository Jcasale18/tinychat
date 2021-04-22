package tinychat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatServer{

    

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12410);
        String request =  "";
        PrintWriter out = null;
        Scanner in = null;
        Socket client = server.accept();
        in = new Scanner(client.getInputStream());
        out = new PrintWriter(client.getOutputStream());
        try{
            while(!request.equals("Quit")){
                request = in.nextLine();
                String[] tokens = request.split(" ");
                if(tokens[0].equals("Name:")){
                    out.println("Connected");
                    out.flush();
                }
                System.out.println(request);
            }
            System.out.println("closing");
            out.println("Closing");
            out.flush();
            server.close();
            in.close();
            out.close();
        }catch(IOException e){}
    }

}