package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] mat = {4, -5, 7, -8, 6, 9};
        selectionSort(mat);
        System.out.println(" Sorted Array " + Arrays.toString(mat));
    }
    static int[] selectionSort(int[] arr ){
   for (int i = 0; i < arr.length ; i++) {
            int last = arr.length - i - 1;
            int  maxindex = getMaxIndex(arr ,  0 , last);
             swap( arr , maxindex , last);
        }
        return arr;
    }

    static void swap(int[] arr , int first ,  int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
    }
        return max;
    }
}

