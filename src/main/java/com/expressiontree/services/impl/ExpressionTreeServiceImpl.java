package com.expressiontree.services.impl;

import java.util.Stack;

import org.springframework.stereotype.Service;

import com.expressiontree.services.ExpressionTreeService;

@Service
public class ExpressionTreeServiceImpl implements ExpressionTreeService {

	@Override
	public int eval(String expression) {

		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {

			// Current token is a number, push it to stack for numbers
			if (isNumeric(tokens[i])) {

				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length) {

					sbuf.append(tokens[i]);

					if (i + 1 < tokens.length && isNumeric(tokens[i + 1])) {
						i++;
					} else {

						break;
					}
				}
				values.push(Integer.parseInt(sbuf.toString()));
			}

			else if (isBracket(tokens[i])) {

				handleBracket(tokens[i], ops, values);
			}

			else if (isOperator(tokens[i])) {

				handleOperator(tokens[i], ops, values);

			}
		}

		// Entire expression has been parsed at this point, apply remaining ops to
		// remaining values
		executeFinalProcessing(ops, values);

		// Top of 'values' contains result, return it
		return values.pop();
	}

	private void executeFinalProcessing(Stack<Character> ops, Stack<Integer> values) {

		while (!ops.empty()) {
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		}

	}

	private void handleOperator(char data, Stack<Character> ops, Stack<Integer> values) {

		while (!ops.empty() && hasPrecedence(data, ops.peek()))
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		ops.push(data);
	}

	private void handleBracket(char data, Stack<Character> ops, Stack<Integer> values) {

		if (data == '(') {

			ops.push(data);
		}
		// Closing brace encountered, solve entire brace
		else if (data == ')') {

			while (ops.peek() != '(') {
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			}

			ops.pop();
		}

	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public int applyOp(char op, int b, int a) {

		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	private boolean isNumeric(char data) {

		return data >= '0' && data <= '9';
	}

	private boolean isBracket(char data) {

		return data == '(' || data == ')';
	}

	private boolean isOperator(char data) {

		return data == '+' || data == '-' || data == '*' || data == '/';
	}
}
