package LeetCode;

public class SubArrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int low = 0, count = 0, prod = 1;

        for (int high = 0; high < nums.length; high++) {
            prod *= nums[high];

            while (prod >= k) {
                prod /= nums[low];
                low++;
            }

            count += (high - low + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        //System.out.println(numSubarrayProductLessThanK(arr, 100));
        int[] nums = {3,6,8,1,2,89};
        System.out.println(secondLargest(nums));
    }


    public static int secondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int num : nums) {
            if(num > max){
                smax = max;
                max = num;
            }
        }
        return smax;
    }
}



