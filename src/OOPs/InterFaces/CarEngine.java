package OOPs.InterFaces;

public class CarEngine implements Engine{
    @Override
    public void start() {
        System.out.println(" Car Engine start ");
    }

    @Override
    public void stop() {
        System.out.println(" Car Engine stop ");
    }

    @Override
    public void acc() {
        System.out.println(" Car Engine acc ");
    }
}
