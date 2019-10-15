import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

public class Ticket {
    private Instant entry;
    private Instant exit;

    public void setEntry(){
        entry = Instant.now();
    }

    public Instant getEntry(){
        return entry;
    }

    public void setExit(){
        exit = Instant.now();
    }

    public Instant getExit(){
        return exit;
    }
}
