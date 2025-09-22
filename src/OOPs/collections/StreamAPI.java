package OOPs.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 7, 2, 3);

        Stream<Integer> s1 = numbers.stream();
        Stream<Integer> s2 = s1.filter(n -> n%2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
//        for (int i = 0; i < nums.size() ; i++) {
//            System.out.println(nums.get(i));
//        }
//        System.out.println("Enhanced for ");
//        for(int n : nums){
//            System.out.println(n);
//        }
//        System.out.println("StreamAPI");

        List<String> names = Arrays.asList("vishal", "raj", "amit");

        names.stream()
                .map(String::toUpperCase)   // convert to uppercase
                .forEach(System.out::println);


        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(squares);



        s3.forEach(n -> System.out.println(n));

        int result = numbers.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .reduce(0, (c,e) -> c+e);
        System.out.println(result);




    }
}
