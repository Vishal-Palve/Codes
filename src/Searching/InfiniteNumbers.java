package Searching;

import java.util.List;

public class InfiniteNumbers {

    public static void main(String[] args) {
        int size = 100_000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i * 3;
        }

        int target = 99993;

        System.out.println(bs(arr,target));
    }

    public static int bs(int[] arr, int target){
        if(target < arr[0]){
            return -1;
        }

      int   s = 0;
     int    e = 1;

        while(s<=e){
            int m = s + (e-s)/2;

            if(target == arr[m]){
                return m;
            }
            if(target > arr[e]){
                s = e+1;
                e = 2*e;
            }
            else {
                e = m-1;
            }
        }
        return -1;
    }
}
