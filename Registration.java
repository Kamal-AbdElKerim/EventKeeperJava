public class Registration {
    private String eventId;
    private String participantId;

    public Registration(String eventId, String participantId) {
        this.eventId = eventId;
        this.participantId = participantId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getParticipantId() {
        return participantId;
    }
}
