package ProblemSolving.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args) {

        System.out.println(rotateArray(List.of(1,2,3,4,5,6,7),3));
        System.out.println(rotateArray(List.of(-1,-100,3,99),2));
        System.out.println(rotateArray(List.of(1,2,3,4,5,6,7),5));
    }

    public static List<Integer> rotateArray(List<Integer> arr,int k){
        k=k%arr.size();
        int[] result = new int[arr.size()];
        for (int i=0;i<arr.size();i++)
            result[(k+i)%arr.size()] = arr.get(i);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
    // another approach
     // reverse the whole array, then reverse the first k elements, then reverse the remaining elements
}
