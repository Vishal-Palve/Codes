package OOPs.collections;

import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vishal", "Rudrani", "Ayush", "Prasad");

        List<String> uNames = names.stream()
                .map(String:: toUpperCase)
                .toList();
        System.out.println(uNames);
       uNames.forEach(System.out::println);

    }
}
