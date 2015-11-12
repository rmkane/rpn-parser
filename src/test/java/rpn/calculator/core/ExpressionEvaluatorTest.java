package rpn.calculator.core;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluatorTest {
	@Test
	public void testEvaluate() {
		String expression = "x + ( 3 / y ) + 5";
		double x = 8;
		double y = 3;
		Double result = ExpressionEvaluator.evaluate(expression, x, y);

		// x 3 y / + 5 + 14.0
		Assert.assertEquals(result, 14.0d, 0.000000000000000000000000000001);
	}
}
