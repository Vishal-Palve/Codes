package TCS.StringQues;

import java.util.*;

public class EncodeString{

    public static void main(String[] args) {

    decodeString();
    }

    public static void encodeString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder ans = new StringBuilder();

        int count = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ans.append(s.charAt(i - 1));
                ans.append(count);
                count = 1;
            }
        }

        // VERY IMPORTANT → handle last group
        ans.append(s.charAt(s.length() - 1));
        ans.append(count);

        System.out.println(ans);
    }


    public static void decodeString() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {

            char ch = str.charAt(i);
            int num = str.charAt(i + 1) - '0';

            for (int j = 0; j < num; j++) {
                ans.append(ch);
            }
        }

        System.out.println(ans);
    }
}
