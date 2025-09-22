package LeetCode;

public class Ceiling {


     public static int BS(int[] arr, int target){
         if(target > arr[arr.length - 1]){
             return -1;
         }
         int s = 0;
         int e = arr.length - 1;
         while(s<=e){
             int m = s + (e-s)/2;
             if(arr[m] == target){
                 return m;
             }

             else if (arr[m] > target){
                 e = m-1;
             }
             else{
                 s = m+1;
             }
         }
         return s;
     }
    public static void main(String[] args) {
         int[] AR = { 2, 4, 5, 14, 16,17, 18};
         int ans =BS(AR, 1);
        System.out.println(ans);


    }
}
