package TCS.StringQues;

import java.util.Scanner;

public class CaesarEncryption {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int key = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Uppercase letters
            if (Character.isUpperCase(ch)) {
                int shift = key % 26;
                char encrypted = (char) ((ch - 'A' + shift) % 26 + 'A');
                result.append(encrypted);
            }

            // Lowercase letters
            else if (Character.isLowerCase(ch)) {
                int shift = key % 26;
                char encrypted = (char) ((ch - 'a' + shift) % 26 + 'a');
                result.append(encrypted);
            }

            // Digits
            else if (Character.isDigit(ch)) {
                int shift = key % 10;
                char encrypted = (char) ((ch - '0' + shift) % 10 + '0');
                result.append(encrypted);
            }

            // Special characters unchanged
            else {
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}