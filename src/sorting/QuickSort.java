package sorting;

import java.util.Arrays;
import java.util.Random;
public class QuickSort {

        public static void main(String[] args) {
            int[] arr = {3, 34, 45, -4, 43, 9, 0};

            quickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }

        static void quickSort(int[] arr, int low, int high) {
            while (low < high) { // Iterative optimization
                int pivotIndex = partition(arr, low, high);
                // Recur for the smaller half first (Tail Recursion Optimization)
                if (pivotIndex - low < high - pivotIndex) {
                    quickSort(arr, low, pivotIndex);
                    low = pivotIndex + 1; // Move to the larger half iteratively
                } else {
                    quickSort(arr, pivotIndex + 1, high);
                    high = pivotIndex;
                }
            }
        }

        static int partition(int[] arr, int low, int high) {
            int pivotIndex = new Random().nextInt(high - low + 1) + low; // Randomized pivot
            int pivot = arr[pivotIndex];
            swap(arr, pivotIndex, low); // Move pivot to start

            int left = low - 1, right = high + 1;

            while (true) {
                do { left++; } while (arr[left] < pivot);
                do { right--; } while (arr[right] > pivot);

                if (left >= right) return right;

                swap(arr, left, right);
            }
        }

        static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }