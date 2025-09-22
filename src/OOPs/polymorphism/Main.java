package OOPs.polymorphism;

public class Main {


    public static void main(String[] args) {
        Shapes shape = new Shapes();
       Circle circle = new Circle();
        Square square = new Square();
        Shapes xt = new Circle();

        xt.area();
        circle.area();

    }

}
