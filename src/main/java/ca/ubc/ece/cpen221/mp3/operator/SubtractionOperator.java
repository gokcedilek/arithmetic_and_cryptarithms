package ca.ubc.ece.cpen221.mp3.operator;

/**
 * Abstraction function: returns the result of a number subtracted from another number.
 * Rep Invariant:The inputs and result should be of type double.
 *
 */

public class SubtractionOperator implements BinaryOperator {
    /**
     * Applies the Operator on the numbers given.
     *
     * @param arg1 and arg2 two numbers to apply the operator on
     * @return the result of subtracting the two numbers
     */

    @Override
    public double apply(double arg1, double arg2) {
        return arg1-arg2;
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
