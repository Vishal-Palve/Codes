package OOPs.generics;


import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            arr.add(i);

        }
        arr.forEach((num) -> System.out.println(num * 3));

        Consumer<Integer> fun = (num) -> System.out.println(num * 3);
        arr.forEach(fun);
    Operation sum = (a,b) -> a+b;
        Operation prod = (a,b) -> a*b;
        Operation  div = (a,b) -> a/b;

        LambdaFunctions myCalculator = new LambdaFunctions();
        System.out.println(myCalculator.operate(5, 3, sum));
        System.out.println(myCalculator.operate(5, 3, prod));
        System.out.println(myCalculator.operate(5, 3, div));
    }
    private int operate(int a , int b, Operation op){
        return op.operation(a, b);

    }

}

interface Operation {
    int operation(int a , int b);
}