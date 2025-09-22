package LeetCode;

import java.util.Arrays;

public class Q44 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int s = 0, e = nums.length - 1;
        int result = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target) {
                result = m;
                if (isFirst) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return result;
    }
}
