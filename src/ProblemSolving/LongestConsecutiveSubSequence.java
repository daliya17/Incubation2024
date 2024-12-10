package ProblemSolving;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args){
        System.out.println(longestConsecutiveSequence(List.of(100, 4, 200, 1, 3, 2)));
        System.out.println(longestConsecutiveSequence(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(longestConsecutiveSequence(List.of(10, 5, 9, 4, 2, 3, 1, 7, 6, 8)));
        System.out.println(longestConsecutiveSequence(List.of(1,2,6,7,3)));
    }

    public static int longestConsecutiveSequence(List<Integer> arr){
        int max = 0, ans=0,k=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.size();i++){
            set.add(arr.get(i));
        }
        for(int i=0;i<arr.size();i++){
            ans=1;k=arr.get(i);
            while(set.contains(k+1)) {
                ans++;
                k++;
            }
            max = Math.max(max,ans);
        }
        return max;
    }
}
