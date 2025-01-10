package ProblemSolving.Arrays;

import java.util.List;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(List.of(1, 3, 4, 2, 2)));
        System.out.println(findDuplicate( List.of(3, 1, 3, 4, 2)));
        System.out.println(findDuplicate( List.of(1, 1)));
        System.out.println(findDuplicate(List.of(1, 1, 2)));
    }
    public static int findDuplicate(List<Integer> arr){
//        HashSet<Integer> set = new HashSet<>();
//        for (Integer integer : arr) {
//            if (set.contains(integer))
//                return integer;
//            else
//                set.add(integer);
//        }
        // using Floyd's Tortoise and Hare (Cycle Detection)
        // no extra space
//        int slow = arr.get(0);
//        int fast = arr.get(0);
//        do {
//            slow = arr.get(slow);
//            fast = arr.get(arr.get(fast));
//        } while (slow != fast);
//
//        return slow   ;
        // using binary search
//        int low = 1;
//        int high = arr.size()-1;
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            int count = 0;
//            for (Integer integer : arr) {
//                if (integer <= mid)
//                    count++;
//            }
//            if (count > mid)
//                high = mid;
//            else
//                low = mid + 1;
//        }
//        return low;
        // time complexity is O(nlogn)
        // using xor
        int xor = 0;
        for (int i = 0; i < arr.size(); i++) {
            xor ^= arr.get(i);
            xor ^= i;
        }
        return xor;

    }

    // using Floyd's Tortoise and Hare (Cycle Detection)
    // public static int findDuplicate(List<Integer> arr){
    //     int slow = arr.get(0);
    //     int fast = arr.get(0);
    //     do {
    //         slow = arr.get(slow);
    //         fast = arr.get(arr.get(fast));
    //     } while (slow != fast);

    //     slow = arr.get(0);
    //     while (slow != fast) {
    //         slow = arr.get(slow);
    //         fast = arr.get(fast);
    //     }
    //     return slow;
    // }
    // dry run
    // arr = [1, 3, 4, 2, 2]
    // slow = 1, fast = 1
    // slow = 3, fast = 2
    // slow = 2, fast = 2
    // slow==fast, slow = 1
    // slow = 1, fast = 2
    // slow = 3, fast = 4
    // slow = 2, fast = 2
    // slow==fast, slow = 2

}
