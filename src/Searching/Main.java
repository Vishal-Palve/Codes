import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {

                result.add(mid);

                int left = mid - 1;
                while (left >= 0 && arr[left] == target) {
                    result.add(left);
                    left--;
                }

                int right = mid + 1;
                while (right < arr.length && arr[right] == target) {
                    result.add(right);
                    right++;
                }

                break;
            }
        }


      //  result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 9};
        ArrayList<Integer> indices = BinarySearch(arr, 8);
        System.out.println("Indices of target: " + indices);
    }
}
