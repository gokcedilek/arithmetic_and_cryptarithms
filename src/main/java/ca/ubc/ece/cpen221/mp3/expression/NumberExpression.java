package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;

public class NumberExpression implements Expression {

    private double value;

    public NumberExpression(double val) {
        this.value=val;
    }

    @Override
    public double eval() {
        return value;
    }

    @Override
    public String toString() {
        return null;
    }
}
