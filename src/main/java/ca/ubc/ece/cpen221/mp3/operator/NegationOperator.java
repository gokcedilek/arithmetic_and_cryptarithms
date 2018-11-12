package ca.ubc.ece.cpen221.mp3.operator;

/**
 * Abstraction function: returns the absolute value of a number.
 * Rep Invariant:The input should be of type double. Result would be of apposite sign of input.
 *
 */

public class NegationOperator implements UnaryOperator {

    /**
     * Applies the Operator on the number given.
     *
     * @param arg a number to apply the operator on
     * @return the opposite sign of input arg
     */

    @Override
    public double apply(double arg) {
        return 0.0-arg;
    }

    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */

    @Override
    public String toString() {
        return "-";
    }
}
