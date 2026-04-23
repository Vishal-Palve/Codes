package TCS;
import java.util.*;
public class Maths {

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
    
    
    static int allLarge(int[] nums){
        int count = 1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max ){
                max = nums[i];
                count++;
            }
           }
        return count;
    }

    static int sum(int n , int m){

        if(m == 0) return 0;

        int sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += d;
            n /= 10;
        }

        int f = sum * m;

        while(f > 9){
            int temp = 0;
            while(f > 0){
                temp += f % 10;
                f /= 10;
            }
            f = temp;
        }

        return f;
    }


    static int handshakes(int n ){
        if(n == 2){
            return 1;
        }
        return (n-1) + handshakes(n-1);
    }

    static void main() {
//        System.out.println(sumRange(0,10000));
//        System.out.println(ops(1,2,6));
//
//        int[] nums = {7,4,8,2,9};
//        System.out.println(allLarge(nums));
//
//        System.out.println(sum(99,3));

        System.out.println(handshakes(30));
    }
    }

