public class Question10 {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Supra", 8500000);
        Car car2 = new Car("Lamborghini", "Huracan", 35000000);
        Car car3 = new Car("Porsche", "911", 15000000);
        Car car4 = new Car("Ferrari", "Roma", 28000000);
        Car car5 = new Car("Audi", "R8", 18000000);

        car1.displayCar();
        car2.displayCar();
        car3.displayCar();
        car4.displayCar();
        car5.displayCar();
    }
}

class Car {
    String carBrand;
    String carModel;
    double carPrice;

    public Car(String carBrand, String carModel, double carPrice) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPrice = carPrice;
    }

    public void displayCar() {
        if (carPrice > 2000000) {
            System.out.println("Brand: " + this.carBrand);
            System.out.println("Model: " + this.carModel);
            System.out.println("Price: " + this.carPrice);
            System.out.println();
        }
    }
}