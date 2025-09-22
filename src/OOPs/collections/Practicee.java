package OOPs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practicee {

    public static void main(String[] args) {

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                return Integer.compare(i.length(), j.length());
            }
        };

        List<String> list = new ArrayList<>();
        list.add("heyy");
        list.add("heyyy");
        list.add("heyyyy");
        list.add("hey");

        Collections.sort(list, com);
        System.out.println(list);
    }
}
