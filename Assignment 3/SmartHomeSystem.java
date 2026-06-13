// Question 18: Smart Home Automation
// Class Device with field deviceName and method operate().
// Subclasses:
//   Light: operate() turns on light.
//   Thermostat: operate() sets temperature.
//   SecurityCamera: operate() starts recording.
// Demonstrate polymorphism using a Device[] list.

class Device {
    private String deviceName;

    public Device(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() { return deviceName; }

    public void operate() {
        System.out.println(deviceName + " is operating.");
    }
}

class Light extends Device {
    private int brightness;

    public Light(String deviceName, int brightness) {
        super(deviceName);
        this.brightness = brightness;
    }

    @Override
    public void operate() {
        System.out.println("[LIGHT] " + getDeviceName() + " turned ON at " + brightness + "% brightness.");
    }
}

class Thermostat extends Device {
    private double temperature;

    public Thermostat(String deviceName, double temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    @Override
    public void operate() {
        System.out.println("[THERMOSTAT] " + getDeviceName() + " set to " + temperature + "°C.");
    }
}

class SecurityCamera extends Device {
    private String location;

    public SecurityCamera(String deviceName, String location) {
        super(deviceName);
        this.location = location;
    }

    @Override
    public void operate() {
        System.out.println("[CAMERA] " + getDeviceName() + " started recording at: " + location);
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Device[] devices = {
            new Light("Living Room Light", 80),
            new Light("Bedroom Light", 50),
            new Thermostat("Main Thermostat", 22.5),
            new SecurityCamera("Front Door Camera", "Main Entrance"),
            new SecurityCamera("Backyard Camera", "Garden Area")
        };

        System.out.println("===== Smart Home Automation =====");
        System.out.println("Activating all devices...");
        System.out.println();

        for (Device device : devices) {
            device.operate();
        }
    }
}
