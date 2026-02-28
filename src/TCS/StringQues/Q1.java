package TCS.StringQues;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int starCount = 0;
        int hashCount = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '*') {
                starCount++;
            } else if (ch == '#') {
                hashCount++;
            }
        }

        System.out.println(starCount - hashCount);

        sc.close();
    }
}