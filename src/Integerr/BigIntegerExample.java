package Integerr;

import java.math.BigInteger;

public class BigIntegerExample {
    public static void main(String[] args) {
        // Creating BigInteger objects
        BigInteger a = new BigInteger("9876543210123456789");
        BigInteger b = new BigInteger("1234567890987654321");

        // Arithmetic operations
        System.out.println("Addition: " + a.add(b));
        System.out.println("Subtraction: " + a.subtract(b));
        System.out.println("Multiplication: " + a.multiply(b));
        System.out.println("Division: " + a.divide(BigInteger.valueOf(100)));
        System.out.println("Remainder: " + a.remainder(b));

        // Comparison and equality
        System.out.println("CompareTo: " + a.compareTo(b)); // returns 1, 0, or -1
        System.out.println("Equals: " + a.equals(b));

        // Power and GCD
        System.out.println("Power (a^2): " + a.pow(2));
        System.out.println("GCD: " + a.gcd(b));

        // Bit operations
        System.out.println("BitCount: " + a.bitCount());
        System.out.println("ShiftLeft(2): " + a.shiftLeft(2));
        System.out.println("ShiftRight(3): " + a.shiftRight(3));

        // Convert to primitive types
        System.out.println("As int: " + a.intValue());
        System.out.println("As long: " + a.longValue());

        // Constants
        System.out.println("BigInteger.ZERO: " + BigInteger.ZERO);
        System.out.println("BigInteger.ONE: " + BigInteger.ONE);
        System.out.println("BigInteger.TEN: " + BigInteger.TEN);
    }
}

