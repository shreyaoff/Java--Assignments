// Question 17: Movie Theater Booking System
// Class Seat with field seatNumber and method bookSeat().
// Subclasses:
//   RegularSeat: booking is allowed anytime.
//   PremiumSeat: booking includes snack and luxury tax.
// Use method overriding and encapsulation.

class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() { return seatNumber; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }

    public void bookSeat() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " has been booked.");
        } else {
            System.out.println("Seat " + seatNumber + " is already taken.");
        }
    }
}

class RegularSeat extends Seat {
    private double price;

    public RegularSeat(int seatNumber, double price) {
        super(seatNumber);
        this.price = price;
    }

    @Override
    public void bookSeat() {
        if (!isBooked()) {
            setBooked(true);
            System.out.println("[Regular Seat] Seat " + getSeatNumber() + " booked. Price: $" + price);
        } else {
            System.out.println("[Regular Seat] Seat " + getSeatNumber() + " is already taken.");
        }
    }
}

class PremiumSeat extends Seat {
    private double basePrice;
    private double snackCost;
    private double luxuryTaxRate;

    public PremiumSeat(int seatNumber, double basePrice, double snackCost, double luxuryTaxRate) {
        super(seatNumber);
        this.basePrice = basePrice;
        this.snackCost = snackCost;
        this.luxuryTaxRate = luxuryTaxRate;
    }

    @Override
    public void bookSeat() {
        if (!isBooked()) {
            setBooked(true);
            double tax = basePrice * luxuryTaxRate;
            double totalPrice = basePrice + snackCost + tax;
            System.out.println("[Premium Seat] Seat " + getSeatNumber() + " booked.");
            System.out.println("  Base Price: $" + basePrice);
            System.out.println("  Snack Package: $" + snackCost);
            System.out.println("  Luxury Tax (" + (luxuryTaxRate * 100) + "%): $" + tax);
            System.out.println("  Total: $" + totalPrice);
        } else {
            System.out.println("[Premium Seat] Seat " + getSeatNumber() + " is already taken.");
        }
    }
}

public class TheaterBooking {
    public static void main(String[] args) {
        Seat[] seats = {
            new RegularSeat(5, 10.00),
            new PremiumSeat(1, 25.00, 8.00, 0.15),
            new RegularSeat(12, 10.00)
        };

        System.out.println("===== Movie Theater Booking =====");
        for (Seat seat : seats) {
            seat.bookSeat();
            System.out.println();
        }

        System.out.println("--- Trying to book seat 5 again ---");
        seats[0].bookSeat();
    }
}
