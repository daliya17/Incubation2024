package CoreJava.Immutablility;

import java.util.List;
import CoreJava.Immutablility.Course;

public class Main {
    public static void main(String[] args) {
        // Creating an immutable object
        Person person = new Person("Alice", 30);

        // Accessing immutable fields via getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());


        // Creating Course objects
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        // Creating an immutable list of courses
        List<Course> courses = List.of(course1, course2);

        // Creating a Student object
        Student student = new Student("John Doe", 123, courses);

        // Accessing immutable fields
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getId());

        // Accessing the list of courses (it is unmodifiable)
        for (Course course : student.getCourses()) {
            System.out.println("Enrolled in: " + course.getCourseName());
        }

        // Attempting to modify the courses list will throw an exception
        // student.getCourses().add(new Course("Chemistry")); // Throws UnsupportedOperationException
    }
}
