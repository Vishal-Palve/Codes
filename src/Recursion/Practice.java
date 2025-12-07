package Recursion;

import java.util.List;

public class Practice {
    public static void main(String[] args) {
        System.out.println(rev(342));
    }

//    public static List<List<Integer>> subSet(int[] arr){
//
//    }

    public static int rev(int n){
        int rev = 0;
        while(n > 0){
            int d = n%10;
            rev = d + rev * 10;
            n = n/10;
        }
        return rev;
    }


}
