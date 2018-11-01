package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;

public class BinaryOperatorExpression implements Expression {

    private BinaryOperator op;

    private Expression lhs;
    private Expression rhs;

    public BinaryOperatorExpression(BinaryOperator op, Expression lhs, Expression rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public double eval() {
        return op.apply(lhs.eval(),rhs.eval());
    }

    @Override
    public String toString() {
        return null;
    }
}
