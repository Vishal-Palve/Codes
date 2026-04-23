package Recursion;
import java.util.*;
public class Practice {

    public static int rev(int n) {
        int rev = 0;
        while (n > 0) {
            int d = n % 10;
            rev = d + rev * 10;
            n = n / 10;
        }
        return rev;
    }

    public static String removeA(String str, int s, String ans) {
        if (s == str.length()) {
            return ans;
        }
        if (str.charAt(s) != 'a') {
            ans += str.charAt(s);
            return removeA(str, s + 1, ans);
        }
        return removeA(str, s + 1, ans);
    }


    static int searchBin(int[] nums ){
        int s = 0;
        int e = nums.length;

        while(s <= e){
            int m = s + (e-s)/2;

            if(nums[m] == nums[m-1]){
                s = m+1;
            }
            else if(nums[m] == nums[m+1]){
                e = m-1;
            }
            else{
                return nums[m];
            }

        }
        return -1;
    }

    static int[] getDuplicateFirstIndex(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] ,map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i] ) > 1){
                    list.add(i);
                    map.remove(nums[i]);
                }
            }
        }
        int[] ans = new int[list.size()];
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

     static void main() {
//        System.out.println(rev(342));
//
//        System.out.println(removeA("baccad", 0, ""));~
//        int[] nums = {1,1,2,2,3,3,4,4,6,6,7};
//         System.out.println(searchBin(nums));
         int[] arr = {1, 2, 3, 2, 4, 1};
         System.out.println(Arrays.toString(getDuplicateFirstIndex(arr)));
    }
}
