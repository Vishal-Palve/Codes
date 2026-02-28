package TCS.ArrayQues;

import java.util.Scanner;

public class Party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] e = new int[t];
        int[] l = new int[t];

        for (int i = 0; i < t; i++) {
            e[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            l[i] = sc.nextInt();
        }

        int current = 0;
        int max = 0;

        for (int i = 0; i < t; i++) {
            current += e[i];
            current -= l[i];

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}