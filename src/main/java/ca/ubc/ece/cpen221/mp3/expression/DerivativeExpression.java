package ca.ubc.ece.cpen221.mp3.expression;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
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


	@Override
	public double eval() {
		double one= function.eval();
		indep.store(indep.eval()+DELTA);
		double two= function.eval();
		indep.store(indep.eval()-DELTA);
		return (two-one)/DELTA;
	}

	@Override
	public String toString(){
		return Double.toString(this.eval());
	}

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
