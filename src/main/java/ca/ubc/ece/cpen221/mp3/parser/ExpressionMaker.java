package ca.ubc.ece.cpen221.mp3.parser;

import ca.ubc.ece.cpen221.mp3.expression.Expression;
import ca.ubc.ece.cpen221.mp3.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp3.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp3.operator.UnaryOperator;

/**
 * ExpressionMaker - a helper class for creating Expressions given various
 * Operators and Expressions
 * 
 */
public class ExpressionMaker {

	/**
	 * Creates a binary operation expression.
	 *
	 * @param operator
	 *            the operator
	 * @param operand1
	 *            the opperand1
	 * @param operand2
	 *            the opperand2
	 * @return the expression
	 */
	public Expression createBinaryOperationExpression(BinaryOperator operator, Expression operand1,
			Expression operand2) {
//		double val1= operand1.eval();
//		double val2= operand2.eval();
//		double value= operator.apply(val1,val2);
        String name= operand1.toString()+operator.toString()+operand2.toString();
		Expression e= new VariableExpression(name);
//		((VariableExpression) e).store(value);
		return e;

	}

	/**
	 * Creates a unary operation expression.
	 *
	 * @param operator
	 *            the operator
	 * @param operand
	 *            the operand
	 * @return the expression
	 */
	public Expression createUnaryOperationExpression(UnaryOperator operator, Expression operand) {
		String name= operator.toString()+operand.toString();
		Expression e= new VariableExpression(name);
		return e;
	}

	/**
	 * Creates a number expression.
	 *
	 * @param value
	 *            the value
	 * @return the expression
	 */
	public Expression createNumberExpression(double value) {
		String name= Double.toString(value);
		Expression e= new VariableExpression(name);
		return e;
	}

}
