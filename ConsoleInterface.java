import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.Scanner;



public class ConsoleInterface {
    private EventService eventService;
    private ParticipantService participantService;
    private RegistrationService registrationService;
    private Scanner scanner;

    

    public ConsoleInterface() {
        this.eventService = new EventService();
        this.participantService = new ParticipantService();
        this.registrationService = new RegistrationService();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Role Admin");
            System.out.println("2. Role User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    RoleAdmin();
                    break;
                case 2:
                    RoleUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
  
    }

    private void RoleAdmin() {

        while (true) {
            System.out.println("Dashboard:");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Participants");
            System.out.println("3. Manage rapports");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageEvents();
                    break;
                case 2:
                    manageParticipants();
                    break;
                case 3:
                    // manageRegistrations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private void RoleUser() {
     

    }

    private void manageEvents() {
        while (true) {
            System.out.println("Event Management:");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. List Events");
            // System.out.println("5. Search Events");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    listEvents();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageParticipants() {
        while (true) {
            System.out.println("Participant Management:");
            System.out.println("1. Add Participant");
            System.out.println("2. Update Participant");
            System.out.println("3. Delete Participant");
            System.out.println("4. List Participants");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParticipant();
                    break;
                case 2:
                    updateParticipant();
                    break;
                case 3:
                    deleteParticipant();
                    break;
                case 4:
                    listParticipants();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // private void manageRegistrations() {
    //     while (true) {
    //         System.out.println("Manage Participants:");
    //         System.out.println("1. Register Participant");
    //         System.out.println("2. Update Participant");
    //         System.out.println("3. Delete Participant");
    //         System.out.println("4. List Participant");
    //         System.out.println("5. Back to Main Menu");
    //         System.out.print("Choose an option: ");
    //         int choice = Integer.parseInt(scanner.nextLine());

    //         switch (choice) {
    //             case 1:
    //                 registerParticipant();
    //                 break;
    //             case 2:
    //                 // UpdateParticipant();
    //                 break;
    //             case 3:
    //                 // DeleteParticipant();
    //                 break;
    //             case 4:
    //                 // listParticipants();
    //                 break;
    //             case 5:
    //                 return;
    //             default:
    //                 System.out.println("Invalid choice. Please try again.");
    //         }
    //     }
    // }

    // private void manageRegistrations() {
    //     while (true) {
    //         System.out.println("Registration Management:");
    //         System.out.println("1. Register Participant to Event");
    //         System.out.println("2. Unregister Participant from Event");
    //         System.out.println("3. List Participants of Event");
    //         System.out.println("4. List Events for a Participant");
    //         System.out.println("5. Back to Main Menu");
    //         System.out.print("Choose an option: ");
    //         int choice = Integer.parseInt(scanner.nextLine());

    //         switch (choice) {
    //             case 1:
    //                 registerParticipantToEvent();
    //                 break;
    //             case 2:
    //                 unregisterParticipantFromEvent();
    //                 break;
    //             case 3:
    //                 listParticipantsOfEvent();
    //                 break;
    //             case 4:
    //                 listEventsForParticipant();
    //                 break;
    //             case 5:
    //                 return;
    //             default:
    //                 System.out.println("Invalid choice. Please try again.");
    //         }
    //     }
    // }

    private void addEvent() {
       
        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Event Date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter Event Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Event Type: ");
        String type = scanner.nextLine();

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            Event event = new Event( name, date, location, type);
            eventService.addEvent(event);
            System.out.println("Event added successfully.");
           
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    private void updateEvent() {
        listEvents();
        System.out.print("Enter Event ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Event event = eventService.getEventById(id);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        // Update Event Name
        System.out.println("Current Event Name: " + event.getName());
        System.out.print("Enter new Event Name (or press Enter to keep the current name): ");
        String newName = scanner.nextLine();
        if (newName.trim().isEmpty()) {
            newName = event.getName();
            
        } 

        // Update Event Date
        Date newDate = event.getDate(); // Default to current date
       
        boolean isData = true ;
   

        while (isData) {
            System.out.print("Enter new Event Date (yyyy-MM-dd) or press Enter to keep the current date: ");
            String dateStr = scanner.nextLine();
            if (!dateStr.trim().isEmpty()) {
                try {
                    newDate = dateFormat.parse(dateStr);
                    isData = false;
                    
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                }
            } else {
                isData = false;
            }
        }
     

        // Update Event Location
        System.out.print("Enter new Event Location or press Enter to keep the current location: ");
        String newLocation = scanner.nextLine();
        if (newLocation.trim().isEmpty()) {
            newLocation = event.getLocation();
        } 

        // Update Event Type
        System.out.print("Enter new Event Type or press Enter to keep the current type: ");
        String newType = scanner.nextLine();
        if (newType.trim().isEmpty()) {
            newType = event.getType();
        } 

        // Update the Event
        try {
            Event updatedEvent = new Event(newName, newDate, newLocation, newType);
            eventService.updateEvent(id, updatedEvent);
            System.out.println("Event updated successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while updating the event: " + e.getMessage());
        }
    
    }

    private void deleteEvent() {
        listEvents();
        System.out.print("Enter Event ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        eventService.deleteEvent(id);
        System.out.println("Event deleted successfully.");
    }

    private void listEvents() {
        List<Event> events = eventService.listEvents();
        System.out.println("List of events:");
        events.forEach(event -> System.out.println(event));
    }
    

    private void searchEvents() {
        System.out.print("Enter Event Date (yyyy-MM-dd) [leave blank to skip]: ");
        String date = scanner.nextLine();
        System.out.print("Enter Event Location [leave blank to skip]: ");
        String location = scanner.nextLine();
        System.out.print("Enter Event Type [leave blank to skip]: ");
        String type = scanner.nextLine();

        List<Event> events = eventService.searchEventsByCriteria(
                date.isEmpty() ? null : date,
                location.isEmpty() ? null : location,
                type.isEmpty() ? null : type
        );
        events.forEach(System.out::println);
    }

    private void addParticipant() {

        System.out.print("Enter Participant Name: ");
        String name = scanner.nextLine();
        while (name.trim().isEmpty()) {
            System.out.print("Enter Participant Name (is Required): ");
            name = scanner.nextLine(); 
        }
        System.out.print("Enter Participant Email: ");
        String email = scanner.nextLine();
        while (email.trim().isEmpty()) {
            System.out.print("Enter Participant Email (is Required): ");
            email = scanner.nextLine(); 
        }

        Participant participant = new Participant( name.trim(), email.trim());
        participantService.addParticipant(participant);
        System.out.println("Participant added successfully.");
    }

    private void updateParticipant() {
        listParticipants();
        System.out.print("Enter Participant ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Participant participant = participantService.getParticipantById(id);

         // Update Participant Name
         System.out.println("Current Participant Name: " + participant.getName());
         System.out.print("Enter new Participant Name (or press Enter to keep the current name): ");
         String name = scanner.nextLine();
         if (name.trim().isEmpty()) {
            name = participant.getName();
             
         } 

             // Update Participant email
            System.out.println("Current Participant email: " + participant.getEmail());
            System.out.print("Enter new Participant email (or press Enter to keep the current email): ");
            String email = scanner.nextLine();
            if (email.trim().isEmpty()) {
                email = participant.getEmail();

            } 


        Participant updatedParticipant = new Participant( name, email);
        participantService.updateParticipant(id, updatedParticipant);
        System.out.println("Participant updated successfully.");
    }

    private void deleteParticipant() {
        listParticipants();
        System.out.print("Enter Participant ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        participantService.deleteParticipant(id);
        System.out.println("Participant deleted successfully.");
    }

    private void listParticipants() {
        List<Participant> participants = participantService.listParticipants();
        participants.forEach(System.out::println);
    }

    private void registerParticipant() {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        System.out.print("Enter Participant ID: ");
        String participantId = scanner.nextLine();

        registrationService.registerParticipantToEvent(eventId, participantId);
        System.out.println("Participant registered to event successfully.");
    }

    private void unregisterParticipantFromEvent() {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        System.out.print("Enter Participant ID: ");
        String participantId = scanner.nextLine();

        registrationService.unregisterParticipantFromEvent(eventId, participantId);
        System.out.println("Participant unregistered from event successfully.");
    }

    private void listParticipantsOfEvent() {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        List<Participant> participants = registrationService.listEventParticipants(eventId, participantService);
        participants.forEach(System.out::println);
    }

    private void listEventsForParticipant() {
        System.out.print("Enter Participant ID: ");
        String participantId = scanner.nextLine();
        List<Event> events = registrationService.listParticipantEvents(participantId, eventService);
        events.forEach(System.out::println);
    }
}
