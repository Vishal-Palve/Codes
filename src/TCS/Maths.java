package TCS;
import java.util.*;
public class Maths {

    static{
        System.out.println("Hiii");
    }
    public static void main(String[] args) {
        System.out.println(sumRange(0,10000));
    }

    static int sumRange(int m, int n){

        int sum = 0;

        for(int i = m ; i <= n; i++){
            sum += i;
        }
        return sum ;
    }

}
