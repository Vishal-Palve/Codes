package Recursion.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RecLinearSearch {

    public  static ArrayList<Integer> search(int[] arr, int target, int index, ArrayList<Integer> list ){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
             list.add(index);
        }
        return search(arr, target, index + 1, list);
    }

    public static ArrayList<Integer> search2(int[] nums, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == nums.length) {
            return list;
        }
        if (nums[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> add = search2(nums, target, index + 1);
        list.addAll(add);
        return list;
    }

        public static void main (String[]args){
            int[] arr = {1, 3, 4, 5, 7, 5, 8};

            System.out.println(search2(arr, 5, 0));
        }
    }
