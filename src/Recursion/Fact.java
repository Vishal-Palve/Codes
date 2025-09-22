package Recursion;

public class Fact {

    static int zeros(int n, int count){
        if(n == 0){
            return count;
        }
        int d = n%10;
        if(d == 0){
            return zeros(n/10,count + 1);
        }
        else {
            return zeros(n/10, count);
        }
    }
    public static void main(String[] args) {
//        System.out.println(fact(4));
//        System.out.println(sumOfIndivisualDigits(1342));
      //  System.out.println(fact(1234));
        System.out.println(zeros(130002405,0));
    }

    static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n * fact(n-1);
    }

    static int sumOfIndivisualDigits(int n){
        if(n == 0){
            return 0;
        }
        return n % 10 + sumOfIndivisualDigits(n/10);
    }

}
