package OOPs.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 23;
        int b = 0;
        try {
            divide(a, b);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("this will always execute");
        }

    }

    static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("dont divide by zero");
        }
        return a/b;

    }
}
