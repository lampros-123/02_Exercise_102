
import java.util.Comparator;


/**
 *
 * @author Matthias
 */
public class FileComparer implements Comparator<Datei>{

    @Override
    public int compare(Datei d1, Datei d2) {
        if(d1.isDirectory() && !d2.isDirectory()) return -1;
        if(!d1.isDirectory() && d2.isDirectory()) return 1;
        return d1.getName().compareTo(d2.getName());
    }
    
}
