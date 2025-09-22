package OOPs.realWorldMachineUsingAbstraction;

public class WashingMachine extends Appliance {

    WashingMachine(String name) {
        super(name);
    }

    @Override
    public String start() {
        return "Washing Machine is operating";
    }
}
