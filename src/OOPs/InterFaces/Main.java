package OOPs.InterFaces;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.start();
//        car.stop();
//        car.acc();
//        car.brake();
//
//
//        Media carmedia = new Car();
//        carmedia.start();

        NiceCar car = new NiceCar();
        car.startengine();
        car.startMusic();
        car.upgradeengine();
        car.startengine();

    }
}
