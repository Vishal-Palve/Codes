package sorting;

import java.util.ArrayList;
import java.util.Arrays;


public class SetMismatched {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        ArrayList<Integer> result = Cyclic(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));
        System.out.println("Mismatched Indices and Values: " + result);
    }

    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    static ArrayList<Integer> Cyclic(int[] arr) {
        int i = 0;
        ArrayList<Integer> mismatched = new ArrayList<>();

        while (i < arr.length) {
            // Ensure we are not accessing out of bounds and avoid duplicates
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }

        // Check for mismatched indices after sorting
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                mismatched.add(j);       // Index of the mismatch
                mismatched.add(arr[j] + 1); // Value at the mismatched index
            }
        }

        return mismatched;
    }
}


