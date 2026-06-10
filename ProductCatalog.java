// Question 8: E-Commerce Product Catalog
// Base class Product with fields: name, price and method displayDetails().
// Subclasses: Electronics (warrantyPeriod), Clothing (size, material), Grocery (expiryDate).
// Override displayDetails() to show product-specific info.

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
    }
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty: " + warrantyPeriod + " months");
    }
}

class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}

class Grocery extends Product {
    private String expiryDate;

    public Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

public class ProductCatalog {
    public static void main(String[] args) {
        Product[] catalog = {
            new Electronics("Laptop", 999.99, 24),
            new Clothing("T-Shirt", 19.99, "M", "Cotton"),
            new Grocery("Milk", 2.49, "2025-07-15")
        };

        for (Product product : catalog) {
            System.out.println("--------------------");
            product.displayDetails();
        }
    }
}
