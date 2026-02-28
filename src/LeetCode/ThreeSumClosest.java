package LeetCode;

public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {

        int n = nums.length;
        int max_diff = 0;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;

            int sum = nums[i] + nums[left] + nums[right];

            if(sum == target){
                return 0;
            }
            while(left < right){

                int diff = Math.abs(sum - target);
                if(max_diff > diff){
                    max_diff = diff;
                }
                left++;
                right--;
            }
        }
        return max_diff;
    }

    public static void main(String[] args) {
        
    }
}