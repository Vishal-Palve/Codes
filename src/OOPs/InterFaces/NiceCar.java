package OOPs.InterFaces;

public class NiceCar  {
    private Engine engine;
    private Media player = new CdPlayer();

    public NiceCar(){
        engine = new CarEngine();
    }

    public NiceCar(Engine engine){
        this.engine = engine;
    }

    public void startMusic(){
        player.start();
    }

    public void stopMusic(){
        player.stop();
    }

    public void stopEngine(){
        engine.stop();
    }
    public void startEngine(){
        engine.start();
    }
    public void upgradeEngine(){
        this.engine = new ElectricEngine();
    }
}
