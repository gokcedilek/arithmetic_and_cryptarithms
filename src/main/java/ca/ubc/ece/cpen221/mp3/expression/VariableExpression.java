package ca.ubc.ece.cpen221.mp3.expression;

import java.util.Scanner;
import java.util.Stack;

/**
 * An expression that represents a variable. Its value may be set as well as
 * read. Unlike other expressions in this assignment, variables are mutable.
 * Using a variable within a containing expression makes the expression a
 * function of the current value of the variable.
 *
 * <p>
 * Variables have immutable string names, which are used in their string
 * representations. If an expression contains multiple distinct variables as
 * subexpressions, it's important that they have different names, or the string
 * representation of the containing expression will be misleading.
 */
public class VariableExpression implements Expression {

	private String name;
	private double value;

	/**
	 * Constructs a variable with the specified name, whose initial value is
	 * zero.
	 * 
	 * @param name
	 *            the name of the variable
	 */
	public VariableExpression(String name) {
		this.name=name;
		this.value=0.0;
	}

	@Override
	public double eval() {
		String exp= this.name;
		Scanner scanner = new Scanner(exp);
		double result = 0.0;
		Stack myStack = new Stack();
		while (scanner.hasNext()) {
			String s= scanner.next();
			String s1;
			String s2;
			switch (s) {
//				case "+":
//					s1 = (String) myStack.pop();
//					s2 = (String) myStack.pop();
//					result= s1+s2;
//					newToken= new Token(result);
//					myStack.push(newToken);
//					break;
//				case "-":
//					one = (Token) myStack.pop();
//					two = (Token) myStack.pop();
//					s1 = one.toString();
//					s2 = two.toString();
//					int1= Double.parseDouble(s1);
//					int2= Double.parseDouble(s2);
//					result= Double.valueOf(int2-int1);
//					newToken= new Token(result);
//					myStack.push(newToken);
//					break;
//				case "*":
//					one = (Token) myStack.pop();
//					two = (Token) myStack.pop();
//					s1 = one.toString();
//					s2 = two.toString();
//					int1= Double.parseDouble(s1);
//					int2= Double.parseDouble(s2);
//					result= Double.valueOf(int1*int2);
//					newToken= new Token(result);
//					myStack.push(newToken);
//					break;
//				case "/":
//					one = (Token) myStack.pop();
//					two = (Token) myStack.pop();
//					s1 = one.toString();
//					s2 = two.toString();
//					int1= Double.parseDouble(s1);
//					int2= Double.parseDouble(s2);
//					result= Double.valueOf(int2/int1);
//					newToken= new Token(result);
//					myStack.push(newToken);
//					break;
//				default:
//					myStack.push(currToken);
			}
		}
		return result;
	}
		// TODO implement this method

		store(value);
		return value; // change this
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * Sets the value of this variable.
	 * 
	 * @param value
	 *            the new value of this variable
	 */
	public void store(double value) {
		this.value=value;
	}

	/**
	 * Returns the name of this variable
	 * 
	 * @return the name of the variable
	 */
	public String name() {
		return name;
	}
}
