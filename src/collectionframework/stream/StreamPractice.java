package collectionframework.stream;

import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class StreamPractice {

    // Helper classes
    static class Person {
        String name;
        int age;
        Person(String name, int age) { this.name = name; this.age = age; }
        public String getName() { return name; }
        public int getAge() { return age; }
    }

    static class Transaction {
        double amount;
        String type;
        LocalDate date;
        Transaction(double amount, String type, LocalDate date) {
            this.amount = amount; this.type = type; this.date = date;
        }
        public double getAmount() { return amount; }
        public String getType() { return type; }
        public LocalDate getDate() { return date; }
    }

    static class Employee {
        String name;
        double salary;
        Employee(String name, double salary) { this.name = name; this.salary = salary; }
        public String getName() { return name; }
        public double getSalary() { return salary; }
    }

    public static void main(String[] args) {

        // Q1: Filter even numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Write stream here -> Expected: [2, 4, 6, 8, 10]

        List<Integer> list = numbers1.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println(list);

        // Q2: Sum of string lengths
        List<String> strings2 = Arrays.asList("hello", "world", "java", "streams");
        // Write stream here -> Expected: 21
         int sum = strings2
                .stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(sum);

        // Q3: Find first number > 50
        List<Integer> numbers3 = Arrays.asList(10, 20, 55, 30, 60, 40);
        // Write stream here -> Expected: Optional[55]
        System.out.println(numbers3.stream()
                .filter(x -> x > 50)
                .findFirst());

        // Q4: Uppercase, filter 'A', sort
        List<String> strings4 = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
        // Write stream here -> Expected: [APPLE, APRICOT, AVOCADO]
        System.out.println(strings4.stream()
                .filter(x -> x.startsWith("a"))
                .map(String::toUpperCase)
                .toList());

        // Q5: Count unique > 10
        List<Integer> numbers5 = Arrays.asList(5, 12, 8, 12, 15, 8, 20, 12, 15);
        // Write stream here -> Expected: 5
        System.out.println(
                numbers3.stream()
                        .filter(x -> x > 10)
                        .count()
        );

        // Q6: Flatten nested lists
        List<List<Integer>> nested6 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        // Write stream here -> Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        List<Integer> flattened = nested6.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattened);

        // Q7: Product of all numbers
        List<Integer> numbers7 = Arrays.asList(2, 3, 4, 5);
        // Write stream here -> Expected: 120
        System.out.println(
                numbers7.stream()
                        .reduce((x , y) -> x * y).get()
        );


        // Q8: Group persons by age range
        List<Person> persons8 = Arrays.asList(
                new Person("Alice", 15),
                new Person("Bob", 25),
                new Person("Charlie", 65),
                new Person("Diana", 30),
                new Person("Eve", 70),
                new Person("Frank", 10)
        );
        // Write stream here -> Expected: Map with keys "0-18", "19-60", "60+"


        // Q9: Partition by divisible by 3
        List<Integer> numbers9 = Arrays.asList(1, 2, 3, 6, 7, 9, 12, 15, 17, 20);
        // Write stream here -> Expected: {true=[3,6,9,12,15], false=[1,2,7,17,20]}
        System.out.println(
                numbers9.stream()
                        .collect(Collectors.partitioningBy(n -> n % 3 == 0))
        );

        // Q10: Group DEBIT transactions by month, find max month
        List<Transaction> transactions10 = Arrays.asList(
                new Transaction(100, "DEBIT", LocalDate.of(2024, 1, 15)),
                new Transaction(200, "CREDIT", LocalDate.of(2024, 1, 20)),
                new Transaction(150, "DEBIT", LocalDate.of(2024, 1, 25)),
                new Transaction(300, "DEBIT", LocalDate.of(2024, 2, 10)),
                new Transaction(250, "DEBIT", LocalDate.of(2024, 2, 20)),
                new Transaction(400, "DEBIT", LocalDate.of(2024, 3, 5))
        );
        // Write stream here -> Expected: Month with highest DEBIT total


        // Q11: Second highest salary
        List<Employee> employees11 = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 75000),
                new Employee("Charlie", 60000),
                new Employee("Diana", 75000),
                new Employee("Eve", 90000)
        );
        // Write stream here -> Expected: 75000.0

        // Q12: Flatten map where key length > 3
        Map<String, List<Integer>> map12 = new HashMap<>();
        map12.put("ab", Arrays.asList(1, 2));
        map12.put("code", Arrays.asList(3, 4, 5));
        map12.put("xyz", Arrays.asList(6));
        map12.put("java", Arrays.asList(7, 8, 9, 10));
        // Write stream here -> Expected: [3, 4, 5, 7, 8, 9, 10]


    }
}