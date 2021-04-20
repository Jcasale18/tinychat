package calculator;

/**
 * Implements the {@link BinaryOperation} interface to perform addition.
 */
public class Subtraction implements BinaryOperation {
    /**
     * The subtraction operator.
     */
    public static final String OPERATOR = "-";

    /**
     * Returns the result of subtracting the second operand from the first.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of subtracting the second operand from the first.
     */
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 - operand2;
    }

    /**
     * Returns true if the specified operator is the subtraction operator, and
     * false otherwise.
     *
     * @param operator The operator being checked.
     * @return True if the operator is the subtraction operator. Otherwise
     * false.
     */
    @Override
    public boolean matches(String operator) {
        return operator.equals(OPERATOR);
    }
}
