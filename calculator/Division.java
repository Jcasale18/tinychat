package calculator;

/**
 * Implements the {@link BinaryOperation} interface to perform division.
 */
public class Division implements BinaryOperation {
    /**
     * The division operator.
     */
    public static final String OPERATOR = "/";

    /**
     * Returns the result of dividing the first operand by the second.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of dividing the first operand by the second.
     */
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 / operand2;
    }

    /**
     * Returns true if the specified operator is the division operator, and
     * false otherwise.
     *
     * @param operator The operator being checked.
     * @return True if the operator is the division operator. Otherwise
     * false.
     */
    @Override
    public boolean matches(String operator) {
        return operator.equals(OPERATOR);
    }
}
