package ProblemSolving.Strings;

import java.util.HashMap;

public class MinWindowOfAnotherString {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String A, String B){
        HashMap<Character, Integer> map = new HashMap();
        for(char c : B.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return "";
        // min window lengt
    }
}
