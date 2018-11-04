package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

public class UnaryExpression implements Expression {
    Expression e1;

    UnaryOperator o;

    public UnaryExpression(Expression e1,  UnaryOperator o){
        this.e1=e1;
        this.o=o;
    }

    @Override
    public double eval() {
        return o.apply(e1.eval());
    }

    @Override
    public String toString(){
        return e1.toString()+ o.toString();
    }
}
