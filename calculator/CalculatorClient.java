//Joseph Casale
package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Calculator Client connects to Calculator Server being run by localhost on port 12400.
 */
public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        // sestup client
        DatagramSocket client = new DatagramSocket();

        //get operation from user (first run will be op operator op, others will be operator op form)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter math operation (or nothing to exit): ");
        String op = "";
        while(true){
            try {
                if (Double.isNaN (Double.parseDouble(op))) {
                    throw new NumberFormatException ();
                }
            } catch (NumberFormatException nfe) { 
                // Didn't get a numberic response, throw away the result
                if(!op.equals("")){//If server sends something like "error bad request", we want to get rid of that first and print a new line, but we don't want to print that new line at the very start when op is "".
                    op = "";
                    System.out.println ();
                }
            }



            op = op + scanner.nextLine().strip();//adds the inputted operation to the op string so that it works for the first run starting at empty string, and also works for second runs with the incoming response
            if(op.equals("")){
                break;
            }
            InetAddress target = InetAddress.getByName("localhost");
            DatagramPacket outgoing = new DatagramPacket(op.getBytes(), op.length(), target, 12400);

            //sends operation always of form (operand operator operand) to server
            client.send(outgoing);
            byte[] buffer = new byte[1024];
            //recieves a result
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            client.receive(incoming);
            //turns result to string
            String result = new String(incoming.getData(), 0, incoming.getLength());
            System.out.print(result);
            //make a new string for the result -- makes more readable for me. A single char array shouldn't hurt too much.
            op = new String(incoming.getData(), 0, incoming.getLength());

        }
        scanner.close();
        client.close();

    }
}
