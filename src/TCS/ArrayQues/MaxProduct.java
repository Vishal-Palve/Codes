package TCS.ArrayQues;

import java.util.Scanner;

public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int curr = arr[0];
        int ans = arr[0];
        int neg = arr[0];

        for (int i = 1; i < n; i++) {
            int val = curr * arr[i];
            int val2 = arr[i];
            int val3 = neg * arr[i];
            curr =  Math.max(Math.max(val , val2), val3);
            neg = Math.min(Math.min(val2, val3), val);
            ans = Math.max(Math.max(curr, neg), ans);
        }
        System.out.println(ans);
    }
}
