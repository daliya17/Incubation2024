package Java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Streams5 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Apple", 1.0, "Fruit"));
        productList.add(new Product(2, "Orange", 2.0, "Fruit"));
        productList.add(new Product(3, "Banana", 3.0, "Fruit"));
        productList.add(new Product(4, "Carrot", 4.0, "Vegetable"));
        productList.add(new Product(5, "Potato", 5.0, "Vegetable"));
        productList.add(new Product(6, "Onion", 6.0, "Vegetable"));
        productList.add(new Product(7, "Tomato", 7.0, "Vegetable"));
        productList.add(new Product(8, "Cabbage", 8.0, "Vegetable"));
        productList.add(new Product(9, "mobile", 9.0, "electronics"));
        productList.add(new Product(10, "laptop", 10.0, "electronics"));

        productList.stream().collect(Collectors.groupingBy(p -> p.category, Collectors.maxBy(Comparator.comparingDouble(p -> p.price))))
                .forEach((k, v) -> System.out.println(k + "->" + v));

        List<Order> orders = new ArrayList<>();
        // todyas date using java.util.Date
        Date date = new Date();
        // yesterday date using java.sql.Date
        // java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-24*60*60*1000);

        orders.add(new Order(1, "Order1", 1, LocalDate.now(), productList.subList(0, 3)));
        orders.add(new Order(2, "Order2", 2, LocalDate.now().minusDays(1), productList.subList(3, 7)));
        orders.add(new Order(3, "Order3", 3, LocalDate.now().minusDays(2), productList.subList(7, 10)));
        orders.add(new Order(4, "Order4", 4, LocalDate.now().minusDays(8), productList.subList(0, 3)));
        orders.add(new Order(5, "Order5", 5, LocalDate.now().minusDays(6), productList.subList(3, 7)));
        // get avg price of orders placed on today
        orders.stream().filter(o -> o.orderDate.equals(LocalDate.now()))
                .flatMapToDouble(o -> o.products.stream().mapToDouble(p -> p.price).average().stream())
                .forEach(System.out::println);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(25, "John", List.of("Project1", "Project2", "Project3", "Project4")));
        employees.add(new Employee(30, "Doe", List.of("Project3", "Project4", "Project5", "Project6")));
        employees.add(new Employee(35, "Jane", List.of("Project5", "Project6")));
        employees.add(new Employee(40, "Smith", List.of("Project7", "Project8")));
        employees.add(new Employee(45, "Doe", List.of("Project9", "Project10", "Project11", "Project12")));
        // get average age of employees who are working on more than 3 projects
        System.out.println(employees.stream().filter(e -> e.projects.size() > 3).mapToInt(e -> e.age).average().orElse(0.0));

        // get sum of prices of orders placed in last 7 days
        orders.stream().filter(o -> o.orderDate.isAfter(LocalDate.now().minusDays(6)))
                .flatMapToDouble(o -> DoubleStream.of(o.products.stream().mapToDouble(p -> p.price).sum()))
                .forEach(System.out::println);

        // get second highest even number from the list of lists
        List<List<Integer>> list = List.of(List.of(6, 2, 4), List.of(3, 5, 1), List.of(7, 8, 9));

        System.out.println(list.stream().flatMap(l -> l.stream()).filter(x -> x % 2 == 0).sorted((a, b) -> b - a).skip(1).max(Comparator.naturalOrder()));

        HashMap<Department, List<Employee>> map = new HashMap<>();
        map.put(new Department(), employees.subList(0, 3));
        map.put(new Department(), employees.subList(2, 4));
        map.put(new Department(), employees.subList(3, 5));
        map.entrySet().stream().collect(Collectors.groupingBy(e -> e.getKey(), Collectors.averagingDouble(e -> e.getValue()
                        .stream().mapToInt(em -> em.getAge()).average().orElse(0.0))))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 100, TransactionType.TRANSACTION_TYPE_CREDIT, "INPROGRESS"));
        transactions.add(new Transaction(2, 200, TransactionType.TRANSACTION_TYPE_DEBIT, "COMPLETED"));
        transactions.add(new Transaction(3, 300, TransactionType.TRANSACTION_TYPE_TRANSFER, "STARTED"));
        transactions.add(new Transaction(4, 400, TransactionType.TRANSACTION_TYPE_CREDIT, "COMPLETED"));
        transactions.add(new Transaction(5, 500, TransactionType.TRANSACTION_TYPE_DEBIT, "INPROGRESS"));
        transactions.add(new Transaction(6, 600, TransactionType.TRANSACTION_TYPE_CREDIT, "STARTED"));
        transactions.add(new Transaction(7, 700, TransactionType.TRANSACTION_TYPE_DEBIT, "COMPLETED"));

        transactions.stream().filter(t -> t.status.equals("COMPLETED")).collect(Collectors.groupingBy(t -> t.transactionType
                        , Collectors.summingInt(t -> t.getAmount())))
                .forEach((k, v) -> System.out.println(k + "->" + v));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", List.of(1, 12, 3, 4, 5)));
        books.add(new Book("Book2", "Author2", List.of(6, 7, 18, 59, 10)));
        books.add(new Book("Book3", "Author3", List.of(11, 12, 13, 14, 15)));

        System.out.println(books.stream().mapToDouble(b -> b.ratings.stream().collect(Collectors.averagingInt(r -> r))).max());

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1,"Math",2.0));
        subjects.add(new Subject(2,"Science",3.0));
        subjects.add(new Subject(3,"English",4.0));
        subjects.add(new Subject(4,"History",5.0));
        subjects.add(new Subject(5,"Geography",6.0));
        subjects.add(new Subject(6,"Hindi",7.0));
        subjects.add(new Subject(7,"Marathi",8.0));
        subjects.add(new Subject(8,"Sanskrit",9.0));
        subjects.add(new Subject(9,"Biology",10.0));
        subjects.add(new Subject(10,"Physics",11.0));
        subjects.add(new Subject(11,"Chemistry",12.0));
        subjects.add(new Subject(12,"Computer",13.0));
        subjects.add(new Subject(13,"Economics",14.0));
        subjects.add(new Subject(14,"Accounts",15.0));
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"John",25,subjects.subList(0,3)));
        students.add(new Student(2,"Doe",30,subjects.subList(3,6)));
        students.add(new Student(3,"Jane",35,subjects.subList(6,9)));
        students.add(new Student(4,"Smith",40,subjects.subList(9,12)));
        students.add(new Student(5,"Doe",45,subjects.subList(12,14)));

        students.stream().mapToDouble(st->st.subjects.stream().collect(Collectors.averagingDouble(s->s.grade)))
                .limit(3).forEach(System.out::println);
//      Map<String,Double> map1=   students.stream().collect(Collectors.toMap(s->s.getName(),st->st.subjects.stream().mapToDouble(Subject::getGrade).average().orElse(0.0)))
//                .entrySet().stream()
//                .sorted((e1,e2)->Double.compare(e1.getValue(),e2.getValue()))
//                .limit(3);

    }
}
