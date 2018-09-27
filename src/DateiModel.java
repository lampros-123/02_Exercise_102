
import javax.swing.AbstractListModel;

/**
 *
 * @author Matthias
 */
public class DateiModel extends AbstractListModel<Datei> {

    private Datei file;

    {
        file = new Datei(".");
    }

    @Override
    public int getSize() {
        return file.getChildFiles().size();
    }

    @Override
    public Datei getElementAt(int index) {
        return file.getChildFile(index);
    }

    public void changeDir(int i) {
        if(!file.getChildFile(i).isDirectory())
            return;
        file = file.getChildFile(i);
        fireContentsChanged(this, 0, file.listFiles().length);
    }
}
