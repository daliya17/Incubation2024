package Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MatchingAnagrams {
    public static void main(String[] args) {
        System.out.println(anagrams("cbaebabacd", "abc"));
        System.out.println(anagrams("abab", "ab"));
        System.out.println(anagrams("abc", "ab"));
        System.out.println(anagrams("abc", "abc"));
        System.out.println(anagrams("abcdejg", "hj"));
        System.out.println(anagrams("aaabaaa", "aaa"));
        System.out.println(anagrams("aaaa", "a"));
        System.out.println(anagrams("xyzabc", "cba"));
        System.out.println(anagrams("abcd", "abcdf"));
        System.out.println(anagrams("abababab", "ab"));
    }

    public static List<Integer> anagrams(String s, String p) {
        if(s.length()<p.length())
            return new ArrayList<>();
        int match = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (!map.containsKey(p.charAt(i)))
                map.put(p.charAt(i), 1);
            else
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
        }
        HashMap<Character, Integer> s_map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            if (s_map.containsKey(s.charAt(i))) {
                s_map.put(s.charAt(i), s_map.get(s.charAt(i)) + 1);
            } else
                s_map.put(s.charAt(i), 1);
            if (map.containsKey(s.charAt(i))) {
                if (Objects.equals(s_map.get(s.charAt(i)), map.get(s.charAt(i))))
                    match++;
                else
                {
                    if(match>0)
                        match--;
                }
            }
        }
        if (s_map.size() == map.size() && match == map.size())
            ans.add(start);
        int n = p.length();
        for (int i = n; i < s.length(); i++) {
            s_map.put(s.charAt(i - n), s_map.get(s.charAt(i - n)) - 1);
            if (map.containsKey(s.charAt(i - n))) {
                if (Objects.equals(s_map.get(s.charAt(i - n)), map.get(s.charAt(i - n))))
                    match++;
                else
                    match--;
            }
            if (!s_map.containsKey(s.charAt(i)))
                s_map.put(s.charAt(i), 1);
            else
                s_map.put(s.charAt(i), s_map.get(s.charAt(i)) + 1);

            if (map.containsKey(s.charAt(i))) {
                if (Objects.equals(s_map.get(s.charAt(i)), map.get(s.charAt(i))))
                    match++;
                else
                    match--;
            }
            if (match == map.size())
                ans.add(i - n + 1);
        }
//        for (int i = 0; i < p.length(); i++) {
//            if (!map.containsKey(p.charAt(i)))
//                map.put(p.charAt(i), 1);
//            else {
//                int val = map.get(p.charAt(i)) + 1;
//                map.put(p.charAt(i), val);
//            }
//        }
//        int startIndex = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != 0) {
//                if (startIndex == -1)
//                    startIndex = i;
//                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//                if (i - startIndex + 1 == p.length()) {
//                    ans.add(startIndex);
//                    for(int j=0;j<p.length();j++){
//                        if(map.containsKey(p.charAt(j)) && map.get(p.charAt(j))==0){
//                            map.put(p.charAt(j), map.get(p.charAt(j))+1);
//                        }
//                    }
//                }
//            } else {
//                startIndex = startIndex+1;
//            }
//
//        }
        return ans;
    }
}

//

//        ["1","1","1","1","0"],
//        ["1","1","0","1","1"],
//        ["1","1","0","0","1"],
//        ["0","0","0","0","1"]
//        ]

//s = "cbaebabacd", p = "abc"

//cba, bac-

//a-1
//b-1
//c-1
//
//startindex=0
//i=0, c=0,
//i=1, b=0
//i=2, a=0
//
//ans=0
//
//a=1,b=1,c=1
//i=3
//
//startIndex = 4
//        i=4,b=0
//i=5,a=0,
//i=6,
//startindex = 5
//
//i=7
//startindex = 6
//
//i=8 c=0


