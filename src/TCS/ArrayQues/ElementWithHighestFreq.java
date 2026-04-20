package TCS.ArrayQues;
import java.util.*;
public class ElementWithHighestFreq {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int maxFreq = -1;
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(map.get(nums[i]) > max){
                max = map.get(nums[i]);
                maxFreq = nums[i];
            }
        }
        System.out.println(maxFreq);
    }


}
