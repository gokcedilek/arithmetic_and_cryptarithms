package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.Operator;

public class BinaryExpression implements Expression {

    Expression e1;
    Expression e2;
    BinaryOperator o;

    public BinaryExpression(Expression e1, Expression e2, BinaryOperator o){
        this.e1=e1;
        this.e2=e2;
        this.o=o;
    }

    @Override
    public double eval() {
        return o.apply(e1.eval(), e2.eval());
    }

    @Override
    public String toString(){
        return "(" + e1.toString()+ o.toString()+e2.toString()+ ")";
    }
}
