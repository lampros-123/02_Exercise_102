
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
    
    
    @Override
    public Datei[] listFiles() {
        File[] files = super.listFiles();
        Datei[] dateien = new Datei[files.length];
        
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            dateien[i] = new Datei(file.getAbsolutePath()); 
        }
        return dateien;
    }

    @Override
    public Datei getParentFile() {
        return new Datei(getParent());
    }
    
    
}
