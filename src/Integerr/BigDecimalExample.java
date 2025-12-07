package Integerr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        // Creating BigDecimal objects
        BigDecimal price = new BigDecimal("199.99");
        BigDecimal taxRate = new BigDecimal("0.18"); // 18%
        BigDecimal discount = new BigDecimal("20.50");

        // Arithmetic operations
        BigDecimal tax = price.multiply(taxRate);
        BigDecimal total = price.add(tax).subtract(discount);

        System.out.println("Price: " + price);
        System.out.println("Tax: " + tax);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);

        // Division with precision
        BigDecimal value = new BigDecimal("10");
        BigDecimal divisor = new BigDecimal("3");
        BigDecimal result = value.divide(divisor, 4, RoundingMode.HALF_UP);
        System.out.println("Division result (4 decimal places): " + result);

        // Comparison
        BigDecimal a = new BigDecimal("2.50");
        BigDecimal b = new BigDecimal("2.5000");
        System.out.println("CompareTo: " + a.compareTo(b));  // returns 0 (equal)
        System.out.println("Equals: " + a.equals(b));        // false (scale differs)

        // Rounding and scaling
        BigDecimal number = new BigDecimal("123.456789");
        System.out.println("Rounded (2 decimal): " + number.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Scaled to 4 decimal places: " + number.setScale(4, RoundingMode.DOWN));

        // Strip trailing zeros
        System.out.println("Without trailing zeros: " + new BigDecimal("100.000").stripTrailingZeros());
    }
}

