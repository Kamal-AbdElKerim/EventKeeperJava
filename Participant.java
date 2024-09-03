public class Participant {
    private int id;
    private String name;
    private String email;

    static int count = 1;

    public Participant(String name, String email) {
        this.id = count;
        this.name = name;
        this.email = email;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "-------------------------------\n" +
                        "ID:      %s\n" +
                        "Name:    %s\n" +
                        "Email:   %s\n" +
                        "-------------------------------",
                id, name, email);
    }

}
