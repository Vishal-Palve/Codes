package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

      int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }

        public static int threeSumClosest(int[] nums, int target) {

            Arrays.sort(nums);

            int n = nums.length;
            int min = Integer.MAX_VALUE;
            int j =  1;
            int k = n - 1;
            for(int i = 0; i < n; i++){

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                else if (sum > target && k > j){
                    int closest = Math.abs(sum - target);
                    min = Math.min(closest , min);
                    k--;
                }
                else if(j < k){
                    int closest = Math.abs(sum - target);
                    min = Math.min(closest , min);
                    j++;
                }

            }
            return min;
        }
    }
