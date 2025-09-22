package Recursion.arrays;

public class PeakElement {

    public static int peak(int[] nums, int s, int e){
        int m = s + (e-s)/2;
        if(nums[m] >= nums[m+1] && nums[m] >= nums[m-1]){
            return nums[m];
        }
        else {
            return peak(nums, s+1, e-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 1, 3, 4};
       int peakelement = peak(arr,0, arr.length-1);
        System.out.println(peakelement);

    }
}
