package ProblemSolving;

import java.util.ArrayList;
import java.util.List;

public class SegregateOddEven {
    public static void main(String[] args){
        System.out.println(segregateOffEven(List.of(7, 2, 9, 4, 6, 1, 3, 8, 5)));
        System.out.println(segregateOffEven(List.of(1, 3, 2, 4, 7, 6, 9, 10)));
    }

    public static List<Integer> segregateOffEven(List<Integer> arr){
//        List<Integer> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>(arr);
//        for(int i=0;i<arr.size();i++){
//            list.set(i,arr.get(i)%2);
//        }
//        for(int i=0;i<arr.size();i++){
//            if(list.get(i)==0)
//                result.add(arr.get(i));
//        }
//        for(int i=0;i<arr.size();i++){
//            if(list.get(i)!=0)
//                result.add(arr.get(i));
//        }
//        return result;
        List<Integer> result = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (Integer integer : arr) {
            if (integer % 2 == 0) {
                even.add(integer);
            } else {
                odd.add(integer);
            }
        }

        result.addAll(even);
        result.addAll(odd);
        return result;
    }
}
