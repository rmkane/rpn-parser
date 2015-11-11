package rpn.calculator.core;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
	ADDITION(Token.ADDITION, 0, Operator.LEFT_ASSOC, new Evaluator() {
		public double evaluate(double a, double b) {
			return a + b;
		}
		public int evaluate(int a, int b) {
			return a + b;
		}
		public float evaluate(float a, float b) {
			return a + b;
		}
	}),
	SUBTRACTION(Token.SUBTRACTION, 0, Operator.LEFT_ASSOC, new Evaluator() {
		public double evaluate(double a, double b) {
			return a - b;
		}
		public int evaluate(int a, int b) {
			return a - b;
		}
		public float evaluate(float a, float b) {
			return a - b;
		}
	}),
	MULTIPLICATION(Token.MULTIPLICATION, 5, Operator.LEFT_ASSOC, new Evaluator() {
		public double evaluate(double a, double b) {
			return a * b;
		}
		public int evaluate(int a, int b) {
			return a * b;
		}
		public float evaluate(float a, float b) {
			return a * b;
		}
	}),
	DIVISION(Token.DIVISION, 5, Operator.LEFT_ASSOC, new Evaluator() {
		public double evaluate(double a, double b) {
			return a / b;
		}
		public int evaluate(int a, int b) {
			return a / b;
		}
		public float evaluate(float a, float b) {
			return a / b;
		}
	});

	// Associativity constants for operators
	protected static final int LEFT_ASSOC = 0;
	protected static final int RIGHT_ASSOC = 1;

	private static final Map<String, Operator> lookup;

	static {
		lookup = new HashMap<String, Operator>();

		for (Operator operator : Operator.values()) {
			lookup.put(operator.getSign(), operator);
		}
	}

	private String sign;
	private int precedence;
	private int associativity;
	private Evaluator evaluator;

	private Operator(String sign, int precedence, int associativity, Evaluator evaluator) {
		this.sign = sign;
		this.precedence = precedence;
		this.associativity = associativity;
		this.evaluator = evaluator;
	}

	public static Operator lookup(String operator) {
		return lookup.get(operator);
	}

	public String getSign() {
		return sign;
	}

	public int getPrecedence() {
		return precedence;
	}

	public int getAssociativity() {
		return associativity;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}
}
