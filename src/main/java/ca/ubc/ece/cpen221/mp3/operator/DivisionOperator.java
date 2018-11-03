package ca.ubc.ece.cpen221.mp3.operator;

public class DivisionOperator implements BinaryOperator {
    @Override
    public double apply(double arg1, double arg2) {
        if(arg2!=0){
            return arg1/arg2;
        }
        else{
            throw new ArithmeticException(" Division by 0 is not allowed! ");
        }
    }

    @Override
    public String toString() {
        return "/";
    }
}
