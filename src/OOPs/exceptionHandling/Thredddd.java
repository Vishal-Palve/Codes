package OOPs.exceptionHandling;

public class Thredddd {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
//        System.out.println(obj1.getPriority());
//        obj2.setPriority(Thread.MAX_PRIORITY);
        obj1.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj2.start();  
    }
}


class A extends Thread{

    public void run(){
        for (int i = 0; i <= 100 ; i++) {
            System.out.println("hiii");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread{

    public void run(){
        for (int i = 0; i <= 100   ; i++) {
            System.out.println("helloo");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}