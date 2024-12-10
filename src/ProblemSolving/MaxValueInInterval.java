package ProblemSolving;

import java.util.Deque;
import java.util.List;

public class MaxValueInInterval {
    public static void main(String[] args) {
        System.out.println( maxSlidingWindow(List.of(1,3,-1,-3,5,3,6,7), 3));
        // expected [3,3,5,5,6,7]
    }
    public static List<Integer> maxSlidingWindow(List<Integer> arr, int k) {
        Deque<Integer> deque = new java.util.LinkedList<>();
        List<Integer> ans = new java.util.ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            // remove elements outside the window of size k from the front
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // remove elements smaller than the current element from the back
            while (!deque.isEmpty() && arr.get(deque.peekLast()) <= arr.get(i)) {
                deque.pollLast();
            }
            // add the current element to the back
            deque.offerLast(i);
            // add the maximum element to the answer once the window size is reached
            if (i >= k - 1) {
                ans.add(arr.get(deque.peek()));
            }
        }
        return ans;
    }

    // dry run
    // arr = [1,3,-1,-3,5,3,6,7], k = 3
    // deque = [], ans = []
    // i = 0
    // deque = [0], ans = []
    // i = 1
    // deque = [1], ans = [], // 3 > 1
    // i = 2
    // deque = [1,2], ans = [3],// -1 < 3
    // i = 3
    // deque = [1,2,3], ans = [3,3], // -3 < -1
    // i = 4
    // deque = [4], ans = [3,3], // 5 > -3
    // i = 5
    // deque = [4,5], ans = [3,3,5], // 3 < 5
    // i = 6
    // deque = [6], ans = [3,3,5], // 6 > 3
    // i = 7
    // deque = [6,7], ans = [3,3,5,5], // 7 > 6
    // ans = [3,3,5,5,6,7]
}
