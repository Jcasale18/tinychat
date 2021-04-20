package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private final List<BinaryOperation> operations;

    public Calculator(List<BinaryOperation> operations) {
        this.operations = operations;
    }

    public float calculate(String operator, float operand1, float operand2) {
        for(BinaryOperation operation : operations) {
            if(operation.matches(operator)) {
                return operation.execute(operand1, operand2);
            }
        }
        throw new IllegalArgumentException("No such operator: " + operator);
    }

    /**
     * Stand alone calculator implementation.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * The supported calculator operations.
         */
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);

        Scanner in = new Scanner (System.in);

        // Get the first operation 
        System.out.print ("Enter math operation (or nothing to exit): ");
        String input = in.nextLine ();
 
        // As long as the user keeps entering operations, keep doing math.
        while (!input.equals(" ")) {
            String[] tokens = input.strip().split(" ");

            String result;
            // Check to make sure it is a binary operation
            if (tokens.length < 3) {
                result = "error bad request";
            } 
            else {
                // Parse the components
                try {
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    // Get the result as a String
                    result = "" + calculator.calculate(tokens[1], operand1, operand2);
                } catch (Exception e) {
                    // Uh-oh, something bad happened, record it as the result
                    result = "error " + e.getLocalizedMessage();
                }
            }

            // Let the user know the result.
            System.out.print (result + " ");

            /**
             * If the response was a number, use that number as the first value
             * in a new binary operation. If it was anything else, expect
             * a new 3 piece binary operation.
             */
            try {
                if (Double.isNaN (Double.parseDouble(result))) {
                    throw new NumberFormatException ();
                }
            } catch (NumberFormatException nfe) { 
                // Didn't get a numberic response, throw away the result
                result = "";
                System.out.println ();
            }
            input = in.nextLine();
            // Add the new operation to the old result to form 
            // a complete operation. I.E. result was 5, user entered
            // * 7, the new input would be "5 * 7".
            input = result + " " + input;
        }

        // All done, clean up any streams.
        in.close ();
    }
}
