package ProblemSolving.Arrays;

import java.util.List;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args){
        System.out.println(rotatedSortedMinimum(List.of(5,6,7,1,2,3,4)));
        System.out.println(rotatedSortedMinimum(List.of(4,5,6,7,0,1,2)));
        System.out.println(rotatedSortedMinimum(List.of(11,13,15,17)));
        System.out.println(rotatedSortedMinimum(List.of(2,1)));
    }

    public static int rotatedSortedMinimum(List<Integer> arr){
        int low = 0, high = arr.size()-1;
        int mid ;
        while(low<high){
            mid = (low+high)/2;
            if(arr.get(mid)>arr.get(high))
                low = mid+1;
            else
                high=mid;
        }
        return arr.get(low);
    }
}
