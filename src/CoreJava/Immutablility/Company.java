package CoreJava.Immutablility;

import java.util.List;

public class Company implements Cloneable {
    String companyName;

    List<Employee> employees;

    public Company(String companyName, List<Employee> employees) {
        this.companyName = companyName;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Company clone() throws CloneNotSupportedException {
            Company clone = (Company) super.clone();
            return clone;
    }
}
