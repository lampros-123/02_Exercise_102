
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class Datei extends File {

    ArrayList<Datei> dateien = new ArrayList<>();

    public Datei(String pathname) {
        super(pathname);

    }

    @Override
    public String toString() {
        if (isDirectory()) {
            return getName();
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return String.format("%-15s %-20s %d KB", getName(),
                dtf.format(LocalDateTime.ofEpochSecond(lastModified(), 0, ZoneOffset.UTC)),
                length() / 1000);
    }

    public void loadChildFiles() {
        File[] files = listFiles();

        dateien.add(new Datei(getAbsolutePath() + "/.."));
        for (File file : files) {
            dateien.add(new Datei(file.getAbsolutePath()));
        }
        dateien.sort(new FileComparer());
    }

    public ArrayList<Datei> getChildFiles() {
        if (dateien.isEmpty()) {
            loadChildFiles();
        }
        return dateien;
    }

    public Datei getChildFile(int i) {
        return dateien.get(i);
    }

    @Override
    public Datei getParentFile() {
        return new Datei(getParent());
    }

}
