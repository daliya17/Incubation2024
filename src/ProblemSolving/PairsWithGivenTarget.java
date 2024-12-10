package ProblemSolving;

import java.util.HashSet;
import java.util.List;

public class PairsWithGivenTarget {
    public static void main(String[] args) {
       List<Integer> arr = List.of(1, 5, 3, 4, 2);
        System.out.println(pairsWithGivenTarget(arr, 2));
        System.out.println(pairsWithGivenTarget(List.of(2,4,6,8,10,12), 2));
    }

    public static int pairsWithGivenTarget(List<Integer> arr, int target){
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.size(); i++){
            if(set.contains(Math.abs(arr.get(i)-target))){
                ans++;
            }
            if (set.contains(arr.get(i) + target)) {
                ans++;
            }
            set.add(arr.get(i));
        }
        return ans;
    }
}
