
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
        return file.listFiles().length + 1;
    }

    @Override
    public Object getElementAt(int index) {
        if(index == 0) {
            return "..";
        }
        return file.listFiles()[index-1];
    }
   public void changeDir(int i) {
        if(i == 0) {
            file = file.getParentFile();
        } else {
            file = file.listFiles()[i-1];
        }
        fireContentsChanged(this, 0, file.listFiles().length);
    }
}
