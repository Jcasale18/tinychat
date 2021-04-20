package calculator;

/**
 * Implements the {@link BinaryOperation} interface to perform addition.
 */
public class Addition implements BinaryOperation {
    /**
     * The addition operator.
     */
    public static final String OPERATOR = "+";

    /**
     * Returns the result of adding the two operands.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of adding the two operands together.
     */
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 + operand2;
    }

    /**
     * Returns true if the specified operator is the addition operator, and
     * false otherwise.
     *
     * @param operator The operator being checked.
     * @return True if the operator is the addition operator. Otherwise false.
     */
    @Override
    public boolean matches(String operator) {
        return operator.equals(OPERATOR);
    }
}
