package TCS.ArrayQues;

import java.util.Scanner;

class TwoSumm {
    public static void main(String args[]){

        System.out.println(funn());
    }

    public static Boolean funn(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int target = sc.nextInt();
        int left = 0;
        int right  = n-1;

        for(int i = 0; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target) return true;
            else if(sum < target) left++;
            else{
                right--;
            }
        }
        return false;
    }
}
