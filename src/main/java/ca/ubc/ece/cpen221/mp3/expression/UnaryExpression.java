package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.AbsoluteValueOperator;
import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

/**
 * Abstraction function: an expression containing an expression and an unary operator
 * Rep Invariant: should have an expression and an operator to apply to it
 */

public class UnaryExpression implements Expression {
    Expression e1;
    UnaryOperator o;

    /**
     * @param e1 expression
     * @param o unary operator to apply to e1
     * @return Unary Expression
     */
    public UnaryExpression(Expression e1,  UnaryOperator o){
        this.e1=e1;
        this.o=o;
    }

    /**
     * Evaluates an arithmetic expression.
     *
     * @return the value to which this expression evaluates
     */
    @Override
    public double eval() {
        return o.apply(e1.eval());
    }

    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */
    @Override
    public String toString(){
        if(o instanceof AbsoluteValueOperator){
            return "|" + e1.toString()+ "|";
        }
        else{
            return "-"+ e1.toString();
        }
    }
}
