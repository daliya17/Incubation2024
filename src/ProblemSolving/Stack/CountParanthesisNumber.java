package ProblemSolving.Stack;

import java.util.Stack;

public class CountParanthesisNumber {
    public static void main(String[] args) {
        String str = "(()()()())";
        System.out.println(countParanthesis(str));//10
        System.out.println(countParanthesis("()(()))"));//6
        System.out.println(countParanthesis("()(()))(")); //6
        System.out.println(countParanthesis("()()())")); // 6
        System.out.println(countParanthesis("(()()(")); // 4
        System.out.println(countParanthesis("(()()()")); // 6
        System.out.println(countParanthesis("()()(")); // 4
        System.out.println(countParanthesis(")()())")); // 4
    }

    public static int countParanthesis(String str) {
        int max = -1;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(')', -1));
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty() || str.charAt(i) == '(') {
                stack.push(new Pair(str.charAt(i), i));
            } else {
                stack.pop();
                if (!stack.empty()) {
                    max = Math.max(max, i - stack.peek().index);
                } else
                    stack.push(new Pair(str.charAt(i), i));
            }
        }
        return max;
    }

    public static class Pair {
        public char str;
        public int index;

        public Pair(char str, int index) {
            this.str = str;
            this.index = index;
        }
    }
}
