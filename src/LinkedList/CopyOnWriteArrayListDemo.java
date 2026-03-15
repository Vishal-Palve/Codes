package LinkedList;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.add(5); // not possible in normal ArrayList can only do one thing at a time
            }
        }
        System.out.println(list);
    }
}