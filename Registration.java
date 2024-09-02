public class Registration {
    private int eventId;
    private int participantId;
    private Participant participant;
    private Event event;

    public Registration(int eventId, int participantId, Participant participant, Event event) {
        this.eventId = eventId;
        this.participantId = participantId;
        this.participant = participant;
        this.event = event;
    }

    public int getEventId() {
        return eventId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Event: " + (event != null ? event.getName() : "Unknown") +
               ", Participant: " + (participant != null ? participant.getName() : "Unknown");
    }
}
