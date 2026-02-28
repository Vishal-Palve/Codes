package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            int j = i+1;
            int k = n-1;


            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i] , nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;

                }

                else if(sum > 0){
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return res;
    }
}