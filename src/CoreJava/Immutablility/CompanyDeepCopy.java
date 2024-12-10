package CoreJava.Immutablility;

import java.util.ArrayList;
import java.util.List;

public class CompanyDeepCopy {
    private String companyName;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public CompanyDeepCopy(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public CompanyDeepCopy deepCopy(){
        CompanyDeepCopy cloned= new CompanyDeepCopy(this.companyName);
        for(Employee employee: this.employees){
            cloned.employees.add(new Employee(employee.getId(), employee.getName()));
        }
        return cloned;
    }
}
