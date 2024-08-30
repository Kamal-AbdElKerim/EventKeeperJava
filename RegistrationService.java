import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RegistrationService {
    private List<Registration> registrations;
    private EventService eventService;




    public RegistrationService() {
        this.registrations = new ArrayList<>();
        this.eventService = new EventService();

        // this.eventService = eventService;

    }

    public void registerParticipantToEvent(int eventId, int participantId) {
        registrations.add(new Registration(eventId, participantId));
        // System.out.println(registrations);
    }

    // public void unregisterParticipantFromEvent(String eventId, String participantId) {
    //     registrations.removeIf(reg -> reg.getEventId().equals(eventId) && reg.getParticipantId().equals(participantId));
    // }

    // public List<Participant> listEventParticipants(String eventId, ParticipantService participantService) {
    //     List<String> participantIds = registrations.stream()
    //             .filter(reg -> reg.getEventId().equals(eventId))
    //             .map(Registration::getParticipantId)
    //             .collect(Collectors.toList());

    //     return participantService.listParticipants().stream()
    //             .filter(participant -> participantIds.contains(participant.getId()))
    //             .collect(Collectors.toList());
    // }

    public List<Registration> listParticipantEvents(int participantId) {
        List<Registration> filteredRegistrations = registrations.stream()
                .filter(reg -> reg.getParticipantId() == participantId)
                .collect(Collectors.toList());
    
    
        return filteredRegistrations;
    }
    
    

    private Event getEventById(int eventId) {
        System.out.println(eventId);
        Event event = eventService.getEventById(eventId);
        System.out.println("Event with ID " + eventId + ": " + event);
        return event;
    }
    
    
}
