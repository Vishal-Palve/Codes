package TCS;
import java.util.*;
public class Maths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n = sc.nextInt();
        double ans = 0;
        if(n < 1000) {
            double d = n * 0.05;
        ans = n - d;
        }
        else if( n < 5000){
            double d = n * 0.10;
            ans = n - d;
        }

        else{
            double d = n * 0.15;
            ans = n - d;
        }
        System.out.println(ans);
        System.out.printf("%.2f", ans);
    }
}
