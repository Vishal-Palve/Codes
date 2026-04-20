package TCS.ArrayQues;

import java.util.Scanner;

public class MinimumRowSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int c = 0;
        for (int k = 0; k < n; k++) {
            mat[k][c] = cost[k];
            c++;
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
            }
            if(minSum > sum){
                minSum = sum;
            }
        }
        System.out.println(minSum);
    }
}
