package Recursion;

import java.util.List;

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

    public static void main(String[] args) {
        System.out.println(rev(342));

        System.out.println(removeA("baccad", 0, ""));
    }
}
