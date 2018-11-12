package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.Operator;

/**
 * Abstraction function: an expression containing two expressions and a binary operator
 * Rep Invariant: should have two expressions and an operator to apply to them
 */

public class BinaryExpression implements Expression {

    Expression e11;
    Expression e22;
    BinaryOperator o1;

    /**
     * @param e1 first expression
     * @param e2 second expression
     * @param o binary operator to apply to e1 and e2
     * @return Binary Expression
     */
    public BinaryExpression(Expression e1, Expression e2, BinaryOperator o){
        this.e11=e1;
        this.e22=e2;
        this.o1=o;
    }

    /**
     * Evaluates an arithmetic expression.
     *
     * @return the value to which this expression evaluates
     */
    @Override
    public double eval() {
        return o1.apply(e11.eval(), e22.eval());
    }

    /**
     * Creates a String representation of an arithmetic expression.
     *
     * @return this expression in string form
     */
    @Override
    public String toString(){
        return  e11.toString()+ o1.toString()+e22.toString();
    }
}