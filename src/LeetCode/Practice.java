package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Practice {


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(nums,2));

        int[] arr = {1,4,4};
        System.out.println(minSubArrayLen(4,arr));
    }


        public  static int minSubArrayLen(int target, int[] nums) {
            int low = 0;
            int high = 0;
            int n = nums.length;
            int sum = 0;
            int len = Integer.MAX_VALUE;;
            int currlen = 0;
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
            int high  = nums.length - 1;
            if (nums.length < 2){
                return linearSearch(nums, target);
            }

            while(low < high){
                int mid = low + (high - low) / 2;

                if(nums[mid] == target || nums[low] == target || nums[high] == target){
                    return true;
                }

                else if(target > nums[mid] && target > nums[high]){
                    high = mid;
                }
                else if (nums[mid] == nums[low] && nums[low] == nums[high]){
                    return linearSearch(nums,target);
                }
                else {
                    low = mid + 1;
                }
            }

            return false;
        }

        public static boolean linearSearch(int[] nums, int tar){
            for(int num : nums){
                if(num == tar){
                    return true;

                }

            }
            return false;
        }
    }

