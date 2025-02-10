package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams6 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("daliya", "daliya",
                "naman", "naman"));
        names.add(null);
        names.stream().collect(Collectors.groupingBy(name -> name == null ? "null" : name, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "->" + v));
    }
}
