package ProblemSolving.Arrays;

import java.util.List;

public class SecondLargestElement {
    public static void main(String[] args) {
        System.out.println(secondLargestElement(List.of(12, 35, 1, 10, 34, 1)));
        System.out.println(secondLargestElement(List.of(10, 5, 10)));
        System.out.println(secondLargestElement(List.of(10,10,10)));
    }

    public static Integer secondLargestElement(List<Integer> arr){
        // using streams
     //   return arr.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(-1);
        // using for loop
//      Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
//        set.addAll(arr);
//        if(set.size() < 2){
//            return -1;
//        }
//        return set.stream().skip(1).findFirst().get();
        // without streams and set
        Integer max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (Integer integer : arr) {
            if (integer > max) {
                secondMax = max;
                max = integer;
            } else if (integer > secondMax && !integer.equals(max)) {
                secondMax = integer;
            }
        }
        if(secondMax == Integer.MIN_VALUE){
            return -1;
        }
        return secondMax;
    }
}
