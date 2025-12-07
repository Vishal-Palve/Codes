package Searching;

public class RotatedBS {

    public static void main(String[] args ){
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println( rbs2(arr , 0 ,0, arr.length ));

    }
        static int rbs2(int[] arr, int s, int key, int e) {
            if (s > e) {
                return -1;
            }
            int m = s + (e - s) / 2;
            if (arr[m] == key) {
                return m;
            }
            if (arr[s] <= arr[m]) {
                if (key >= arr[s] && key < arr[m]) {
                    return rbs2(arr, s, key, m - 1);
                }
                return rbs2(arr, m + 1, key, e);
            }
            if (key > arr[m] && key <= arr[e]) {
                return rbs2(arr, m + 1, key, e);
            }
            return rbs2(arr, s, key, m - 1);
        }
    }



