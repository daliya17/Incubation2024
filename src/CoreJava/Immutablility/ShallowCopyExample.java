package CoreJava.Immutablility;

import java.util.List;

public class ShallowCopyExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee(1, "John");
        Employee emp2 = new Employee(2, "Jane");

        Company company = new Company("XYZ", List.of(emp1, emp2));
        Company company1 = company.clone();
        Company company2 = company;
        System.out.println(company==company1);
        System.out.println(company==company2);
        System.out.println(company.hashCode()==company2.hashCode());
        // modifying the original list
        company1.employees.get(1).setName("Janet");
        System.out.println("Original Company: " + company);
        System.out.println("Original Employee: " + company.employees.get(1));
        System.out.println("Cloned Company: " + company1);
        System.out.println("Cloned Employee: " + company1.employees.get(1));
    }
}
