package Java8;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Streams3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 5, 10, 2, 3, 6, 7, 8, 9);
        Optional<Integer> sum = numbers.stream()
                .distinct().sorted((a,b)->b-a).collect(Collectors.toList()).stream().skip(1).findFirst();
        System.out.println(sum.orElse(0));

        AtomicInteger counter = new AtomicInteger(0);
        numbers.stream().forEach(n -> {
            counter.incrementAndGet();  // Increment the counter each time forEach is executed
            System.out.println(counter);
        });

        List<String> names = List.of("Naman", "Kumar", "Naman Kumar", "Naman Kumar");
        StringBuilder sb = new StringBuilder();
        names.stream().forEach(name -> {
            sb.append(name).append(" ");
            System.out.println(sb.toString());
        });
    }
}
