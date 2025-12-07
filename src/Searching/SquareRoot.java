public class SquareRoot {

    public static void main(String[] args){
        long ans = Square(2147395599);
        System.out.println(ans);

    }

    static long Square(int n){
        long s = 0;
        long e = n;
        while(s<=e){
            long m = s + (e-s)/2;
            if(m*m == n){
                return m;
            }
            else if(m*m > n){
                e = m-1;
            }
            else {
                s=m+1;
            }
        }
        return s;
    }
}
