package Integerr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculation {
    public static void main(String[] args) {
        BigDecimal principal = new BigDecimal("100000.00");
        BigDecimal rate = new BigDecimal("0.0725"); // 7.25%
        BigDecimal years = new BigDecimal("5");

        // Simple Interest = P * R * T
        BigDecimal interest = principal.multiply(rate).multiply(years);
        BigDecimal totalAmount = principal.add(interest);

        System.out.println("Principal: " + principal);
        System.out.println("Interest: " + interest.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total Amount: " + totalAmount.setScale(2, RoundingMode.HALF_UP));
    }
}

