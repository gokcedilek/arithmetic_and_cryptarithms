package ca.ubc.ece.cpen221.mp3.operator;

public class AbsoluteValueOperator implements UnaryOperator {
    @Override
    public double apply(double arg) {
        return Math.abs(arg);
    }

    @Override
    public String toString() {
        return "| |";
    }
}
