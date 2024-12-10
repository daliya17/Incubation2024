package CoreJava.Immutablility;

import java.util.Collections;
import java.util.List;

public final class Student {
    private final String name;
    private final int id;
    private final List<Course> courses;

    public Student(String name, int id, List<Course> courses) {
        this.name = name;
        this.id = id;

        // Make a defensive copy of the list to prevent external modification
        this.courses = Collections.unmodifiableList(courses);
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        // Return an unmodifiable view of the list (prevents modification)
        return courses;
    }
}
