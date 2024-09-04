import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

public class EventService {
    private List<Event> events;

    // constructor
    public EventService() {
        this.events = new ArrayList<>();
    }

    // Create and add events
    public void addEvent(Event event) {
        events.add(event);
        // System.out.println(events);
    }

    // Update an event
    public void updateEvent(int eventId, Event updatedEvent) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                event.setName(updatedEvent.getName());
                event.setDate(updatedEvent.getDate());
                event.setLocation(updatedEvent.getLocation());
                event.setType(updatedEvent.getType());
                break;
            }
        }
    }

    // Get event by ID
    public Event getEventById(int eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    // Delete an event
    public void deleteEvent(int eventId) {
        events.removeIf(event -> event.getId() == eventId);
    }

    // Search events by criteria
    public List<Event> searchEventsByCriteria(String date, String location, String type) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return events.stream()
                .filter(event -> {
                    boolean dateMatches = true;
                    if (date != null) {
                        try {
                            Date parsedDate = dateFormat.parse(date);
                            dateMatches = event.getDate().equals(parsedDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                            dateMatches = false;
                        }
                    }
                    return dateMatches &&
                            (location == null || event.getLocation().equals(location)) &&
                            (type == null || event.getType().equals(type));
                })
                .collect(Collectors.toList());
    }

    // List events
    public List<Event> listEvents() {
        return new ArrayList<>(events);
    }

    // Filter events by ID
    public List<Event> filterEventsById(List<Integer> eventIds) {
        return events.stream()
                .filter(event -> eventIds.contains(event.getId()))
                .collect(Collectors.toList());
    }

}
