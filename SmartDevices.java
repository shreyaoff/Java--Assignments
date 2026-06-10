// Question 1: SmartDevice Hierarchy
// Create a base class SmartDevice with fields: brand, model, and methods turnOn() and turnOff().
// Create subclasses: SmartPhone and SmartWatch.
// Override turnOn() and turnOff() in both subclasses to show device-specific behavior.
// Instantiate devices and call their methods to demonstrate runtime polymorphism.

class SmartDevice {
    String brand;
    String model;

    SmartDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void turnOn() {
        System.out.println(brand + " " + model + " is turning on...");
    }

    void turnOff() {
        System.out.println(brand + " " + model + " is turning off...");
    }
}

class SmartPhone extends SmartDevice {
    SmartPhone(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " phone is booting up. Loading apps...");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " phone is shutting down. Goodbye!");
    }
}

class SmartWatch extends SmartDevice {
    SmartWatch(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " watch is on. Syncing health data...");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " watch is off. Sleep tracking stopped.");
    }
}

public class SmartDevices {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartPhone("Samsung", "Galaxy S24"),
            new SmartWatch("Apple", "Watch Series 9"),
            new SmartPhone("OnePlus", "12R")
        };

        for (SmartDevice device : devices) {
            device.turnOn();
            device.turnOff();
            System.out.println();
        }
    }
}
