//Joseph Casale
package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Server takes "operand operation operand" requests, calculates a result, and sends it back.
 */
public class CalculatorServer{

    public static void main(String[] args) throws IOException {
        //make the calculator
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);  
        
        //setup server and listen for an expression
        DatagramSocket server = new DatagramSocket(12400);
        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        server.receive(incoming);
        String expression = new String(incoming.getData(), 0, incoming.getLength());


        //begin loop to maintain calculation until just a space is sent
        while (!expression.equals(" ")) {
            String[] tokens = expression.strip().split(" ");
    
            String result;
                // Check to make sure it is a binary operation
            if (tokens.length < 3) {
                result = "error bad request ";
            } 
            else {
                // Parse the components
                try {
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    // Get the result as a String
                    result = "" + calculator.calculate(tokens[1], operand1, operand2) + " ";
                } catch (Exception e) {
                    // Uh-oh, something bad happened, record it as the result
                    result = "error " + e.getLocalizedMessage() + " ";
                }
            }
    
                    
            /**
             * If the response was a number, use that number as the first value
             * in a new binary operation. If it was anything else, expect
             * a new 3 piece binary operation.
            */

            //creating a copy of the result to send after internally updating result string to work with
            String tosend = String.valueOf(result);

                
            // Let the user know the result.
                
            DatagramPacket packet = new DatagramPacket(tosend.getBytes(), tosend.length(), incoming.getAddress(), incoming.getPort());
            server.send(packet);


            //get new expression for re-iteration and possible exit
            server.receive(incoming);            
            expression = new String(incoming.getData(), 0, incoming.getLength());

        }
        server.close();
    }
    
}
