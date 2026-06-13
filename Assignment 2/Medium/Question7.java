public class Question7 {
    public static void main(String[] args) {
        Product product1 = new Product("Toner", 1500.99, 10);
        Product product2 = new Product("Boots", 300.00, 5);
        Product product3 = new Product("Ipad", 750, 4);

        System.out.println("Final Price of " + product1.productName + " = " + product1.calculateFinalPrice());
        System.out.println("Final Price of " + product2.productName + " = " + product2.calculateFinalPrice());
        System.out.println("Final Price of " + product3.productName + " = " + product3.calculateFinalPrice());
    }
}

class Product {
    String productName;
    double originalPrice;
    int discountPercent;

    public Product(String productName, double originalPrice, int discountPercent) {
        this.productName = productName;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
    }

    public double calculateFinalPrice() {
        return originalPrice - ((originalPrice * discountPercent) / 100);
    }
}