package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        String s = "ab   ab  a";
        System.out.println(isPalindrome(s));
    }



    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static int cog2(int h) {

        int sum = 0;
        while(h>0){
            sum += h * (h+1)  - 1;
            h = h-1;
        }
        return sum;
    }
    public static void cog1(){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        System.out.println("Ship capacity: " + c);
        int n = sc.nextInt();
        System.out.println("Total People: " + n);
        int count  = 0;
        while(n > 0){
            n = n-c;
            count ++;
        }
        System.out.println(count);
    }

    public static int cog3(int[] arr){

        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
