package Java8;

import Java8.Streams.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams4 {
    public static void main(String[] args) {
        List<String> list = List.of("My name is Khan", "I work in London", "I am a Java Developer", "I have 5 years of experience");
        // split sentences into words and collect into a set
        // System.out.println(list.stream().flatMap(s-> Arrays.stream(s.split(""))).collect(Collectors.toSet()));

        System.out.println(list.stream().flatMap(l -> Arrays.stream(l.split(" "))).collect(Collectors.toList()));
// reduce to product
        List<Integer> integers = List.of(3, 4, 5, 6, 1, 2);
        System.out.println(integers.stream().reduce(1, (a, b) -> a * b));

        List<String> strings = List.of("name", "place", "animal", "length", "pain");
        Map<Integer, Long> map = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + " " + v));

        List<Integer> integers1 = List.of(34, 6, 7, 8, 9, 0);
        // custom collector to a tree set
        System.out.println(integers1.stream().collect(Collectors.toCollection(() -> new java.util.TreeSet<>())));
        Employee employee1 = new Employee("John", "Male", "HR", 90000L);
        Employee employee2 = new Employee("Jane", "Female", "Finance", 70000L);
        Employee employee3 = new Employee("Janet", "Female", "HR", 10000L);
        Employee employee4 = new Employee("sulu", "Female", "HR", 60000L);
        Employee employee5 = new Employee("Jase", "male", "Finance", 40000L);
        List<Employee> employees = new ArrayList<>(List.of(employee1, employee2, employee3, employee4, employee5));
        employees.stream().filter(e -> e.getSalary() > 50000).sorted(Comparator.comparing(e -> e.getName())).forEach(x-> System.out.println(x.getName()));

        // non reapeatinmg chararcter
        String s = "My name is khan, I am fond of chocloates";
      String  ch=  Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
               .findFirst().orElse(null);
        System.out.println(ch);

//       s.chars().mapToObj(c->(char)c)
//               .filter(c->c!=' ')
//               .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
//               .entrySet().stream().filter(e->e.getValue()==1)
//               .map(Map.Entry::getKey)
//               .findFirst().orElse(null);
        
   // integer array
        int[] arr = {2,3,6,7,8};
         IntStream.of(arr).filter(x->x%2==0).forEach(System.out::println);
         Arrays.stream(arr).filter(x->x%2==0).forEach(System.out::println);


        List<String> stringList = List.of("dr apj abdul kalam",
                "pratibha patil",
                "pranab mukherjee",
                "ram nath kovind",
                "droupadi murmu");

        stringList.stream()
                .flatMapToInt(l->l.chars())
                .mapToObj(c->(char)c)
                .filter(cn->cn!=' ')
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+" "+v));
    }
}
