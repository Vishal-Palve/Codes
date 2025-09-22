package OOPs.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreanEx {
    public static void main(String[] args) {
        int size = 10000;
        List<Integer> nums = new ArrayList<>(size);
        Random n = new Random();
        for (int i = 1; i <= size; i++) {
            nums.add(n.nextInt(100));

        }

        int sum1 = nums.stream()
                .map(i -> i*2)
                .reduce(0, (c, e) -> c+e);
  long startseq = System.currentTimeMillis();
        int sum2 = nums.stream()
                .map(i -> {
                    try{
                        Thread.sleep(2);

                    }catch (Exception e){

                    }
                    return i*2;
                })
                .mapToInt(i->i)
                .sum();
        long endseq = System.currentTimeMillis();


        long startpara = System.currentTimeMillis();
         int sum3 =nums.parallelStream()
                         .map(i -> i * 2)
                                 .mapToInt(i -> i)
                                         .sum();
        long endpara = System.currentTimeMillis();


        System.out.println( sum2 + " " + sum3 );
        System.out.println("Seq : " + ( endseq - startseq ));
        System.out.println("Para :  " + ( endpara - startpara ));


    }
}
