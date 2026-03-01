package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int low = 0;
        int high = 0;
        int max = 0;
        int n = fruits.length;

        while (high < n) {

            // 1️⃣ Expand window
            map.put(fruits[high],
                    map.getOrDefault(fruits[high], 0) + 1);
            high++;

            // 2️⃣ Shrink window if invalid
            while (map.size() > 2) {

                map.put(fruits[low],
                        map.get(fruits[low]) - 1);

                if (map.get(fruits[low]) == 0) {
                    map.remove(fruits[low]);
                }

                low++;
            }

            // 3️⃣ Update maximum
            max = Math.max(max, high - low);
        }

        return max;
    }
}