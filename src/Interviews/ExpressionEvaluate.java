package Interviews;

import java.util.Stack;

public class ExpressionEvaluate {

    public static void main(String[] args) {
        System.out.println(evaluate("-(a+b"));
        System.out.println(evaluate("-(b-(c+d"));
        System.out.println(evaluate("a-(b-c"));
        System.out.println(evaluate("x-(y+z-(p-q))"));
        System.out.println(evaluate("a-(b+c)-d"));
    }

    public static String evaluate(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int currentOperator = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(currentOperator);

            else if (s.charAt(i) == ')')
                stack.pop();
            else if (s.charAt(i) == '-') {
                currentOperator *= -1;
                int sign = stack.peek() * -1;
                if (sign == -1)
                    result.append('-');
                else
                    result.append('+');
            } else if (s.charAt(i) == '+') {
                int sign = stack.peek();
                if (sign == -1)
                    result.append('-');
                else
                    result.append('+');
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

}





