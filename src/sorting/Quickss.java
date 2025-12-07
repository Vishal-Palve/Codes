package sorting;

import java.util.Arrays;

public class Quickss {
    public static void main(String[] args) {
        int[] arr = {3 , 34 , 45 , -4 , 43, 9 , 0};
        Quick(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     static void Quick(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int s = low , e = high;
        int m = s + (e-s)/2;
        int pivot =  arr[m];
        while (s <= e){

            while(arr[s] < pivot ){
                s++;
            }
            while (arr[e] > pivot){
                e--;
            }
            if(s <= e){
                swap(arr , s , e);
                s++;
                e--;
            }
        }
        Quick(arr , low , e);
        Quick(arr , s , high);
    }
}
