package calculator;

/**
 * Implements the {@link BinaryOperation} interface to perform multiplication.
 */
public class Multiplication implements BinaryOperation {
    /**
     * The multiplication operator.
     */
    public static final String OPERATOR = "*";

    /**
     * Returns the result of multiplying the operands.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of multiplying the two operands.
     */
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 * operand2;
    }

    /**
     * Returns true if the specified operator is the multiplication operator,
     * and false otherwise.
     *
     * @param operator The operator being checked.
     * @return True if the operator is the multiplication operator. Otherwise
     * false.
     */
    @Override
    public boolean matches(String operator) {
        return operator.equals(OPERATOR);
    }
}
