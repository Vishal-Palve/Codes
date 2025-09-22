package OOPs.realWorldMachineUsingAbstraction;

public class Main {
    public static void main(String[] args) {
        Machine fan = new Fan("fan");
        Machine washer = new WashingMachine("Washing Machine");

        System.out.println( fan.start());
        System.out.println(washer.start());
    }
}
