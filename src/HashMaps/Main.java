package HashMaps;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // HASHMAP BASICS
        // =========================

        Map<Integer, String> map = new HashMap<>();

        // put(key, value)
        map.put(1, "Rahul");
        map.put(2, "Amit");
        map.put(3, "Neha");

        // put() with same key → value gets replaced
        map.put(2, "Amit Updated");

        // get(key)
        System.out.println("Get key 2: " + map.get(2)); // Amit Updated

        // get() for missing key → null
        System.out.println("Get key 10: " + map.get(10)); // null

        // containsKey(key)
        System.out.println("Contains key 3: " + map.containsKey(3));

        // containsValue(value)
        System.out.println("Contains value Rahul: " + map.containsValue("Rahul"));

        // size()
        System.out.println("Map size: " + map.size());

        // remove(key)
        map.remove(1);

        // remove(key, value) → removes only if both match
        map.remove(2, "WrongValue"); // will NOT remove
        map.remove(2, "Amit Updated"); // will remove

        // isEmpty()
        System.out.println("Is map empty: " + map.isEmpty());

        // =========================
        // ITERATING HASHMAP (VERY IMPORTANT)
        // =========================

        map.put(10, "One");
        map.put(20, "Two");
        map.put(30, "Three");

        // 1️⃣ Iterate using entrySet() (BEST way)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 2️⃣ Iterate keys only
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key);
        }

        // 3️⃣ Iterate values only
        for (String value : map.values()) {
            System.out.println("Value: " + value);
        }

        // =========================
        // COMMON INTERVIEW METHODS
        // =========================

        // getOrDefault(key, defaultValue)
        System.out.println(map.getOrDefault(100, "Default"));

        // putIfAbsent(key, value)
        map.putIfAbsent(10, "NewValue"); // won't overwrite

        // replace(key, value)
        map.replace(10, "ReplacedValue");

        // clear()
        // map.clear();

        // =========================
        // FREQUENCY COUNT PATTERN (DSA GOLD)
        // =========================

        String s = "aabbccaa";
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Frequency Map: " + freq);

        // =========================
        // SET BASICS
        // =========================

        Set<Integer> set = new HashSet<>();

        // add()
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // duplicate → ignored

        // size()
        System.out.println("Set size: " + set.size());

        // contains()
        System.out.println("Set contains 20: " + set.contains(20));

        // remove()
        set.remove(20);

        // isEmpty()
        System.out.println("Set empty: " + set.isEmpty());

        // =========================
        // ITERATING SET
        // =========================

        for (Integer val : set) {
            System.out.println("Set value: " + val);
        }

        // =========================
        // REMOVE DUPLICATES USING SET
        // =========================

        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> unique = new HashSet<>();

        for (int x : arr) {
            unique.add(x);
        }

        System.out.println("Unique elements: " + unique);

        // =========================
        // IDENTITY HASH MAP (RARE BUT GOOD TO KNOW)
        // =========================

        Map<String, String> identityMap = new IdentityHashMap<>();

        String a = new String("Java");
        String b = new String("Java");

        identityMap.put(a, "First");
        identityMap.put(b, "Second");

        // uses == instead of equals()
        System.out.println("IdentityHashMap size: " + identityMap.size());
    }
}
