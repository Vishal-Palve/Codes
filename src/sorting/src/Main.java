package sorting.src;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums ={1 , 2 ,2 ,4};
       ArrayList<Integer> result = Cyclic(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);

    }
    static void swap(int[] arr , int f , int s ){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]= temp;
    }


   static ArrayList<Integer> Cyclic(int[] arr){
        int i = 0;
       ArrayList<Integer> m = new ArrayList<>();
        while(i < arr.length) {
          int correct = arr[i] - 1;

            if( arr[i] != arr[arr[i] - 1] ){
                swap(arr , i , correct);
            }
            else {
                i++;
            }


        }
        for (int j = 0; j < arr.length ; j++) {
            if(arr[j] != j+1 ){
                m.add(j);
                m.add(arr[j] + 1);
            }
        }


   return  m ; }




}
