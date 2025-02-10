package Java8.Streams2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // anyMatch() method
        List<Integer> list = List.of(1, 2, 23, 4, 5, 4, 6, 45, 64, 37, 8, 89);
        System.out.println(list.stream().anyMatch(i -> i > 80));

        // remove duplicates
        List<Integer> newList = list.stream().distinct().toList();
        newList.forEach(System.out::println);

        // print squares of odd numbers
        List<Integer> squaresOfOddNumbers = list.stream().filter(i -> i % 2 != 0).map(i -> i * i).toList();
        squaresOfOddNumbers.forEach(System.out::println);

        Optional<Integer> avg = list.stream()
                .reduce(Integer::sum).map(s -> s / list.size());
        System.out.println(avg.orElse(0));

        // concatenate all names, separated by space
        List<String> names = List.of("Naman", "Kum", "Pawan", "Kumariy", "Shawne", "Kumaraef");
        Optional<String> s = names.stream().reduce((s1, s2) -> s1 + " " + s2);
        System.out.println(s.orElse("No names present"));

        // sort the list based on length of the names
        names.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        // find longest name
        Optional<String> longestName = names.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longestName.orElse("No names present"));

        // largest number divisible by 3
        Optional<Integer> largestNumberDivisibleBy3 = list.stream().filter(i -> i % 3 == 0).max(Comparator.naturalOrder());
        System.out.println(largestNumberDivisibleBy3.orElse(0));

        // convert a list of integers to a set
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);

        // check if all numbers are positive
        System.out.println(list.stream().allMatch(i -> i > 0));

        // print sum of all numbers greater than 10
        System.out.println(list.stream().filter(i -> i > 10).reduce(Integer::sum).orElse(0));

        // sort list of strings based on alphabetical order
        List<String> sortedNames = names.stream().sorted(Comparator.reverseOrder()).toList();
        sortedNames.forEach(System.out::println);

        // print names starting with K
        names.stream().filter(name -> name.startsWith("K")).forEach(System.out::println);
        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.print(s1 == s2);
        System.out.print(s1.equals(s2));

    }
}
