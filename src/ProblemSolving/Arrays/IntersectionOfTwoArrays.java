package ProblemSolving.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println( intersection(List.of(1,2,2,1), List.of(2,2)));
    }

    public static List<Integer> intersection(List<Integer> arr1, List<Integer> arr2){
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer integer : arr1) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        for (Integer integer : arr2) {
            if (map.containsKey(integer)) {
                ans.add(integer);
                // reduce the count of the element in the map
                map.put(integer, map.get(integer) - 1);
                if (map.get(integer) == 0)
                    map.remove(integer);
            }
        }
        return ans;
    }
}
