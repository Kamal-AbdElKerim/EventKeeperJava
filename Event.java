import java.util.Date;
import java.text.SimpleDateFormat;

public class Event {
    private int id;
    private String name;
    private Date date;
    private String location;
    private String type;

    static int IDEvent = 1 ;

    public Event(String name, Date date, String location, String type) {
        this.id = IDEvent;
        this.name = name;
        this.date = date;
        this.location = location;
        this.type = type;
        IDEvent++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);

        return 
                id + "-" +
                " name= " + name + 
                " , date= " + formattedDate +
                " , location= " + location  +
                " , type= " + type ;
                
    }

    
}
