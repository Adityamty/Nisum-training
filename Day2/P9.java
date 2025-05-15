import java.util.Map;
import java.util.TreeMap;

class EventCalendar {
    private TreeMap<String, String> events = new TreeMap<>();

    public void addEvent(String date, String details) {
        events.put(date, details);
        System.out.println("Event added for " + date);
    }

    public void removeEvent(String date) {
        if (events.remove(date) != null) {
            System.out.println("Event removed for " + date);
        } else {
            System.out.println("No event found for " + date);
        }
    }

    public void displayEvent(String date) {
        System.out.println(events.containsKey(date) ? "Event on " + date + ": " + events.get(date) : "No events on " + date);
    }

    public void displayUpcomingEvents() {
        System.out.println("\nUpcoming Events:");
        events.forEach((date, details) -> System.out.println(date + " - " + details));
    }
}

public class EventCalendarDemo {
    public static void main(String[] args) {
        EventCalendar calendar = new EventCalendar();
        calendar.addEvent("2025-06-01", "Conference Meeting");
        calendar.addEvent("2025-06-10", "Team Outing");
        calendar.displayEvent("2025-06-01");
        calendar.displayUpcomingEvents();
    }
}
