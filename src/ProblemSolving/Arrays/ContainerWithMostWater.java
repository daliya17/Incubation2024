package ProblemSolving.Arrays;

import java.util.List;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7)));
        System.out.println(maxArea(List.of(1, 1)));
        System.out.println(maxArea(List.of(4, 3, 2, 1, 4)));
        System.out.println(maxArea(List.of(1, 2, 1)));
    }

    public static int maxArea(List<Integer> arr){
        int max = 0;
        int i=0, j=arr.size()-1;
        while(i<j){
            max = Math.max(max, Math.min(arr.get(i), arr.get(j))*(j-i));
            if(arr.get(i)<arr.get(j)){
                i++;
        }
            else{
                j--;
            }
        }
        return max;
    }
}
