package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class CountFreq {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 1, 3, 2};
        freqCount(nums);
        freqCount("hello");
        decrement();
    }

    static void freqCount(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
    }

    static void freqCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }

    static void decrement() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 3);
        map.put('b', 2);
        System.out.println(map);
        int count = map.get('a');
        for (int i = 0; i < count; i++) {
            map.put('a', map.get('a') - 1);
            if (map.get('a') == 0) {
                map.remove('a');
            }
        }
        System.out.println(map);
    }
}
