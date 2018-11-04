package ca.ubc.ece.cpen221.mp3.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import ca.ubc.ece.cpen221.mp3.operator.*;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionMaker;
import org.junit.Test;

// TODO you will need to import other packages that has code to test

public class SimpleCalculatorTest {

	// TODO Add more tests

	@Test
	public void testSimpleOperations() {

        ExpressionMaker maker = new ExpressionMaker();

        final Expression numExp1 = maker.createNumberExpression(3.0);
        final Expression numExp2 = maker.createNumberExpression(2.0);
        assertEquals(numExp1.toString(), "3.0");
        assertEquals(numExp2.toString(), "2.0");

        BinaryOperator add = new AdditionOperator();
        BinaryOperator sub = new SubtractionOperator();
        BinaryOperator mul = new MultiplicationOperator();
        BinaryOperator div = new DivisionOperator();

        assertEquals(add.toString(), "+");
        assertEquals(sub.toString(), "-");
        assertEquals(mul.toString(), "*");
        assertEquals(div.toString(), "/");

        Expression exp1 = maker.createBinaryOperationExpression(add, numExp1, numExp2);
        Expression exp2 = maker.createBinaryOperationExpression(sub, numExp1, numExp2);
        Expression exp3 = maker.createBinaryOperationExpression(mul, numExp1, numExp2);
        Expression exp4 = maker.createBinaryOperationExpression(div, numExp1, numExp2);

        /* simple arithmetic */

        assertEquals("3.0+2.0", exp1.toString());
        assertEquals("3.0-2.0", exp2.toString());
        assertEquals("3.0*2.0", exp3.toString());
        assertEquals("3.0/2.0", exp4.toString());

        assertTrue(exp1.eval() == 5.0);
        assertTrue(exp2.eval() == 1.0);
        assertTrue(exp3.eval() == 6.0);
        assertTrue(exp4.eval() == 1.5);

        /* with variables */

        String variableName = "x";
        VariableExpression variable = new VariableExpression(variableName);
        double variableValue = 1.0;
        variable.store(variableValue);
        assertTrue(variable.eval() == 1.0);
        assertEquals(variable.name(), "x");
        assertEquals(variable.toString(), "x=1.0");
//
//        /**
//         * test the derivative of the variable function x * x - 2.0
//         * where variable x = 1.0
//         */
//        final double tolerance = 1e-5;
//        Expression fn1 = maker.createBinaryOperationExpression(mul, variable, variable);
//        Expression numExp = maker.createNumberExpression(2.0);
//        Expression fn = maker.createBinaryOperationExpression(sub, fn1, numExp);
//        DerivativeExpression d = new DerivativeExpression(fn, variable);
//        double dVal = d.eval();
//        assertTrue(Math.abs(dVal-2.0) <= tolerance);
    }

}
