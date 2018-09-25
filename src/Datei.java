
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Matthias
 */
public class Datei extends File {
    
    public Datei(String pathname) {
        super(pathname);
    }

    @Override
    public String toString() {
        if(isDirectory()) {
            return getName();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return String.format("%-15s %-20s %d KB", getName(), 
                dtf.format(LocalDateTime.ofEpochSecond(lastModified(), 0, ZoneOffset.UTC)),
                getTotalSpace());
    }
}
