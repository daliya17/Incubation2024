package Java8.Lamda;

public class Main {
    // lamda expression is used to provide the implementation of an interface which has functional interface.
    // lamdas are anonymous functions
    // easier to write and understand
    public static void main(String[] args) {
        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name);
            }
        };
        gm.greet("Naman Kumar");
        // using lamda expression
        GreetingMessage gm2 = (name)->{
            System.out.println("Hello " + name);
        };
        gm2.greet("Naman Kumar");
    }
}


// java 8 new features
// 1. Lamda Expression
// 2. Functional Interface
// 3. Default Method
// 4. Static Method, here we can define static method in interface
// 5. Predicate, Function, Consumer, Supplier- these are functional interfaces, predicate takes input and returns boolean,
// function takes input and returns output, consumer takes input and returns nothing,
// supplier takes nothing and returns output
// 6. Method Reference
// 7. Stream API
// 8. Optional
// 9. Date Time API, java.time package is used to deal with date and time, example: LocalDate, LocalTime, LocalDateTime, ZonedDateTime, OffsetDateTime, OffsetTime, etc.
// 10. Nashorn JavaScript Engine, it is a lightweight, high-performance JavaScript runtime environment, it is used to execute javascript code from java application
// 11. Base64, java 8 has added a class Base64 which provides static methods to encode and decode the Base64 encoded string
// 12. Parallel Array Sorting, java 8 has added a new method parallelSort() in the Arrays class which uses the Fork/Join framework to provide sorting of arrays in parallel
// 13. Type and Repating Annotations, java 8 has added two new concepts, type annotations and repeating annotations, type annotations are used to apply annotations to types,
//    repeating annotations are used to apply the same annotation multiple times to a single declaration or type use, this is useful when we want to apply the same annotation multiple times.
//    like @Author("Naman"), @Author("Kumar")
