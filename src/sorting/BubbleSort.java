package sorting.src;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] mat = {5 , 3 ,1 ,4 , 2};
        Bubble(mat);
        System.out.println(Arrays.toString(mat));

    }
    static void swap(int[] arr , int f , int s ){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]= temp;
    }
    static void Bubble(int[] arr){
           boolean swapped;

        for (int i = 0; i  < arr.length - 1 ; i++) {
            swapped = false;

            for(int j = 1; j < arr.length - i ; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr , j-1 , j);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    static int[] bSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j =  1; j < arr.length - i; j++) {
                if(arr[i] > arr[j]){
                    swap(arr , i ,j);
                }
            }
        }
        return arr;
    }

}

