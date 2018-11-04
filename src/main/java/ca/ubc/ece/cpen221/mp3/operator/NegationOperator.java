package ca.ubc.ece.cpen221.mp3.operator;

public class NegationOperator implements UnaryOperator {
    @Override
    public double apply(double arg) {
        return 0.0-arg;
    }

    @Override
    public String toString() {
        return "!";
    }
}
