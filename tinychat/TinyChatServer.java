package tinychat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class TinyChatServer{
    public class ClientHandler extends Duplexer implements Runnable{
        public String name;
        private Socket sock;
        public ClientHandler(Socket socket) throws IOException {
            super(socket);
            name = "";
        }

        @Override
        public void run() {
            String incoming;
            
            incoming = read();
            String[] tokens = incoming.split(" ");
            if(tokens[0].equals("Name:")){
                send("Connected");
                for(String token : tokens){
                    if(token.equals("Name:"))
                        continue;
                    this.name += " ";
                    this.name+=token;

                }
                this.name = name.strip();
                System.out.println(name + " connected");
            }

            while(!incoming.equals("Quit")){
                incoming = read();
                System.out.println(name + ": " + incoming);
            }
            send("Closing");
            try{
                close();
            }catch(IOException e){
                System.out.println("FAILED TO CLOSE CLIENT FOR "+ name);
            }

        }
        @Override
        public boolean equals(Object o){
            if(!(o instanceof ClientHandler)){
                return false;
            }
            ClientHandler other = (ClientHandler)o;
            return(other.name == name && other.sock == sock);
        }

    }
    

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12410);
        ArrayList<Thread> clients = new ArrayList<>();
        TinyChatServer tinyserver = new TinyChatServer();
        try{
            while(true){

                Thread client = new Thread(tinyserver.new ClientHandler(server.accept()));
                client.start();
                clients.add(client);
            }

        }catch(IOException e){}
        
    }

}