package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

/**
 * Abstraction function: an expression containing a numerical value
 * Rep Invariant: should have a double value
 */

public class NumberExpression implements Expression {
    double val;

    /**
     * @param val value of number expression
     * @return Number Expression
     */
    public NumberExpression(double val){
        this.val=val;
    }

    /**
     * Evaluates an arithmetic expression.
     *
     * @return the value to which this expression evaluates
     */
    @Override
    public double eval() {
        return val;
    }

    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */
    @Override
    public String toString(){
        return Double.toString(val);
    }
}
