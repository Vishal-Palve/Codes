package Recursion;

public class PhonePad {
    public static void main(String[] args) {
     pad("", "98");
    }
    public static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        if (digit == 7) {
            for (int i = 16; i <= 19; i++) {
                char ch = (char) ('a' + i);
                pad(p + ch, up.substring(1));
            }
        } else if (digit == 9) {
            for (int i = 23; i < 26; i++) {
                char ch = (char) ('a' + i);
                pad(p + ch, up.substring(1));
            }
        } else {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                pad(p + ch, up.substring(1));
            }
        }
    }
}
