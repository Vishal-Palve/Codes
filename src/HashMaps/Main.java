package HashMaps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer,Integer> map =  new HashMap<>();

        String name = "Rahul";

        System.out.println(name.hashCode());
    }
}
