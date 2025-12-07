package LeetCode;

public class Q33 {
    public static int binarysearch(int[] nums, int target, int s, int e){
        while(s<=e){
            int m = s + (e-s)/2;
            if(target == nums[m]){
                return m;
            }
            else if (target >= nums[m]){

            }
            else {
                s = m +1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {5, 1, 3};
        System.out.println(binarysearch(nums,0,0, nums.length - 1));
        System.out.println(binarysearch(nums2,5,0, nums.length - 1));

    }
}
