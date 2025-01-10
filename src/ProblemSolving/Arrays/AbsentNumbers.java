package ProblemSolving.Arrays;

import java.util.ArrayList;
import java.util.List;

public class AbsentNumbers {
    public static void main(String[] args){
        System.out.println(absentNumbers(List.of(4,3,2,7,8,2,3,1)));
        System.out.println(absentNumbers(List.of(1,2,3,4)));
        System.out.println(absentNumbers(List.of(2,2,2,2)));
    }

    public static List<Integer> absentNumbers(List<Integer> A){
       List<Integer> ans = new ArrayList<>();
//        Set<Integer> set = new HashSet<>(arr);
//        for(int i=1;i<=arr.size();i++)
//        {
//            if(!set.contains(i))
//                ans.add(i);
//        }
//        return ans;
        // no extra space
        List<Integer> arr = new ArrayList<>(A);
        for(int i=0;i<arr.size();i++){
           int num = Math.abs(arr.get(i));
           if(arr.get(num-1)>0)
               arr.set(num-1, -arr.get(num-1));
        }
        for(int i=0;i<arr.size();i++){
           if(arr.get(i)>0)
               ans.add(i+1);
        }
        return ans;
    }
}
