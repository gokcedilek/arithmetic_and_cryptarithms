package ca.ubc.ece.cpen221.mp3.operator;

/**
 * Abstraction function: returns the absolute value of a number.
 * Rep Invariant: The result should be positive or zero. The input should be of type double.
 *
 */

public class AbsoluteValueOperator implements UnaryOperator {
    /**
     * Applies the Operator on the number given.
     *
     * @param arg a number to apply the operator on
     * @return the absolute value of the number outputted by the operation given input arg
     */
    @Override
    public double apply(double arg) {
        return Math.abs(arg);
    }

    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */
    @Override
    public String toString() {
        return "| |";
    }
}
