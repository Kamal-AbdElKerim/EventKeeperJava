import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

public class EventService {
    private List<Event> events;

    public EventService() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
        // System.out.println(events);
    }

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

    public Event getEventById(int eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    public void deleteEvent(int eventId) {
        events.removeIf(event -> event.getId() == eventId);
    }

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

    public List<Event> listEvents() {
        return new ArrayList<>(events);
    }

    public List<Event> filterEventsById(List<Integer> eventIds) {
        return events.stream()
                .filter(event -> eventIds.contains(event.getId()))
                .collect(Collectors.toList());
    }

}
