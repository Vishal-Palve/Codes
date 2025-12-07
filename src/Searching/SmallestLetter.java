package Searching;

import java.util.Scanner;

public class SmallestLetter {

        static char BinarySearch(char[] arr, char target) {

            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {

                int mid = start + (end - start) / 2;
                if (arr[mid] > target) {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
          }
            return arr[start % arr.length]; }



        public static void main(String[] args) {


            char[] arr = {'a' ,'f' , 'z' };
            System.out.println(" Enter the target element : ");

            Scanner sc = new Scanner(System.in);
            char target =sc.next().charAt(0);

            char ans = BinarySearch(arr , target);

            if(ans!= -1){
                System.out.println("ceiling for " + target + " exists and is : " + ans );

            }
            else{
                System.out.println("ceiling does not exists for this element :" + target );
            }
            System.out.println(ans);
        }
    }


