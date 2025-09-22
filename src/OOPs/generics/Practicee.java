package OOPs.generics;

public class Practicee {
    public static void main(String[] args) {
        Thread obj1 = new A();
        Thread obj2 = new B();

        obj2.start();
        obj1.start();
    }
}


class A extends Thread{
    public void run(){
        for (int i = 0; i < 100 ; i++) {
            System.out.println("hii");
            try {
            Thread.sleep(10);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

class B extends Thread{
    public void run(){

        try{
            for (int i = 0; i <100 ; i++) {
                System.out.println("heyy");
            }

        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}