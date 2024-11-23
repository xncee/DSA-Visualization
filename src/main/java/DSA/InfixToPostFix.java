package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostFix {
    public boolean validateExpression(String exp) {
        Stack<Character> s = new Stack();
        for (char c: exp.toCharArray()) {
            if (c == '(') {
                s.push(c);
            }
            else if (c == ')') {
                if (s.isEmpty()) return false;
                // if the stack is empty, then there is no open bracket to the current close bracket.
                // and then we check if it matches the top element (last open bracket)
                // last opened bracket should be closed first -> ex: (()(()))
                char top = (char) s.peek();
                if (top != '(') return false;

                s.pop();
            }
        }

        return s.isEmpty();
    }
    public String[] convertToPostfix(String[] tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack();

        for (String token: tokens) {
            if (isOperator(token)) {
                if (token.equals("(")
                        || stack.isEmpty()
                        || getOperatorPrecedence(token) >= getOperatorPrecedence(stack.peek())) {
                    stack.push(token);
                }
                else if (token.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                }
                else {
                    while (!stack.isEmpty() && getOperatorPrecedence(token) < getOperatorPrecedence(stack.peek())) {
                        postfix.add(stack.pop());
                    }
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
        Stack<Integer> s = new Stack();
        for (String token: tokens) {
            if (isOperator(token)) {
                int b = s.pop();
                int a = s.pop();
                int result = performOperation(token, a, b);
                s.push(result);
            }
            else {
                int num;
                try {
                    num = Integer.parseInt(token);
                }
                catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid token: '"+token+"'");
                }
                s.push(num);
            }
        }

        return s.peek();
    }
    private int performOperation(String operator, int a, int b) {
        switch (operator) {
            case "+": return a+b;
            case "-": return a-b;
            case "/": return a/b;
            case "*": return a*b;
            default: throw new IllegalArgumentException("Invalid operator: '"+operator+"'");
        }
    }
    private int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "*":
            case "/":
            case "%":
            case "^": return 1;
            case "+":
            case "-": return 0;
            default: throw new IllegalArgumentException("Invalid operator: '"+operator+"'");
        }
    }
    private boolean isOperator(String s) {
        switch (s) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "(":
            case ")": return true;
            default: return false;
        }
    }

}
