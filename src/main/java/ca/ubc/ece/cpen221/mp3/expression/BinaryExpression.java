package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;

public class BinaryExpression implements Expression {

    Expression e11;
    Expression e22;
    BinaryOperator o1;

    public BinaryExpression(Expression e1, Expression e2, BinaryOperator o){
        this.e11 =e1;
        this.e22 =e2;
        this.o1 =o;
    }

    @Override
    public double eval() {
        return o1.apply(e11.eval(), e22.eval());
    }

    @Override
    public String toString(){
        return  e11.toString()+ o1.toString()+ e22.toString();
    }
}
