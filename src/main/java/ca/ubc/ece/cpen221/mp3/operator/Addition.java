package ca.ubc.ece.cpen221.mp3.operator;

public class Addition implements BinaryOperator {
    @Override
    public double apply(double arg1, double arg2) {
        return arg1+arg2;
    }
}
