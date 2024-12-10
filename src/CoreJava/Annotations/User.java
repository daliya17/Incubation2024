package CoreJava.Annotations;


@Entity(tableName = "users")
public class User {

    @FieldInfo(description = "This is the name of the user", author = "John Doe")
    private String name;

    @FieldInfo(description = "This is the age of the user", author = "Jane Doe")
    private int age;

    private String address;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Tracked // Track execution of this method
    public void setName(String name) {
        this.name = name;
    }
}
