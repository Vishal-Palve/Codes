package OOPs.abstractdemo;

public abstract class Parent {
    int age;

    public Parent(int age){
        this.age = age;

    }

    void normal(){
        System.out.println("this is a normal method!");
    }

    static void hello(){
        System.out.println("hey");
    }
    abstract void career(String name);
    abstract void partner(String name, int age);
}
