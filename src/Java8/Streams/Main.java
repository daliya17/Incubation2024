package Java8.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 6, 6, 7, 8, 8, 10, 1, -1, 0));
        list.stream().filter(i -> i < 7).forEach(System.out::println);
        // print secondlargest number
        Optional<Integer> secondLargest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        // without using reverse order
        Optional<Integer> secondLargest1 = list.stream().distinct().sorted().skip(list.size() - 2).findFirst();
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

        List<String> strings = new ArrayList<>(List.of("Good", "Morning"));
        String concatenatedStr = String.join("", strings);
        System.out.println(concatenatedStr);
        Map<Character, Long> frequencyMAp = concatenatedStr.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        frequencyMAp.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println(frequencyMAp.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null));
        Address address1 = new Address("address1");
        Address address2 = new Address("address2");
        Address address3 = new Address("address3");
        Address address4 = new Address("address4");
        Address address5 = new Address("address5");
        Student student1 = new Student("Naman", 1, 22, List.of(address1, address2), 1, "A", true);
        Student student2 = new Student("Kumar", 2, 23, List.of(address3, address4), 2, "A",true);
        Student student3 = new Student("Pawan", 3, 24, List.of(address5, address1), 3, "A", false);
        Student student4 = new Student("Kumari", 4, 25, List.of(address2, address3), 4, "A",false);
        Student student5 = new Student("Shawn", 5, 26, List.of(address4, address5), 2, "B", true);
        Student student6 = new Student("Kumara", 6, 27, List.of(address1, address2), 3, "B", false);
        Student student7 = new Student("Kumari", 7, 28, List.of(address3, address4), 4, "B", true);
        Student student8 = new Student("Shawnw", 8, 29, List.of(address5, address1), 2, "B", true);
        Student student9 = new Student("Kumara", 9, 30, List.of(address2, address3), 5, "A", false);
        List<Student> students = new ArrayList<>(List.of(student1, student3, student2, student4, student5, student6, student7, student8, student9));
        students.stream().filter(x -> x.getAddresses().stream().anyMatch(address -> address.getCity().equals("address1"))).forEach(System.out::println);

        // get top 3 students based on grade from each section

        Map<String, List<Student>> top3Students = students.stream()
                .collect(Collectors.groupingBy(Student::getSection, Collectors.collectingAndThen(Collectors.toList(), stu -> stu.stream().sorted(Comparator.comparing(Student::getGrade))
                        .limit(3).collect(Collectors.toList())
                )));
        // collectingAndThen is used to perform another operation on the result of the collector
        top3Students.forEach((key, value) -> System.out.println(key + " : " + value));

//        Employee employee1 = new Employee("John", "Male", "HR");
//        Employee employee2 = new Employee("Jane", "Female", "Finance");
//        Employee employee3 = new Employee("Janet", "Female", "HR");
//        Employee employee4 = new Employee("sulu", "Female", "HR");
//        Employee employee5 = new Employee("Jase", "male", "Finance");
//        List<Employee> employees = new ArrayList<>(List.of(employee1, employee2, employee3, employee4, employee5));
//
//
//        System.out.println(employees.stream().filter(x -> x.getGender().equals("Female")).collect(Collectors.groupingBy(Employee::getAccount, Collectors.counting()))
//                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(5, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4));
        List<Integer> newone = list1.stream().distinct().sorted((a, b) -> b - a).collect(Collectors.toList());
        System.out.println(newone);

        // find maximum occuring charcter in a string
        String str = "Hello World";
        Map<Character, Long> frequencyMap = str.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        List<String> strings1 = Arrays.asList("Apple", "Banana", "Avocado", "Orange", "Apricot", "Blueberry", "Almond");
        strings1.stream().filter(x -> x.length() > 5).forEach(System.out::println);
        String sentence = " Hi India bye india goodbye India welcome inDIa Hi There india bye bye IndiA";
        String[] sentences = sentence.toLowerCase().split(" ");
        Arrays.stream(sentences).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(3, 2, 1, 5, 6, 4, 7);
        // third largest number
        System.out.println(numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(null));

        List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Map<String, List<String>> wordsq = words.stream().collect(Collectors.groupingBy(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
        for (Map.Entry<String, List<String>> entry : wordsq.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        String sen = "ava test are awesome";
        System.out.println(sen.chars());

        Map<Character, Long> map1 = sen.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int k = 0; k < sen.length(); k++) {
            if (map1.get(sen.charAt(k)) == 1){
                System.out.println("First non repeating character is " + sen.charAt(k));
            break;}
        }

        students.stream().filter(st->st.isPassed())
                .collect(Collectors.toMap(Student::getId,Student::getName))
                .forEach((k,v)-> System.out.println(k+"->"+v));
    }
}