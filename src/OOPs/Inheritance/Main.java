package OOPs.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(12 , 45 ,4);
        Box box2 = new Box(box1);
        System.out.println(box1.l + " " + box2.l);
        box1.l = 7;
        System.out.println(box1.l);
        System.out.println(box2.l);


        BoxWeight boxweight = new BoxWeight(12, 122, 45, 23);
        System.out.println(boxweight.h);


        BoxPrice box7 = new BoxPrice(12, 54, 62, 3, 4568);
        System.out.println(box7.l);


        Box box8 = new BoxPrice(12, 54, 62, 3, 4568);
        System.out.println(box8.h);
    }
}
