package ProblemSolving;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args) {

        System.out.println(rotateArray(List.of(1,2,3,4,5,6,7),3));
    }

    public static List<Integer> rotateArray(List<Integer> arr,int k){
        int[] result = new int[arr.size()];
        for (int i=0;i<arr.size();i++)
            result[(k+i)%7] = arr.get(i);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
    // another approach
     // reverse the whole array, then reverse the first k elements, then reverse the remaining elements
}
