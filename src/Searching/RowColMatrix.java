package Searching;

import java.util.Arrays;

public class RowColMatrix {

    public static void main(String[] args) {
       int[][] arr = {
               {1,2,3},
               {4,5,6},
               {7,8,9}
       };
       int[] ans  = Search(arr , 9);
        System.out.println(Arrays.toString(ans));
    }

    static int[] Search ( int[][] arr , int target){

        int row = 0 , col = arr[0].length-1 ;
        while(row < arr.length && col>=0){

                if (target == arr[row][col]){
                    return new int[]{row , col};
                }
                else if (target>arr[row][col]){
                    row++;
                }
                else{
                    col--;
                }

        }

        return new int[]{-1, -1};
    }}



