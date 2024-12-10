package CoreJava.Immutablility;

public class DeepCopyExample {
    public static void main(String[] args) {
        CompanyDeepCopy company = new CompanyDeepCopy("XYZ");
        company.addEmployee(new Employee(1, "John"));
        company.addEmployee(new Employee(2, "David"));

        CompanyDeepCopy clonedCompany = company.deepCopy();
        clonedCompany.addEmployee(new Employee(3, "Mike"));
        System.out.println(company==clonedCompany);
        System.out.println(company.equals(clonedCompany));

        System.out.println("Company: " + company);
        System.out.println("Cloned Company: " + clonedCompany);
        System.out.println("Company Employees: " + company.getEmployees());
        System.out.println("Cloned Company Employees: " + clonedCompany.getEmployees());
    }
}
