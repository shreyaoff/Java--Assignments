// Question 15: Food Ordering App
// Class FoodItem with private fields name, price.
// Subclasses:
//   Pizza: add size, toppings[].
//   Burger: add cheese, pattyType.
//   Salad: add ingredients[].
// Use encapsulation and override method displayMenuItem().

class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public void displayMenuItem() {
        System.out.println("Item: " + name);
        System.out.println("Price: $" + price);
    }
}

class Pizza extends FoodItem {
    private String size;
    private String[] toppings;

    public Pizza(String name, double price, String size, String[] toppings) {
        super(name, price);
        this.size = size;
        this.toppings = toppings;
    }

    public String getSize() { return size; }
    public String[] getToppings() { return toppings; }

    @Override
    public void displayMenuItem() {
        System.out.println("[PIZZA]");
        super.displayMenuItem();
        System.out.println("Size: " + size);
        System.out.print("Toppings: ");
        for (int i = 0; i < toppings.length; i++) {
            System.out.print(toppings[i]);
            if (i < toppings.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

class Burger extends FoodItem {
    private boolean cheese;
    private String pattyType;

    public Burger(String name, double price, boolean cheese, String pattyType) {
        super(name, price);
        this.cheese = cheese;
        this.pattyType = pattyType;
    }

    public boolean hasCheese() { return cheese; }
    public String getPattyType() { return pattyType; }

    @Override
    public void displayMenuItem() {
        System.out.println("[BURGER]");
        super.displayMenuItem();
        System.out.println("Patty: " + pattyType);
        System.out.println("Cheese: " + (cheese ? "Yes" : "No"));
    }
}

class Salad extends FoodItem {
    private String[] ingredients;

    public Salad(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public String[] getIngredients() { return ingredients; }

    @Override
    public void displayMenuItem() {
        System.out.println("[SALAD]");
        super.displayMenuItem();
        System.out.print("Ingredients: ");
        for (int i = 0; i < ingredients.length; i++) {
            System.out.print(ingredients[i]);
            if (i < ingredients.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

public class FoodOrderApp {
    public static void main(String[] args) {
        FoodItem[] menu = {
            new Pizza("Margherita", 12.99, "Large", new String[]{"Mozzarella", "Basil", "Tomato"}),
            new Burger("Classic Burger", 8.99, true, "Beef"),
            new Salad("Caesar Salad", 7.49, new String[]{"Romaine", "Croutons", "Parmesan", "Caesar Dressing"})
        };

        System.out.println("===== Food Menu =====");
        for (FoodItem item : menu) {
            System.out.println("---------------------");
            item.displayMenuItem();
        }
    }
}
