package sorting;

import java.util.Arrays;

public class MergeInPlace {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 54, 43, 8778, 88, 89, 99, 6, 99, 44};
        mergesortInPlace(arr, 0, arr.length);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    static void mergesortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = s + (e - s) / 2;

        mergesortInPlace(arr, s, mid);
        mergesortInPlace(arr, mid, e);
        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }
        while (i < m) {
            mix[k++] = arr[i++];
        }
        while (j < e) {
            mix[k++] = arr[j++];
        }
        System.arraycopy(mix, 0, arr, s, mix.length);
    }
}
