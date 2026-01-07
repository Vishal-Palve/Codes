package sorting;

import java.util.Arrays;



public class CyclicSort {
    public static void main(String[] args) {

        int[] arr = { 2 , 1 , 3, 4, 5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr , int f , int s ){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]= temp;
    }

    static void cyclicSort(int[] arr){
        int i = 0;

        while(i < arr.length) {
            if(i!= arr[i] -1  ){
                swap(arr , i , arr[i] - 1);
            }
            else {
                i++;
            }
        }
   }
}



