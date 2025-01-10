package ProblemSolving.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};
        System.out.println(maxSubArraySum(arr));
    }

    public static int maxSubArraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum += arr[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < arr[i]) {
                currentSum =0;
            }
        }

        return maxSum;
    }
}
