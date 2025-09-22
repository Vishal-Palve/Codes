package OOPs.employeeManagementSystem;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;

    }

    public Employee() {

    }


    public void  getdetails(){
        System.out.println("name: " + name);
        System.out.println("salary: " + salary);
    }

}
