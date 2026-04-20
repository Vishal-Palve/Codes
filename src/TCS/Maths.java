package TCS;
import java.util.*;
public class Maths {

    static{
        System.out.println("Hiii");
    }
    public static void main(String[] args) {
        System.out.println(sumRange(0,10000));
        System.out.println(ops(1,2,6));
    }

    static int sumRange(int m, int n){

        int sum = 0;

        for(int i = m ; i <= n; i++){
            sum += i;
        }
        return sum ;
    }


    public static long ops(long a, long b, long c) {
        long sum = a+b+c;
        if(sum % 3 != 0) return -1;
        long target = sum/3;
        long need = Math.max(0, target-a) + Math.max(0, target-b) + Math.max(0, target-c);
        return need/2;
    }
}
