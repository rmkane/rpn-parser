package rpn.calculator.core;
import java.util.ArrayList;
import java.util.Stack;

public class ExpressionParser {
	// Test if token is an operator
	private static boolean isOperator(String token) {
		return Operator.lookup(token) != null;
	}

	// Test associativity of operator token
	private static boolean isAssociative(String token, int type) {
		Operator op = Operator.lookup(token);
		
		if (op == null) {
			throw new IllegalArgumentException("Invalid token: " + token);
		}

		if (op.getAssociativity() == type) {
			return true;
		}

		return false;
	}

	// Compare precedence of operators.
	private static final int cmpPrecedence(String token1, String token2) {
		Operator op1 = Operator.lookup(token1);
		Operator op2 = Operator.lookup(token2);
		
		if (op1 == null || op2 == null) {
			throw new IllegalArgumentException("Invalid tokens: " + token1 + " " + token2);
		}

		return op1.getPrecedence() - op2.getPrecedence();
	}

	// Convert infix expression format into reverse Polish notation
	public static String[] infixToRPN(String[] inputTokens) {
		ArrayList<String> out = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();

		// For each token
		for (String token : inputTokens) {
			// If token is an operator
			if (isOperator(token)) {
				// While stack not empty AND stack top element is an operator
				while (!stack.empty() && isOperator(stack.peek())) {
					if ((isAssociative(token, Operator.LEFT_ASSOC) && cmpPrecedence(token, stack.peek()) <= 0)
							|| (isAssociative(token, Operator.RIGHT_ASSOC) && cmpPrecedence(token, stack.peek()) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				// Push the new operator on the stack
				stack.push(token);
			}
			// If token is a left bracket '('
			else if (token.equals(Token.OPEN_PAREN)) {
				stack.push(token); //
			}
			// If token is a right bracket ')'
			else if (token.equals(Token.CLOSED_PAREN)) {
				while (!stack.empty() && !stack.peek().equals(Token.OPEN_PAREN)) {
					out.add(stack.pop());
				}
				stack.pop();
			}
			// If token is a number
			else {
				out.add(token);
			}
		}
		
		while (!stack.empty()) {
			out.add(stack.pop());
		}

		return out.toArray(new String[out.size()]);
	}

	public static double RPNtoDouble(String[] tokens) {
		Stack<String> stack = new Stack<String>();

		// For each token
		for (String token : tokens) {
			// If the token is a value push it onto the stack
			if (!isOperator(token)) {
				stack.push(token);
			} else {
				// Token is an operator: pop top two entries
				Operator op = Operator.lookup(token);
				Double d2 = Double.valueOf(stack.pop());
				Double d1 = Double.valueOf(stack.pop());
				Double result = op.getEvaluator().evaluate(d1, d2);

				// Push result onto stack
				stack.push(String.valueOf(result));
			}
		}

		return Double.valueOf(stack.pop());
	}
}