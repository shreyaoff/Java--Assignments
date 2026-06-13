public class Question9 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(12.5);
        Circle circle2 = new Circle(6.7);

        System.out.printf("Circumference of circle of radius " + circle1.circleRadius + " = %.2f\n", circle1.calculateCircumference());
        System.out.printf("Area of circle of radius " + circle1.circleRadius + " = %.2f\n", circle1.calculateArea());

        System.out.printf("Circumference of circle of radius " + circle2.circleRadius + " = %.2f\n", circle2.calculateCircumference());
        System.out.printf("Area of circle of radius " + circle2.circleRadius + " = %.2f\n", circle2.calculateArea());
    }
}

class Circle {
    final double PI_VALUE = 3.14159;
    double circleRadius;

    public Circle(double circleRadius) {
        this.circleRadius = circleRadius;
    }

    public double calculateCircumference() {
        return 2 * PI_VALUE * circleRadius;
    }

    public double calculateArea() {
        return PI_VALUE * circleRadius * circleRadius;
    }
}