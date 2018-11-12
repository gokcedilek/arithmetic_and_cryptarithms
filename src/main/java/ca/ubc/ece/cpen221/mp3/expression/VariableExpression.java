package ca.ubc.ece.cpen221.mp3.expression;

import ca.ubc.ece.cpen221.mp3.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionParser;

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

	/**
	 * Evaluates an arithmetic expression.
	 *
	 * @return the value to which this expression evaluates
	 */
	@Override
	public double eval() {
		return value;
	}

	/**
	 * Creates a String representation of an arithmetic expression.
	 *
	 * @return this expression in string form
	 */
	@Override
	public String toString() {
		return name+ "="+ value;
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
