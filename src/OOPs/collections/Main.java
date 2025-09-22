package OOPs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if(i % 10 > j % 10) return 1;
                else return 0;
            }
        };

        List<Integer> list = new ArrayList<>();
         list.add(43);
         list.add(35);
         list.add(78);
         list.add(89);

        Collections.sort(list, com);
        System.out.println(list);
    }
}


