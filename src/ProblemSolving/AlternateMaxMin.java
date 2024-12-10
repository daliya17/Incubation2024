package ProblemSolving;

import java.util.ArrayList;
import java.util.List;

public class AlternateMaxMin {
    public static void main(String[] args) {
        System.out.println(getAlternateMaxMin(List.of(1, 2, 3, 4, 5, 6, 7)));
        System.out.println(getAlternateMaxMin(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getAlternateMaxMin(List.of(23, 45, 67, 89, 90)));
        System.out.println(getAlternateMaxMin(List.of(12, 34, 56, 78, 89, 90)));
    }

    public static List<Integer> getAlternateMaxMin(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            result.add(arr.get(end));
            result.add(arr.get(start));
            start++;
            end--;
        }
        if(n % 2 != 0) {
            result.add(arr.get(start));
        }
        return result;
        // return IntStream.range(0, n / 2).mapToObj(i -> List.of(arr.get(n - i - 1), arr.get(i))).flatMap(List::stream).collect(Collectors.toList());
    }
}