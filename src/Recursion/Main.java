package Recursion;

public class Main {
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6};
      //int target = 4;
     int ans = binarySearch(arr, 0, arr.length -1, 4);
        System.out.println(ans);
    }
    public static void message(int n ){
        if(n == 0){
            return;
        }
        System.out.println("Hello");
        message(n-1);
    }

    public static int num(int n){
        if(n == 1){
            return 1;
        }
        System.out.println(n);
        return num(n-1);

    }

    public static int fibo(int n ){
        if(n < 2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);

    }

    static int binarySearch(int[] arr, int start, int end, int target){
        if(start>end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(target > arr[mid]){
            return binarySearch(arr, mid + 1, end, target);
        }
        return binarySearch(arr, start, mid-1, target);
    }
}
