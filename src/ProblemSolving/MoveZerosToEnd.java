package ProblemSolving;

import java.util.ArrayList;
import java.util.List;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        System.out.println(moveZeros(List.of(1, 2, 0, 4, 3, 0, 5, 0)));
        System.out.println(moveZeros(List.of(3, 5, 0, 12, 0, 87, 0, 23, 0, 0, 6, 4, 0)));
        System.out.println(moveZeros(List.of(10, 20, 30)));
        System.out.println(moveZeros(List.of(0, 0)));
    }

    public static List<Integer> moveZeros(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
//        List<Integer> zeroArray = arr.stream().filter(item -> item.equals(0)).collect(Collectors.toList());
//        if (zeroArray.isEmpty())
//            return arr;
//        if (zeroArray.size() == arr.size())
//            return arr;
//        List<Integer> arrayWithoutZero = arr.stream().filter(item -> !item.equals(0)).collect(Collectors.toList());
//        List<List<Integer>> list = Arrays.asList(arrayWithoutZero, zeroArray);
//        result = list.stream().flatMap(List::stream).collect(Collectors.toList());
//        return result;
        // using streams
      //  return arr.stream().sorted((a, b) -> a == 0 ? 1 : b == 0 ? -1 : 0).collect(Collectors.toList());
        // using for loop
        int count = 0;
        for (Integer integer : arr) {
            if (integer != 0) {
                result.add(integer);
            } else {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            result.add(0);
        }
        return result;
    }

}
