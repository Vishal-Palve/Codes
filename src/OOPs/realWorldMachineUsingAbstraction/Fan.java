package OOPs.realWorldMachineUsingAbstraction;



public class Fan extends Appliance {

    Fan(String name ){
        super(name);
    }


    @Override
    public String start(){
        return "Fan is running";
    }
}
