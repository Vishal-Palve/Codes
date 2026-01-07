package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class CountFreq {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,1,3,2};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
    }
}
