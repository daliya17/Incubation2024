package Java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeStreams {
    public static void main(String[] args) {
        Address address1 = new Address("Hyderabad");
        Address address = new Address("Banglore");
        Address address2 = new Address("Pune");
        Employee employee1 = new Employee("John", "Male", "HR", 1000L);
        Employee employee2 = new Employee("Jane", "Female", "Finance", 10000L);
        Employee employee3 = new Employee("Janet", "Female", "HR", 3000L);
        Employee employee4 = new Employee("sulu", "Female", "HR", 5000L);
        Employee employee5 = new Employee("Jase", "male", "Finance", 4000L);
        employee1.setAddressList(List.of(address1));
        employee2.setAddressList(List.of(address2));
        employee3.setAddressList(List.of(address));
        employee4.setAddressList(List.of(address1));
        employee5.setAddressList(List.of(new Address("Chennai")));
        List<Employee> employees = new ArrayList<>(List.of(employee1, employee2, employee3, employee4, employee5));


        employee1.setDepartment(new Department(1, "one"));
        employee2.setDepartment(new Department(2, "Two"));
        employee3.setDepartment(employee1.getDepartment());
        employee4.setDepartment(employee2.getDepartment());
        employee5.setDepartment(employee1.getDepartment());

        //  System.out.println(employees.stream().flatMap(e -> e.getAddressList().stream()).toList());

        Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment().getId()));
        for(Map.Entry<Integer, List<Employee>> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String s = "newString";
        System.out.println(s.chars().mapToObj(c->(char)c).collect(Collectors.counting()));
        System.out.println(Stream.of(s).mapToInt(String::length).findFirst().getAsInt());
        System.out.println(IntStream.of(s.length()).findFirst().getAsInt());
    }
}
