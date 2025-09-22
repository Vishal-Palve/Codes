package Recursion;

public class IterativeApproaches {
    public static void main(String[] args) {
        System.out.println(sumOfInt(1432));
        System.out.println(IntPalindrome(1221));
    }

    static int sumOfInt(int n ){
        int sum = 0;
        while(n != 0){
            int x = n %10;
            sum += x;
            n /=10;
        }
        return sum;
    }

    static boolean IntPalindrome(int n){
        if(n < 0){
            return false;
        }
        int og =n;
        int rev = 0;
        while(n!=0){
            int x = n % 10;
            rev = rev *10 + x;
            n /=10;
        }
        return rev == og;
    }
}
