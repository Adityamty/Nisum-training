class TicketBooking {
    private int totalSeats = 5;
    public synchronized void bookTicket(String passengerName, int seatsRequested) {
        System.out.println(passengerName + " is trying to book " + seatsRequested + " seat(s)...");

        if (seatsRequested <= totalSeats) {
            System.out.println("Seats available! Booking confirmed for " + passengerName);
            totalSeats -= seatsRequested;
            System.out.println("Seats left: " + totalSeats);
        } else {
            System.out.println("Not enough seats for " + passengerName + ". Booking failed.");
        }

        System.out.println("--------------------------------");
    }
}

class BookingThread extends Thread {
    private final TicketBooking bookingSystem;
    private final String passengerName;
    private final int seatsRequested;

    public BookingThread(TicketBooking bookingSystem, String passengerName, int seatsRequested) {
        this.bookingSystem = bookingSystem;
        this.passengerName = passengerName;
        this.seatsRequested = seatsRequested;
    }

    public void run() {
        bookingSystem.bookTicket(passengerName, seatsRequested);
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        BookingThread t1 = new BookingThread(bookingSystem, "Alice", 2);
        BookingThread t2 = new BookingThread(bookingSystem, "Bob", 1);
        BookingThread t3 = new BookingThread(bookingSystem, "Charlie", 3);
        BookingThread t4 = new BookingThread(bookingSystem, "Daisy", 1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
