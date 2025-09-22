package OOPs.generics;


class Counter {
    int count = 0 ;
    public synchronized void increment(){
        count++;
    }
}

public class Sync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable a = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();

            }

        };

        Runnable b = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();

            }

        };
        Thread e = new Thread(a);
        Thread d= new Thread(b);
        e.start();
        d.start();
        e.join();
        d.join();

        System.out.println("Final count: " + c.count);

    }
}


