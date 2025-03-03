package Java8.Streams;

import lombok.Data;

import java.util.List;

@Data
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
    public Long getSalary(){
        return salary;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String name;
    private String gender;
    private String account;

    private List<Address> addressList;

    private Department department;

    private Long salary;

    public Employee(String name, String gender, String account,Long salary) {
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.salary = salary;
    }

}
