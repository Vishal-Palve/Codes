package OOPs.abstractdemo;

// Abstract class
abstract class Shape {
    // Abstract method to calculate area (no implementation here)
    abstract double calculateArea();

    // Abstract method to display details
    abstract void display();
}

// Concrete subclass: Circle
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of calculateArea for Circle
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementation of display for Circle
    @Override
    void display() {
        System.out.println("Shape: Circle, Area: " + calculateArea());
    }
}

// Concrete subclass: Rectangle
class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implementation of calculateArea for Rectangle
    @Override
    double calculateArea() {
        return width * height;
    }

    // Implementation of display for Rectangle
    @Override
    void display() {
        System.out.println("Shape: Rectangle, Area: " + calculateArea());
    }
}

 class AbstractMethodDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        circle.display(); // Output: Shape: Circle, Area: 78.53981633974483

        Shape rectangle = new Rectangle(4.0, 6.0);
        rectangle.display(); // Output: Shape: Rectangle, Area: 24.0
    }
}
