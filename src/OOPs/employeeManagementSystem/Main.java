package OOPs.employeeManagementSystem;


public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Vishal", 50000);
        e.getdetails();

        Manager m = new Manager("Rudrani", 775000, "IT");
        m.getdetails();
    }
}
