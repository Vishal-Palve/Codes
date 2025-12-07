package Strings;

public class StringExample {
    public static void main(String[] args) {
        String str = " Hello Java ";

        // Common String methods
        System.out.println("Original: '" + str + "'");
        System.out.println("Length: " + str.length());
        System.out.println("Trimmed: '" + str.trim() + "'");
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("CharAt(2): " + str.charAt(2));
        System.out.println("Substring(1,5): " + str.substring(1, 5));
        System.out.println("Contains 'Java'? " + str.contains("Java"));
        System.out.println("Starts with 'He'? " + str.trim().startsWith("He"));
        System.out.println("Ends with 'va'? " + str.trim().endsWith("va"));
        System.out.println("Index of 'a': " + str.indexOf('a'));
        System.out.println("Last index of 'a': " + str.lastIndexOf('a'));
        System.out.println("Replace 'Java' with 'World': " + str.replace("Java", "World"));
        System.out.println("Equals ignore case: " + "hello".equalsIgnoreCase("HELLO"));

        // Immutability demo
        String newStr = str.concat(" Rocks!");
        System.out.println("After concat: " + newStr);
        System.out.println("Original still unchanged: '" + str + "'");
    }
}
