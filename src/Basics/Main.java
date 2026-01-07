package Basics;

import java.util.Scanner;

// Every Java program starts with a class

// This is a single-line comment

/*
 This is a
 multi-line comment
*/

public class Main {

    // main() is the entry point of the program
    public static void main(String[] args) {

        // ===============================
        // 1. PRINTING OUTPUT
        // ===============================
        System.out.println("Hello, Java!");
        System.out.println("Let's learn Java basics 🚀");

        //  TAKING INPUT
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Your age is: " + age);

        // ===============================
        // 2. VARIABLES & DATA TYPES
        // ===============================
        int Age = 21; // integer
        double height = 5.9;           // decimal number
        char grade = 'A';              // single character
        boolean isStudent = true;      // true or false
        String name = "Vishal";        // text

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student? " + isStudent);

        // ===============================
        // 3. OPERATORS
        // ===============================
        int a = 10;
        int b = 3;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));   // integer division
        System.out.println("Remainder: " + (a % b));

        // ===============================
        // 4. IF - ELSE (CONDITIONS)
        // ===============================
        if (age > 18) {
            System.out.println("You are an adult");
        }
        else if ( age == 18) {
            System.out.println("You are an child");
        }

        else {
            System.out.println("You are not an adult");
        }

        // ===============================
        // 5. SWITCH STATEMENT
        // ===============================
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // ===============================
        // 6. LOOPS
        // ===============================

        // For loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // While loop
        System.out.println("While Loop:");
        int count = 1;
        while (count <= 3) {
            System.out.println(count);
            count++;
        }

        // Do-While loop
        System.out.println("Do-While Loop:");
        int x = 1;
        do {
            System.out.println(x);
            x++;
        } while (x <= 2);

        // ===============================
        // 7. ARRAYS
        // ===============================
        int[] numbers = {10, 20, 30, 40};

        System.out.println("Array elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(matrix[0][0]); // 1
        System.out.println(matrix[1][2]); // 6
        System.out.println(matrix[2][1]); // 8

        for (int i = 0; i < matrix.length; i++) {          // rows
            for (int j = 0; j < matrix[i].length; j++) {   // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // new line after each row
        }


    // break and continue
        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue; // skip 3
            }

            if (i == 5) {
                break; // stop loop
            }

            System.out.println(i);
        }
        // ===============================
        // 8. STRING METHODS
        // ===============================
        String message = "Java is Fun";

        System.out.println(message.toUpperCase());
        System.out.println(message.toLowerCase());
        System.out.println("Length: " + message.length());
        System.out.println("Contains 'Fun'? " + message.contains("Fun"));

        // ===============================
        // 9. METHODS (FUNCTIONS)
        // ===============================
        int sum = add(5, 7);
        System.out.println("Sum from method: " + sum);

        greet(name);

        // ===============================
        // 10. OBJECT & CLASS
        // ===============================
        Person p1 = new Person("Rahul", 25);
        p1.introduce();
    }

    // Method with return value
    static int add(int x, int y) {
        return x + y;
    }

    // Method without return value
    static void greet(String personName) {
        System.out.println("Hello, " + personName + " 😊");
    }
}

// ===============================
// 11. ANOTHER CLASS
// ===============================
class Person {
    String name;
    int age;

    // Constructor
    Person(String n, int a) {
        name = n;
        age = a;
    }

    void introduce() {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }
}

