package Java8;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    public String title;
    public String author;
    public List<Integer> ratings;

    public Book(String title, String author, List<Integer> ratings) {
        this.title = title;
        this.author = author;
        this.ratings = ratings;
    }

}
