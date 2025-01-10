package Java8.Streams;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String name;
    private String gender;
    private String account;

    public Employee(String name, String gender, String account) {
        this.name = name;
        this.gender = gender;
        this.account = account;
    }

}
