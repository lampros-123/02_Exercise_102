
import javax.swing.AbstractListModel;


/**
 *
 * @author Matthias
 */
public class DateiModel extends AbstractListModel {

    private Datei file;
    
    {
        file = new Datei(".");
    }
    
    @Override
    public int getSize() {
        return file.listFiles().length;
    }

    @Override
    public Object getElementAt(int index) {
        return file.listFiles()[index]  ;
    }
    
}
