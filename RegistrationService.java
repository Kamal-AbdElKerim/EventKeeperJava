import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationService {
    private List<Registration> registrations;


    public RegistrationService() {
        this.registrations = new ArrayList<>();
     

    }

    public void registerParticipantToEvent(int eventId, int participantId ,Participant participant ,Event event) {
        
        registrations.add(new Registration(eventId, participantId , participant , event ));
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


    public List<Registration> listAllRegistrations() {
        return new ArrayList<>(registrations);
    }

}
