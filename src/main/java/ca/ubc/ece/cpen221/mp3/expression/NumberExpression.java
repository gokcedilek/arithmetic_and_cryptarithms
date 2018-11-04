package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

public class NumberExpression implements Expression {
    double val;


    public NumberExpression(double val){
        this.val=val;
    }

    @Override
    public double eval() {
        return val;
    }

    @Override
    public String toString(){
        return Double.toString(val);
    }
}
