package guessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket sock;
    private Scanner in;
    private PrintWriter out;
    public Duplexer(Socket socket) throws IOException{
        sock = socket;
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());
    }
}
