package ProblemSolving.Arrays;

import java.util.List;

public class FindSmallestMissingNumber {
    public static void main(String[] args){
        System.out.println(smallestMissingNumber(List.of(0, 1, 2, 6, 9),5,10));
        System.out.println(smallestMissingNumber(List.of(4, 5, 10, 11),4,12));
        System.out.println(smallestMissingNumber(List.of(0, 1, 2, 3),4,5));
        System.out.println(smallestMissingNumber(List.of(0, 1, 2, 3, 4, 5, 6, 7, 10),9,11));
    }

    public static int smallestMissingNumber(List<Integer> arr,int n, int m){
//        Set<Integer> set = new HashSet<>(arr);
//        for(int i=0;i<m;i++){
//            if(!set.contains(i))
//                return i;
//        }
//        return 0;
        // time complexity is O(m)

        // using binary search
         int low = 0;
         int high = n - 1;
         while (low <= high) {
             int mid = low + (high - low) / 2;
             if (arr.get(mid) == mid) {
                 low = mid + 1;
             } else {
                 high = mid - 1;
             }
         }
         return low;
// time complexity is O(log n)
    }
}
