package OOPs.InterFaces;

public class ElectricEngine implements Engine{

    @Override
    public void start() {
        System.out.println("electric Car Engine start ");
    }

    @Override
    public void stop() {

        System.out.println(" electric Car Engine stop ");
    }

    @Override
    public void acc() {
        System.out.println(" electric Car Engine acc ");
    }
}
