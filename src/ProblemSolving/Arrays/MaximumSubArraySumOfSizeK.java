package ProblemSolving.Arrays;

import java.util.List;

public class MaximumSubArraySumOfSizeK {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(maxSubArraySum(List.of(1, 2, 3, 4, 5, -1, -2, -3, -4, -5), 3)); // ans: 12
    }

    public static int maxSubArraySum(List<Integer> arr, int k){
        int max=0, sum=0;
        for(int i=0;i<k;i++)
            sum+=arr.get(i);
        max = sum;
        for(int i=k;i<arr.size();i++){
            sum=sum-arr.get(i-k);
            sum+=arr.get(i);
            max=Math.max(sum, max);
        }
        return max;
        // time complexity is O(n)


    }

}
