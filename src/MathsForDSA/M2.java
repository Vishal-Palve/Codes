package MathsForDSA;

public class M2 {

    public static void main(String[] args) {
//        System.out.println(isPrime(7));
//        for (int i = 0; i < 20 ; i++) {
//            if(isPrime(i) == true){
//                System.out.println(i);
//            }
//        }

        System.out.println(lcm(4,9));
    }
    public static boolean isPrime(int n){
        int i = 2;
        while(Math.sqrt(n) >= i){
            if(n % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
    static int gcd (int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
