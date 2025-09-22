package OOPs.generics;

public class Prac2 {
    public static void main(String[] args) {
        Runnable obj = () -> {for (int i = 0; i < 100 ; i++) {
            System.out.println("hii");
            try {
                Thread.sleep(10);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        };
        Runnable obj1 =  () -> {for (int i = 0; i < 100 ; i++) {
            System.out.println("heyyy");
            try {
                Thread.sleep(10);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        };

        Thread a = new Thread(obj);
        Thread b = new Thread(obj1);
        a.start();
        b.start();
    }



}
class C implements Runnable{
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

class D implements Runnable{
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

 