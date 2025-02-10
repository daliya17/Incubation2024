package Java8;

import java.util.*;
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

        List<Integer> numbers2 = List.of(1, 2, -1,-2);
        List<Integer> result = numbers2.stream().map(x->(x*x)).distinct().toList();
        result.forEach(System.out::println);
        List<String> employees = List.of("Daliya Johnson", "Ashish agarwal", "Naman Kumar", "Nehul deepak");
        List<String> sortedEmployees = employees.stream().sorted((e1,e2)->{
            String[] emp1 = e1.split(" ");
            String[] emp2 = e2.split(" ");
            return emp1[1].toLowerCase().compareTo(emp2[1].toLowerCase());
        }).toList();
        List<String> sortedEmployee = employees.stream().sorted(Comparator.comparing(name -> name.split(" ")[1].toLowerCase())).toList();
        sortedEmployees.forEach(System.out::println);
        List<String> stringList = List.of("dr apj abdul kalam",
                "pratibha patil",
                "pranab mukherjee",
                "ram nath kovind",
                "droupadi murmu");
        Map<Character, Long> map = stringList.stream()
                .flatMapToInt(str -> str.chars())
                .mapToObj(ch->(char)ch)
                .filter(ch->ch!=' ')
                .collect(Collectors.groupingBy(ch->ch, Collectors.counting()));
        map.forEach((k,v)-> System.out.println(k+"->"+v));

        List<Integer> newlist = new ArrayList<>(List.of(1,2,3,4));
        List<Integer> list1 = newlist.stream().toList();
        List<Integer> list2 = list1.stream().map(x->(x+2)).toList();
        list2.forEach(System.out::println);

        List<String> list = List.of("apple","banana","apricot","blueberry");
        list.stream().collect(Collectors.groupingBy(w->w.charAt(0),Collectors.counting())).forEach((k,v)-> System.out.println(k+"->"+v));
    }
}
