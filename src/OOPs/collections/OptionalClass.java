package OOPs.collections;

import java.util.Arrays;
import java.util.List;

public class OptionalClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vishal", "Rudrani", "Ayush", "Prasad");

        String name = names.stream()
                .filter(str -> str.contains("z"))
                .findFirst()
                .orElse("Not Found");

        System.out.println(name);
    }
}
