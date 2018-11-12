package ca.ubc.ece.cpen221.mp3.operator;

/**
 * Abstraction function: returns the result of dividing the values of two numbers.
 * Rep Invariant:The inputs and result should be of type double.
 *
 */

public class DivisionOperator implements BinaryOperator {
    /**
     * Applies the Operator on the numbers given.
     *
     * @param arg1 and arg2 two numbers to apply the operator on
     * @return the result of dividing the two numbers. Throws ArithmeticException if the number
     * it is divided by is 0
     */
    @Override
    public double apply(double arg1, double arg2) {
        if(arg2!=0){
            return arg1/arg2;
        }
        else{
            throw new ArithmeticException(" Division by 0 is not allowed! ");
        }
    }
    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */
    @Override
    public String toString() {
        return "/";
    }
}
