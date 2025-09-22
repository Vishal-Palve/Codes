package OOPs.abstractdemo;

public class Son extends Parent{

    public Son(int age) {
        super(age);
    }

    @Override
     void career(String name) {
        System.out.println("I am going to be a doctor");
    }
    @Override
    void partner(String name, int age) {
        System.out.println("I Love " + name + " she is " + age);
    }

    @Override
    void normal() {
        super.normal();
    }
}
