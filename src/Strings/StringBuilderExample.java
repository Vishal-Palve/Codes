package Strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        // Append and Insert
        sb.append(" Programming");
        sb.insert(0, "Learn ");

        // Replace and Delete
        sb.replace(6, 10, "Master");   // Replaces "Java" with "Master"
        sb.delete(6, 12);              // Deletes "Master"

        // Reverse and Length
        sb.append(" StringBuilder!");
        sb.reverse();                  // Reverses the string
        System.out.println("Reversed: " + sb);

        // Reverse again (back to normal)
        sb.reverse();

        // Character modification
        sb.setCharAt(0, 'L');

        // Capacity and ensureCapacity
        System.out.println("Capacity before: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensure: " + sb.capacity());

        // Output all
        System.out.println("Final StringBuilder: " + sb.toString());
        System.out.println("Length: " + sb.length());
    }
}
