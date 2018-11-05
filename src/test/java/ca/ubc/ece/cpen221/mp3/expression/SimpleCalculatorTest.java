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

//        assertEquals("3.0+2.0", exp1.toString());
//        assertEquals("3.0-2.0", exp2.toString());
//        assertEquals("3.0*2.0", exp3.toString());
//        assertEquals("3.0/2.0", exp4.toString());

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

        /**
         * test the derivative of the variable function x * x - 2.0
         * where variable x = 1.0
         */
        final double tolerance = 1e-5;
        Expression fn1 = maker.createBinaryOperationExpression(mul, variable, variable);
        Expression numExp = maker.createNumberExpression(2.0);
        Expression fn = maker.createBinaryOperationExpression(sub, fn1, numExp);
        DerivativeExpression d = new DerivativeExpression(fn, variable);
        double dVal = d.eval();
        assertTrue(Math.abs(dVal-2.0) <= tolerance);
    }

    @Test
    public void DerTest1(){
            String variableName = "x";
            VariableExpression variable = new VariableExpression(variableName);
            double variableValue = 5.0;
            variable.store(variableValue);
            final double tolerance = 1e-5;
            ExpressionMaker maker = new ExpressionMaker();
            BinaryOperator sub = new SubtractionOperator();
            BinaryOperator mul = new MultiplicationOperator();
            Expression numExp = maker.createNumberExpression(3.0);
            Expression fn0= maker.createBinaryOperationExpression(sub, variable, numExp); //x-3
            Expression fn1 = maker.createBinaryOperationExpression(mul, fn0, fn0); //(x-3)^2
            DerivativeExpression d = new DerivativeExpression(fn1, variable);
            double dVal = d.eval();
            assertTrue(Math.abs(dVal-4.0) <= tolerance);
    }

    @Test
    public void DerTest2(){
            String variableName = "x";
            VariableExpression variable = new VariableExpression(variableName);
            double variableValue = 5.0;
            variable.store(variableValue);
            VariableExpression variable2= new VariableExpression(variableName);
            double variableValue2 = -5.0;
            variable2.store(variableValue2);
            final double tolerance = 1e-5;
            ExpressionMaker maker = new ExpressionMaker();
            UnaryOperator abs= new AbsoluteValueOperator();
            Expression fn1= maker.createUnaryOperationExpression(abs, variable);
            DerivativeExpression d = new DerivativeExpression(fn1, variable);
            double dVal = d.eval();
            assertTrue(Math.abs(dVal-1.0) <= tolerance);
            Expression fn2= maker.createUnaryOperationExpression(abs, variable2);
            DerivativeExpression d2 = new DerivativeExpression(fn2, variable2);
            double dVal2 = d2.eval();
            assertTrue(Math.abs(dVal2- -1.0) <= tolerance);
    }

    @Test
    public void DerTest3(){
            String variableName = "x";
            VariableExpression variable = new VariableExpression(variableName);
            double variableValue = 5.0;
            variable.store(variableValue);
            ExpressionMaker maker = new ExpressionMaker();
            BinaryOperator div= new DivisionOperator();
            Expression numExp = maker.createNumberExpression(5.0);
            Expression fn1= maker.createBinaryOperationExpression(div, numExp, variable); //5/x
            DerivativeExpression d = new DerivativeExpression(fn1, variable);
            double dVal = d.eval();
            final double tolerance = 1e-5;
            assertTrue(Math.abs(dVal+0.2) <= tolerance);
    }

    @Test
    public void DerTest4(){
            String variableName = "x";
            VariableExpression variable = new VariableExpression(variableName);
            double variableValue = -2.0;
            variable.store(variableValue);
            ExpressionMaker maker = new ExpressionMaker();
            BinaryOperator expo= new ExponentiationOperator();
            BinaryOperator sub= new SubtractionOperator();
            BinaryOperator div= new DivisionOperator();
            Expression numExp1 = maker.createNumberExpression(3.0);
            Expression fn1= maker.createBinaryOperationExpression(expo, variable,numExp1); //x^3
            Expression numExp2= maker.createNumberExpression(2.0);
            Expression fn2= maker.createBinaryOperationExpression(expo,variable, numExp2 ); //x^2
            Expression numExp3= maker.createNumberExpression(15.0);
            Expression fn3= maker.createBinaryOperationExpression(sub, numExp3, fn1); //15-x^3
            Expression fn4= maker.createBinaryOperationExpression(div, fn3, fn2);
            DerivativeExpression d = new DerivativeExpression(fn4, variable);
            double dVal = d.eval();
            final double tolerance = 1e-5;
            assertTrue(Math.abs(dVal-2.75) <= tolerance);
    }

        @Test
        public void test1() {

                ExpressionMaker maker = new ExpressionMaker();

                final Expression numExp1 = maker.createNumberExpression(10.5);
                final Expression numExp2 = maker.createNumberExpression(15.27);
                assertEquals(numExp1.toString(), "10.5");
                assertEquals(numExp2.toString(), "15.27");

                UnaryOperator abs = new AbsoluteValueOperator();
                BinaryOperator expo = new ExponentiationOperator();
                UnaryOperator neg = new NegationOperator();

                assertEquals(abs.toString(), "| |");
                assertEquals(expo.toString(), "x^y");
                assertEquals(neg.toString(), "-");

                Expression exp1 = maker.createUnaryOperationExpression(abs, numExp1);
                Expression exp2 = maker.createBinaryOperationExpression(expo, numExp1, numExp2);
                Expression exp3 = maker.createUnaryOperationExpression(neg, numExp1);


                assertEquals("|10.5|", exp1.toString());
                //assertEquals("10.5^15.27", exp2.toString());
                assertEquals("-10.5", exp3.toString());

                assertTrue(exp1.eval() == 10.5);
                //assertTrue(exp2.eval() == 9.0);
                assertTrue(exp3.eval() == -10.5);
        }

        @Test
        public void Newton1(){
                String variableName = "x";
                VariableExpression variable = new VariableExpression(variableName);
                double variableValue = 0.5;
                variable.store(variableValue);
                ExpressionMaker maker = new ExpressionMaker();
                BinaryOperator expo= new ExponentiationOperator();
                BinaryOperator sub= new SubtractionOperator();
                BinaryOperator add= new AdditionOperator();
                BinaryOperator mul= new MultiplicationOperator();
                Expression numExp1 = maker.createNumberExpression(1.0);
                Expression numExp2 = maker.createNumberExpression(2.0);
                Expression numExp3 = maker.createNumberExpression(3.0);
                Expression numExp4= maker.createNumberExpression(4.0);
                Expression fn1= maker.createBinaryOperationExpression(expo, variable,numExp3);
                Expression fn2= maker.createBinaryOperationExpression(expo, variable,numExp2);
                Expression fn3= maker.createBinaryOperationExpression(mul, numExp4, fn2);
                Expression fn4= maker.createBinaryOperationExpression(sub, fn1, fn3);
                Expression fn5= maker.createBinaryOperationExpression(add, fn4, numExp1);
                final double tolerance = 1e-5;
                System.out.println(DerivativeExpression.NewtonMethod(fn5, variable,tolerance).eval());
        }


}
