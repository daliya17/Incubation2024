package CoreJava.Immutablility;

import java.util.List;
import java.util.Collections;

public final class Course {
    private final String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}

