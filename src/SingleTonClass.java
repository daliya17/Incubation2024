public class SingleTonClass {
    private static SingleTonClass instance = null;

    private SingleTonClass() {

    }

    public static SingleTonClass getInstance() {
        if (instance == null) {
            instance = new SingleTonClass();
        }
        return instance;
    }
}

//employee
//salary
//
//select salary from Employees
//order by salary desc
//offset 1 limit 1

