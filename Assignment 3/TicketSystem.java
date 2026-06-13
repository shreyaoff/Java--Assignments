// Question 14: Transport Ticket System
// Base class Ticket with fields ticketNumber, price and method generateTicket().
// Subclasses:
//   BusTicket: includes seatNumber.
//   TrainTicket: adds coachType.
//   FlightTicket: adds boardingGate.
// Each overrides generateTicket() to print formatted ticket info.

class Ticket {
    private int ticketNumber;
    private double price;

    public Ticket(int ticketNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    public int getTicketNumber() { return ticketNumber; }
    public double getPrice() { return price; }

    public void generateTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Price: $" + price);
    }
}

class BusTicket extends Ticket {
    private int seatNumber;

    public BusTicket(int ticketNumber, double price, int seatNumber) {
        super(ticketNumber, price);
        this.seatNumber = seatNumber;
    }

    @Override
    public void generateTicket() {
        System.out.println("======= BUS TICKET =======");
        super.generateTicket();
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("==========================");
    }
}

class TrainTicket extends Ticket {
    private String coachType;

    public TrainTicket(int ticketNumber, double price, String coachType) {
        super(ticketNumber, price);
        this.coachType = coachType;
    }

    @Override
    public void generateTicket() {
        System.out.println("====== TRAIN TICKET ======");
        super.generateTicket();
        System.out.println("Coach Type: " + coachType);
        System.out.println("==========================");
    }
}

class FlightTicket extends Ticket {
    private String boardingGate;

    public FlightTicket(int ticketNumber, double price, String boardingGate) {
        super(ticketNumber, price);
        this.boardingGate = boardingGate;
    }

    @Override
    public void generateTicket() {
        System.out.println("===== FLIGHT TICKET ======");
        super.generateTicket();
        System.out.println("Boarding Gate: " + boardingGate);
        System.out.println("==========================");
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Ticket[] tickets = {
            new BusTicket(1001, 5.50, 14),
            new TrainTicket(2001, 25.00, "Sleeper AC"),
            new FlightTicket(3001, 199.99, "Gate B7")
        };

        System.out.println("===== Transport Ticket System =====");
        for (Ticket ticket : tickets) {
            ticket.generateTicket();
            System.out.println();
        }
    }
}
