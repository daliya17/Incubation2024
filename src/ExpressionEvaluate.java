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
        stack.push(1); // Default sign is +1 (positive)
        int sign = 1;  // Tracks the current sign

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '+') {
               sign=-stack.peek();
            } else if (ch == '-') {
                sign = -stack.peek(); // Flip based on the top of the stack
            } else if (ch == '(') {
                stack.push(sign); // Store the current sign for this bracket
            } else if (ch == ')') {
                stack.pop(); // Remove the last applied sign effect
            } else { // It's a variable (a-z)
                // If it's not the first character, check if we need to append '+' explicitly
                if (result.length() > 0 && result.charAt(result.length() - 1) != '-' && result.charAt(result.length() - 1) != '+') {
                    if (sign == 1) {
                        result.append('+'); // Add explicit '+' if required
                    }
                }

                if (sign == -1) {
                    result.append('-'); // Append '-' before the variable
                }
                result.append(ch); // Append the variable itself

                sign = 1; // Reset sign back to normal after processing a character
            }
        }

        return result.toString();
    }
//    public static String evaluate(String s) {
//        StringBuilder str = new StringBuilder();
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        int current = 1;
//        for (int i = 0; i < s.length(); i++) {
//            if (i < s.length() - 1 && s.charAt(i) == '-' && s.charAt(i + 1) == '(')
//                current *= -1;
//            if (s.charAt(i) == '(' && current == -1)
//                stack.push(-1);
//            else if (s.charAt(i) == ')' && !stack.empty())
//                stack.pop();
//            else if (s.charAt(i) == '+') {
//                if (!stack.empty() && stack.peek() == -1) {
//                    str.append('-');
//                } else
//                    str.append('+');
//            } else if (s.charAt(i) == '-') {
//                if (!stack.empty() && stack.peek() == -1)
//                    str.append('+');
//                else
//                    str.append('-');
//            } else
//
//                str.append(s.charAt(i));
//        }
//
//        return str.toString();
//    }
}





