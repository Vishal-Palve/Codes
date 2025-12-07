package Strings;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("Hello");

        // Append and Insert
        sbf.append(" World");
        sbf.insert(5, ",");

        // Replace, Delete, Reverse
        sbf.replace(0, 5, "Hi");
        sbf.delete(3, 4);
        sbf.reverse();
        System.out.println("Reversed: " + sbf);

        // Reverse back
        sbf.reverse();

        // Capacity related
        System.out.println("Capacity before: " + sbf.capacity());
        sbf.ensureCapacity(40);
        System.out.println("Capacity after ensure: " + sbf.capacity());

        // Convert to String
        String result = sbf.toString();
        System.out.println("Final StringBuffer: " + result);
    }
}

