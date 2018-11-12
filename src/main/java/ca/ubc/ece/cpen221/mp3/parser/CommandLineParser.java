/**
 * A simple command line parser for arithmetic expressions
 */
package ca.ubc.ece.cpen221.mp3.parser;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ca.ubc.ece.cpen221.mp3.expression.Expression;
import ca.ubc.ece.cpen221.mp3.operator.*;

/**
 * CommandLineParser - a command line calculator.
 * 
 * You will need to add any new Operators you create to the operatorSet or they
 * will not be usable in the command line calculator.
 *
 */
public class CommandLineParser {

	/**
	 * @param args
	 *            program arguments
	 */
	public static void main(String[] args) {

		Set<Operator> operatorSet = new HashSet<Operator>();

		operatorSet.add(new AdditionOperator());
		operatorSet.add(new SubtractionOperator());
		operatorSet.add(new MultiplicationOperator());
		operatorSet.add(new DivisionOperator());
		operatorSet.add(new ExponentiationOperator());
		operatorSet.add(new NegationOperator());
		operatorSet.add(new AbsoluteValueOperator());

		ExpressionParser parser = new ExpressionParser(operatorSet, new ExpressionMaker());

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter an expression");
			String expression = scanner.nextLine();
			try {
				Expression exp = parser.parse(expression);
				System.out.println("Result: " + exp.eval());
			} catch (Exception e) {
				System.out.println("Input format not accepted. Please try again.");
			}
		} while (true);
	}

}
