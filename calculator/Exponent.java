package calculator;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements the {@link BinaryOperation} interface to raise a base to an
 * exponent.
 */
public class Exponent implements BinaryOperation {
    /**
     * The supported exponent operators.
     */
    private static final Set<String> OPERATORS = new HashSet<>();
    static {
        OPERATORS.add("^");
        OPERATORS.add("**");
    }

    /**
     * Returns the result of raising the first operand to the power of the
     * second.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return The result of raising the first operand to the power of the
     * second.
     */
    @Override
    public float execute(float operand1, float operand2) {
        return (float)Math.pow(operand1, operand2);
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
        return OPERATORS.contains(operator);
    }
}
