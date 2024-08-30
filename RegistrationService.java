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



    public List<Registration> listParticipantEvents(int participantId) {
        List<Registration> filteredRegistrations = registrations.stream()
                .filter(reg -> reg.getParticipantId() == participantId)
                .collect(Collectors.toList());
    
    
        return filteredRegistrations;
    }

    public void removeParticipantEvents(int eventId, int participantId) {

        registrations.removeIf(reg -> reg.getEventId() == eventId && reg.getParticipantId() == participantId);
    }
    

}
