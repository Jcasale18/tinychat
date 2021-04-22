package tinychat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatClient {
    
    public static void main(String[] args) throws IOException{


        Scanner userinput = new Scanner(System.in);
        Socket socket = new Socket("localhost", 12410);
        Scanner serverResponse = new Scanner(socket.getInputStream());
        PrintWriter messager = new PrintWriter(socket.getOutputStream());
        System.out.print("Enter your name to connect to tinychat: ");
        String outgoing = userinput.nextLine();
        messager.println("Name: " + outgoing);
        messager.flush();
        String response = serverResponse.nextLine();
        System.out.println(response);


        
        Thread listener = new Thread(() ->{
            while(true){
                String asyncResponse = serverResponse.nextLine();
                System.out.println(asyncResponse);
                if(asyncResponse.equals("Closing"))
                    break;
            }
        });
        listener.start();

        while(true){
            if(response.equals("Closing")){
                break;
            }
            outgoing = userinput.nextLine();
            messager.println(outgoing);
            messager.flush();
            if(outgoing.equals("Quit")){
                break;
            }

        }
        userinput.close();
        socket.close();
        messager.close();
        serverResponse.close();
    }
}
