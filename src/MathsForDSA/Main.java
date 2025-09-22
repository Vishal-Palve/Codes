package MathsForDSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//    int[] arr = {1,2,3,4,5,6,5,4,3,2,1};
//        System.out.println( ans(arr));
//
//        System.out.println(sumarr(arr));
      int[] nums = {1,4,5,6,7,8,8,7,6,5,4,1,1,4,5,6,7,8,3};
        System.out.println(findSingleNumber(nums));
        System.out.println(sumarr(nums));

//        System.out.println(findbitWithLeftShift(18,1));
//        System.out.println(setBit(18,4));
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    static int ans(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }
    static int sumarr(int[] arr){
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        return sum ;
    }

    static int findbit(int n, int i){

        return ((n >> i) & 1);
    }

    static int findbitWithLeftShift(int n , int bit){

        return (n & (1  << bit)) >> bit;
    }

    static int setBit(int n, int bit){
        return (n | (1  << bit)) >> bit;
    }

    static int SingleNumber(int[] nums){
        int unique = 0;
        for(int n : nums){
            unique+=n;
        }
        if(unique%3 ==0){

        }
        return unique % 3;
    }

    public static int findSingleNumber(int[] nums) {
        int result = 0; // This variable will store the single occurring number.

        // We iterate through each bit position in a number (assuming 32-bit integers).
        for (int i = 0; i < 32; i++) {
            int sum = 0; // This will store the sum of bits at position i across all numbers.

            // We go through each number in the array and count the bits at position i.
            for (int num : nums) {
                sum += (num >> i) & 1;
                // (num >> i) shifts the bits of num to the right by i positions.
                // The "& 1" operation isolates the bit at position i.
                // We add the isolated bit to the sum.
            }

            sum %= 3; // Taking the sum modulo 3 eliminates bits appearing in triplets.

            // Now, we set the corresponding bit in the 'result' using bitwise OR operation.
            // We shift the calculated sum by i positions and then set the bit in 'result'.
            result |= (sum << i);
        }

        return result; // The 'result' now holds the single occurring number.
    }

    static int magicnumAmazon(int n ){
return 0;
    }



        public int maxArea(int[] height) {
            int s = 0;
            int e = height.length -1;
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < height.length-1; i++){
                for(int j = e; j >= 0; j--){
                    int x =  Math.min(height[i] , height[j]);
                    list.add(x*(j-i));
                }

            }
            Collections.sort(list);
            int last = list.get(list.size() - 1);
            return last;

        }

}
