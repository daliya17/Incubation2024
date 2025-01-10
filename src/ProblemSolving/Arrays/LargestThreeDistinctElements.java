package ProblemSolving.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeDistinctElements {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 4, 3, 50, 23, 90));
        System.out.println(largestThreeDistinctElements(list));
        System.out.println(largestThreeDistinctElements(Arrays.asList(10,9,9)));
        System.out.println(largestThreeDistinctElements(Arrays.asList(10,10,10)));
        System.out.println(largestThreeDistinctElements(List.of()));
    }

    public static List<Integer> largestThreeDistinctElements(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.addAll(list);
      return set.stream().limit(3).collect(Collectors.toList());
    }
}
