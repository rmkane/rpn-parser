package rpn.calculator.core;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluatorTest {
	@Test
	public void testEvaluate() {
		String input = "( 1 + 2 ) * ( 3 / 4 ) - ( 5 + 6 )";
		Double result = ExpressionEvaluator.evaluate(input);

		Assert.assertEquals(result, -8.75d, 0.000000000000000000000000000001);
	}
}
