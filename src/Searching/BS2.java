package Searching;

public class BS2 {

    public static void main(String[] args) {
        int[] nums = {9, 4, 5, 3, 2, 1, 0};

        System.out.println(reverseBinarySearch(nums, 0, 3, nums.length - 1));

        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(peakElementOptimal(nums2,0, nums2.length -1));
    }

    public static int reverseBinarySearch(int[] arr, int s, int key, int e){
        while(s <= e){
            int m = s + (e - s)/2;

            if(arr[m] == key) return m;

            if(arr[m] > key){
                s = m + 1;       // move right in descending
            } else {
                e = m - 1;       // move left
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int s, int key, int e){
        while(s <= e){
            int m = s + (e - s)/2;

            if(arr[m] == key) return m;

            if(arr[m] > key){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

    public static int peakElementOptimal(int[] arr, int s, int e){
        while(s < e){
            int m = s + (e - s)/2;
            if(arr[m+1] > arr[m]){
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }
}
