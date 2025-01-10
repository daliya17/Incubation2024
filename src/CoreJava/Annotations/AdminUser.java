package CoreJava.Annotations;

import lombok.Getter;

@Getter
@InheritedAnnotation()
public class AdminUser extends User{

    private String role;

    public AdminUser(String name, int age, String address, String role) {
        super(name, age, address);
        this.role = role;
    }
}


