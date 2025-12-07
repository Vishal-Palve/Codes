package Strings;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 100_000;

        // 1️⃣ String (immutable)
        long start = System.currentTimeMillis();
    String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // creates new object each time
        }
        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        // 2️⃣ StringBuilder (fast)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // 3️⃣ StringBuffer (thread-safe)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}
