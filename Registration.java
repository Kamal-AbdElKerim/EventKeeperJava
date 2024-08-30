public class Registration {
    private int eventId;
    private int participantId;

    public Registration(int eventId, int participantId) {
        this.eventId = eventId;
        this.participantId = participantId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getParticipantId() {
        return participantId;
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Participant ID: " + participantId;
    }
}
