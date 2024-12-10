package ProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println( twoSum(List.of(2,7,11,15), 9));
    }

    public static List<Integer> twoSum(List<Integer> arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(map.containsKey(target-arr.get(i)))
            {
                ans.add(i);
                ans.add(map.get(target-arr.get(i)));
            }
            map.put(arr.get(i),i);
        }
        return ans;
    }
}
