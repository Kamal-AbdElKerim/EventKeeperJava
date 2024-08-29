import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationService {
    private List<Registration> registrations;

    public RegistrationService() {
        this.registrations = new ArrayList<>();
    }

    public void registerParticipantToEvent(String eventId, String participantId) {
        registrations.add(new Registration(eventId, participantId));
    }

    public void unregisterParticipantFromEvent(String eventId, String participantId) {
        registrations.removeIf(reg -> reg.getEventId().equals(eventId) && reg.getParticipantId().equals(participantId));
    }

    public List<Participant> listEventParticipants(String eventId, ParticipantService participantService) {
        List<String> participantIds = registrations.stream()
                .filter(reg -> reg.getEventId().equals(eventId))
                .map(Registration::getParticipantId)
                .collect(Collectors.toList());

        return participantService.listParticipants().stream()
                .filter(participant -> participantIds.contains(participant.getId()))
                .collect(Collectors.toList());
    }

    public List<Event> listParticipantEvents(String participantId, EventService eventService) {
        List<String> eventIds = registrations.stream()
                .filter(reg -> reg.getParticipantId().equals(participantId))
                .map(Registration::getEventId)
                .collect(Collectors.toList());

        return eventService.listEvents().stream()
                .filter(event -> eventIds.contains(event.getId()))
                .collect(Collectors.toList());
    }
}
