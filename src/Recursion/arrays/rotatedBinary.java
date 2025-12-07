package Recursion.arrays;

public class rotatedBinary {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 6, 8, 9};
        System.out.println(binary(arr, 3,0, arr.length -1));
    }
    static int binary(int[] nums, int key, int s, int e){
        int m = s + (e - s)/2;
        if(s>e){
            return -1;
        }


        return -1;
        }

}
