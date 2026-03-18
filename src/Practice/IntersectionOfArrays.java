package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {

    static int[] inter(int[] arr , int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for(int num : arr) {
            map.put(num, i);
            i++;
        }
        for(int j = 0; j < nums.length; j++){
            if(map.containsKey(nums[j])){
                list.add(nums[j]);
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 4, 6};

        System.out.println();
    }
}
