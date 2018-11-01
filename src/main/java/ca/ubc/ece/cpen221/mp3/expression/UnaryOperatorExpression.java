package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

public class UnaryOperatorExpression implements Expression {

    private UnaryOperator op;

    private Expression exp;

    public UnaryOperatorExpression(UnaryOperator op, Expression exp) {
        this.op = op;
        this.exp=exp;
    }

    @Override
    public double eval() {
      return op.apply(exp.eval());
    }

    @Override
    public String toString() {
        return null;
    }
}
