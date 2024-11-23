package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class InfixToPostFix {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/", "(", ")", "^", "%");
    public boolean validateExpression(String exp) {
        Stack<Character> stack = new Stack<>();
        char prev = '\0';
        for (char c: exp.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                // if the stack is empty, then there is no open bracket to the current close bracket.
                // and then we check if it matches the top element (last open bracket)
                // last opened bracket should be closed first -> ex: (()(()))
                if (stack.peek() != '(') return false;

                stack.pop();
            }
            else if (isOperator(String.valueOf(c))) {
                // ensure that expression doesn't start with an operator & it doesn't contain consecutive operators
                if (prev == '\0' || isOperator(String.valueOf(prev)))
                    return false;
            }

            prev = c;
        }

        // ensure that the expression doesn't end with an operator
        return stack.isEmpty() && !isOperator(String.valueOf(prev));
    }
    public String[] convertToPostfix(String[] tokens) {
        // This method assumes that the expression is valid
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token: tokens) {
            if (isOperator(token)) {
                if (token.equals("(")) {
                    stack.push(token);
                }
                else if (token.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                }
                else {
                    // if the current operator has higher precedence, it wil be pushed directly into the stack
                    while (!stack.isEmpty() && getOperatorPrecedence(token) <= getOperatorPrecedence(stack.peek())) {
                        postfix.add(stack.pop());
                    }
                    stack.push(token);
                }
            }
            else {
                postfix.add(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix.toArray(new String[0]);
    }
    public int evaluatePostfix(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid postfix expression");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = performOperation(token, a, b);
                stack.push(result);
            }
            else {
                int num;
                try {
                    num = Integer.parseInt(token);
                }
                catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid token: '"+token+"'");
                }
                stack.push(num);
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Invalid postfix expression");
        }
        return stack.pop();
    }
    private int performOperation(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case "%": return a % b;
            case "^": return (int) Math.pow(a, b); // Assuming integer power
            default: throw new IllegalArgumentException("Invalid operator: '" + operator + "'");
        }
    }
    private int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "^": return 3;
            case "*":
            case "/":
            case "%": return 2;
            case "+":
            case "-": return 1;
            default: throw new IllegalArgumentException("Invalid operator: '" + operator + "'");
        }
    }
    private boolean isOperator(String s) {
        return OPERATORS.contains(s);
    }

}
