package rpn.calculator.core;

public class ExpressionEvaluator {
	public static Double evaluate(String expression) {
		String[] tokens = expression.split("[ ]+");
		String[] output = ExpressionParser.infixToRPN(tokens);

		// Build output RPN string minus the commas
		for (String token : output) {
			System.out.print(token + " ");
		}

		// Feed the RPN string to RPNtoDouble to give result
		return ExpressionParser.RPNtoDouble(output);
	}
}
