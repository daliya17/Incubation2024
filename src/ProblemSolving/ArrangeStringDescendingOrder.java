package ProblemSolving;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrangeStringDescendingOrder {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(arrangeString(str));
    }

    public static String arrangeString(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Sorting the map in descending order of values and then by keys

        Map<Character,Integer> temp = map.entrySet().stream().sorted((e1,e2)->{
            if(e1.getValue().equals(e2.getValue())){
                return e1.getKey()-e2.getKey();
            }
            return e2.getValue()-e1.getValue();
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));
        System.out.println(temp);
// explain the above code
//       Map<Character, Integer> temp = map.entrySet().stream() // get the stream of entries
//                .sorted((e1, e2) -> { // sort the entries
//                    if (e1.getValue().equals(e2.getValue())) { // if the values are equal
//                        return e1.getKey() - e2.getKey(); // sort by keys by ascending order
//                    }
//                    return e2.getValue() - e1.getValue(); // sort by values by descending order
//                })
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)); // collect the sorted entries to a map

        for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}


