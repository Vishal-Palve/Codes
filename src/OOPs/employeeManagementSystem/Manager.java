package OOPs.employeeManagementSystem;

public class Manager extends Employee{
   private String department;
    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;

    }
    @Override
    public void getdetails(){
        super.getdetails();
        System.out.println("department: " + department);
    }
}

