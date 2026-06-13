// Question 6: Vehicle Rental System
// Base class Vehicle with fields plateNumber, baseRate and method calculateRental(int days).
// Car: charges baseRate * days.
// Truck: charges baseRate * days + load fee.
// Bike: fixed rate regardless of days.

class Vehicle {
    String plateNumber;
    double baseRate;

    Vehicle(String plateNumber, double baseRate) {
        this.plateNumber = plateNumber;
        this.baseRate = baseRate;
    }

    double calculateRental(int days) {
        return baseRate * days;
    }

    void displayRental(int days) {
        System.out.println(getClass().getSimpleName() + " [" + plateNumber + "] for " + days + " day(s): Rs. " + calculateRental(days));
    }
}

class Car extends Vehicle {
    Car(String plateNumber, double baseRate) {
        super(plateNumber, baseRate);
    }

    @Override
    double calculateRental(int days) {
        return baseRate * days;
    }
}

class Truck extends Vehicle {
    double loadFee;

    Truck(String plateNumber, double baseRate, double loadFee) {
        super(plateNumber, baseRate);
        this.loadFee = loadFee;
    }

    @Override
    double calculateRental(int days) {
        return baseRate * days + loadFee;
    }
}

class Bike extends Vehicle {
    double fixedRate;

    Bike(String plateNumber, double fixedRate) {
        super(plateNumber, fixedRate);
        this.fixedRate = fixedRate;
    }

    @Override
    double calculateRental(int days) {
        return fixedRate;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("BA 1 CHA 1234", 2000),
            new Truck("BA 2 PA 5678", 5000, 3000),
            new Bike("BA 3 MA 9999", 500)
        };

        int rentalDays = 3;
        System.out.println("Rental charges for " + rentalDays + " day(s):");
        System.out.println("------------------------------------");
        for (Vehicle v : vehicles) {
            v.displayRental(rentalDays);
        }
    }
}
