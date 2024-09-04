import java.util.ArrayList;
import java.util.List;

public class ParticipantService {
    private List<Participant> participants;

    public ParticipantService() {
        this.participants = new ArrayList<>();
    }

    // Login participant
    public Participant Login(String email) {
        for (Participant participant : participants) {
            if (participant.getEmail().equals(email)) {
                return participant;
            }
        }
        return null;
    }

    // Add participants
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    // Update participant
    public void updateParticipant(int participantId, Participant updatedParticipant) {
        for (Participant participant : participants) {
            if (participant.getId() == participantId) {
                participant.setName(updatedParticipant.getName());
                participant.setEmail(updatedParticipant.getEmail());
                break;
            }
        }
    }

    // Delete a participant
    public void deleteParticipant(int participantId) {
        participants.removeIf(participant -> participant.getId() == participantId);
    }

    // Get participant by ID
    public Participant getParticipantById(int participantId) {
        for (Participant participant : participants) {
            if (participant.getId() == participantId) {
                return participant;
            }
        }
        return null;
    }

    // List participants
    public List<Participant> listParticipants() {
        return new ArrayList<>(participants);
    }

}
