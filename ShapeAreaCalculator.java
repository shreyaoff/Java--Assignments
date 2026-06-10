// Question 4: Shape Area Calculator
// Abstract class Shape with abstract method calculateArea().
// Subclasses: Rectangle (length, width), Circle (radius), Triangle (base, height).
// Override calculateArea() in each. Create an array of Shape references and compute total area.

abstract class Shape {
    abstract double calculateArea();
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle(5, 3),
            new Circle(7),
            new Triangle(6, 4),
            new Rectangle(10, 2)
        };

        double totalArea = 0;

        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(shape.getClass().getSimpleName() + " area: " + String.format("%.2f", area));
            totalArea += area;
        }

        System.out.println("Total area: " + String.format("%.2f", totalArea));
    }
}
