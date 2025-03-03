package Interviews;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        charCount(List.of("abc", "asd", "ass"));
    }

    public static void charCount(List<String> list) {
        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).length(); j++) {
//                if (!map.containsKey(list.get(i).charAt(j)))
//                    map.put(list.get(i).charAt(j), 1);
//                else
//                    map.computeIfPresent(list.get(i).charAt(j), (k, v) -> v + 1);
//            }
//        }
//        map.forEach((k, v) -> System.out.println(k + "=" + v));
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i));
        }
        s.toString().chars().mapToObj(c -> (char) c).filter(x->x!='a').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "=" + v));

    }
}
