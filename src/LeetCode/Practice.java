package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
//        System.out.println(search(nums,2));

        int[] arr = {1, -2, -2, 3};
        System.out.println(maximumSum(arr));

        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, n = nums.length, right = n - 1;

        for(int i = 1; i <= n - 2; i++){
            int sum = nums[left] + nums[right] + nums[i];

            if(sum == 0){
                ans.add(Arrays.asList(nums[left]  , nums[i] , nums[right]));
                left++;
                right--;
            }
            else if (sum < 0){
                left++;
            }
            else {
                right--;
            }
        }
        return ans;
    }
    public static int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int delete = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int newDelete = Math.max(delete + arr[i], noDelete); // noDelete is BEFORE update
            int newNoDelete = Math.max(arr[i], noDelete + arr[i]);

            noDelete = newNoDelete;
            delete = newDelete;
            ans = Math.max(ans, Math.max(noDelete, delete));

        }
        return ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (high < n) {
            sum += nums[high];

            if (sum == target) {
                len = Math.min(len, high - low + 1);
            }
            if (sum < target)
                high++;

            while (sum > target && low < high) {
                sum -= nums[low];
                low++;

            }
        }
        return len;
    }

    public static boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        if (nums.length < 2) {
            return linearSearch(nums, target);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target || nums[low] == target || nums[high] == target) {
                return true;
            } else if (target > nums[mid] && target > nums[high]) {
                high = mid;
            } else if (nums[low] == nums[high]) {
                low++;
                high--;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean linearSearch(int[] nums, int tar) {
        for (int num : nums) {
            if (num == tar) {
                return true;

            }
        }
        return false;
    }
}

