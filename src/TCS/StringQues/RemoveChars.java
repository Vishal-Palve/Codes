package TCS.StringQues;

import java.util.*;
public class RemoveChars {

    // Method 1: Using HashSet (Efficient - O(n + m))
    public static String removeChars(String str1, String str2) {
        // Add all chars from str2 to a set for O(1) lookup
        Set<Character> charsToRemove = new HashSet<>();
        for (char c : str2.toCharArray()) {
            charsToRemove.add(c);
        }

        // Build result with chars from str1 not in set
        StringBuilder result = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (!charsToRemove.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Method 2: Using StringBuilder delete (Alternative)
    public static String removeCharsAlt(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1);
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            // Remove all occurrences of char c
            for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == c) {
                    sb.deleteCharAt(j);
                }
            }
        }
        return sb.toString();
    }

    // Method 3: Using Java 8 Streams (Modern approach)
    public static String removeCharsStream(String str1, String str2) {
        Set<Character> removeSet = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(HashSet::new, Set::add, Set::addAll);

        return str1.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !removeSet.contains(c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // Process and display result
        String result = removeChars(str1, str2);

        System.out.println("Original String 1: \"" + str1 + "\"");
        System.out.println("String 2 (chars to remove): \"" + str2 + "\"");
        System.out.println("Result: \"" + result + "\"");

        scanner.close();
    }
}