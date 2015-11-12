package rpn.calculator.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Joiner;

public class ExpressionEvaluator {
	private static Logger LOG = LogManager.getLogger();
	
	public static Double evaluate(String expression, double x, double y) {
		String[] tokens = expression.split("[ ]+");
		String[] output = ExpressionParser.infixToRPN(tokens);

		// Build output RPN string minus the commas
		LOG.debug("Tokens: " + Joiner.on(' ').join(output));

		// Feed the RPN string to RPNtoDouble to give result
		return ExpressionParser.RPNtoDouble(output, x, y);
	}
}
