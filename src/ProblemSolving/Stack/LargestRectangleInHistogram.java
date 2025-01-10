package ProblemSolving.Stack;

import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(List.of(2, 1, 5, 6, 2, 3)));
    }

    public static int largestRectangleArea(List<Integer> arr){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.size();i++){
            if(!stack.empty() && arr.get(i)< arr.get(stack.peek())){
                int index = stack.pop();
                max = Math.max(max, (arr.get(index)*(stack.empty()? index: index-stack.peek()-1)));
            }
            else {
                stack.push(i);
            }
        }
//        while (index<arr.size()) {
//            if (stack.isEmpty() || arr.get(stack.peek()) <= arr.get(index)) {
//                stack.push(index++);
//            } else {
//                int top = stack.pop();
//                int area = arr.get(top) * (stack.empty() ? index : index - stack.peek() - 1);
//                max = Math.max(max, area);
//            }
//        }
        while (!stack.empty()){
          int top = stack.pop();
          int area = arr.get(top)*(stack.empty()? arr.size(): arr.size()-stack.peek()-1);
          max = Math.max(max,area);
        }
        // largest rectangle in histogram
//        int n = arr.size();
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && arr.get(i) < arr.get(stack.peek())) {
//                int height = arr.get(stack.pop());
//                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                max = Math.max(max, height * width);
//            }
//            stack.push(i);
//        }
//        if (!stack.isEmpty()) {
//            int i = n;
//            while (!stack.isEmpty()) {
//                int height = arr.get(stack.pop());
//                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                max = Math.max(max, height * width);
//            }
//        }
        return max;
    }
}
