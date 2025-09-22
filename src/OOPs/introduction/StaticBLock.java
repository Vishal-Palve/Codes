package OOPs.introduction;

public class StaticBLock {
    static int a = 4;
    static int b ;
    static {
        System.out.println("I am in static block ");
        b = a*5;
        a = b /2;
    }

    public static void main(String[] args) {
        StaticBLock obj = new StaticBLock();
        System.out.println(StaticBLock.a  + " " + StaticBLock.b);
        StaticBLock.b +=5;

        System.out.println(StaticBLock.b);
    }
}
