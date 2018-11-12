package ca.ubc.ece.cpen221.mp3.expression;

/**
 * DerivativeExpression - The derivative of specific function.
 **Abstraction function: an expression containing the derivative of a given expression
 **Rep Invariant: it should have two expression and an operator to apply to them
 **/

public class DerivativeExpression implements Expression {
	private Expression function;
	private VariableExpression indep;
	private final double DELTA= Math.pow(10, -9);
	/**
	 * Create an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 *
	 * @param fn the function whose derivative this expression represents
	 * @param independentVar the variable with respect to which we're
	 * 		  differentiating
	 */
	public DerivativeExpression(Expression fn,
								VariableExpression independentVar) {
		function=fn;
		indep=independentVar;
	}

	/**
	 * Evaluates an arithmetic expression.
	 *
	 * @return the value to which this expression evaluates
	 */
	@Override
	public double eval() {
		double one= function.eval();
		indep.store(indep.eval()+DELTA);
		double two= function.eval();
		indep.store(indep.eval()-DELTA);
		return (two-one)/DELTA;
	}

	/**
	 * Creates a String representation of an arithmetic expression.
	 *
	 * @return this expression in string form
	 */
	@Override
	public String toString(){
		return Double.toString(this.eval());
	}

	/**
	 * @param fn the function whose derivative this expression represents
	 * @param indepVar the variable with respect to which we're differentiating
	 * @param x0 initial approximation for the zero of the function
	 * @param tolerance how close to zero the returned zero has to be
	 * @return Cryptarithm to be solved
	 */
	public static double NewtonsMethod(Expression fn, VariableExpression indepVar, double x0, double tolerance){
		//parameters: initially x0 is equal to the value of indepVar
		double xn;
		double temp= indepVar.eval();
		indepVar.store(x0);
		if(Math.abs(fn.eval())<= tolerance){
			return indepVar.eval();
		}
		else{
			Expression fn2= new DerivativeExpression(fn, indepVar);
			xn= indepVar.eval()- (fn.eval()/ fn2.eval());
			indepVar.store(temp);
			return NewtonsMethod(fn,indepVar,xn,tolerance);
		}
	}


}