package Java8.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 6, 6, 7, 8, 8, 10, 1,-1,0));
        list.stream().filter(i -> i < 7).forEach(System.out::println);
        // print secondlargest number
        Optional<Integer> secondLargest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondLargest.isPresent() ? secondLargest.get() : "List is empty");

        // print max number
        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
        System.out.println(max.isPresent() ? max.get() : "List is empty");
        System.out.println(list.stream().max(Integer::compareTo).get());

        // print min number
        Optional<Integer> min = list.stream().min(Comparator.naturalOrder());
        System.out.println(list.stream().min(Integer::compareTo).get());
        System.out.println(min.get());

        // occurrence of each element
        Map<Integer, Long> occurrences = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Optional<Integer> sumOfEvenNumbers = list.stream().filter(i -> i % 2 == 0).reduce(Integer::sum);
        System.out.println(list.stream().map(i -> i % 2 == 0 ? i : 0).mapToInt(Integer::intValue).sum());
        System.out.println(sumOfEvenNumbers.isPresent() ? sumOfEvenNumbers.get() : "No even numbers present");

        Optional<Integer> i = list.stream().sorted().skip(1).findFirst();
        System.out.println(i.isPresent() ? i.get() : "No second smallest number present");

        List<String> names = new ArrayList<>(Arrays.asList("Naman", "Kumar", "Pawan", "Kumari", "Shawn", "Kumara"));
        Optional<String> s = names.stream().filter(name -> name.startsWith("K")).findFirst();
        System.out.println(s.orElse("No name starts with K"));

        // print names in uppercase
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        // group names by length
        names.stream().collect(Collectors.groupingBy(String::length)).forEach((key, value) -> System.out.println(key + " : " + value));

        // create a map with length of the name as key and name as value
        Map<Integer, List<String>> map = names.stream().collect(Collectors.groupingBy(String::length));
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}