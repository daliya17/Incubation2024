import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem {
    public static void main(String[] args) {
        System.out.println(anagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> anagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if (!map.containsKey(p.charAt(i)))
                map.put(p.charAt(i), 1);
            else {
                int val = map.get(p.charAt(i)) + 1;
                map.put(p.charAt(i), val);
            }
        }
        int startIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != 0) {
                if (startIndex == -1)
                    startIndex = i;
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (i - startIndex + 1 == p.length()) {
                    ans.add(startIndex);
                    for(int j=0;j<p.length();j++){
                        if(map.containsKey(p.charAt(j)) && map.get(p.charAt(j))==0){
                            map.put(p.charAt(j), map.get(p.charAt(j))+1);
                        }
                    }
                }
            } else {
                startIndex = startIndex+1;
            }

        }
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


