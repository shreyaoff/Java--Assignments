public class Question4 {
    public static void main(String[] args) {
        Rectangle smallRect = new Rectangle(10, 15);
        Rectangle mediumRect = new Rectangle(20, 15);
        Rectangle largeRect = new Rectangle(5, 6);

        System.out.println("Area of " + smallRect.rectLength + " x " + smallRect.rectWidth + " rectangle = " + smallRect.calculateArea());
        System.out.println("Area of " + mediumRect.rectLength + " x " + mediumRect.rectWidth + " rectangle = " + mediumRect.calculateArea());
        System.out.println("Area of " + largeRect.rectLength + " x " + largeRect.rectWidth + " rectangle = " + largeRect.calculateArea());
    }
}

class Rectangle {
    int rectLength;
    int rectWidth;

    public Rectangle(int rectLength, int rectWidth) {
        this.rectLength = rectLength;
        this.rectWidth = rectWidth;
    }

    public int calculateArea() {
        return rectLength * rectWidth;
    }
}