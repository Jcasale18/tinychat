package calculator;

/**
 * Interface for a binary operation that combines two floating point
 * operations and returns a result.
 */
public interface BinaryOperation {
    /**
     * Executes the binary operation.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of applying the binary operation to the operands.
     */
    public float execute(float operand1, float operand2);

    /**
     * Returns true if the specified operator matches this binary operation,
     * and false otherwise.
     *
     * @param operator The operator being checked.
     * @return True if the operator matches the operation, and false otherwise.
     */
    public boolean matches(String operator);
}
