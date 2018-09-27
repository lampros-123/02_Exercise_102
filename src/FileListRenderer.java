
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


/**
 *
 * @author Matthias
 */
public class FileListRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value.toString());
        label.setOpaque(true);
        if(value instanceof Datei) {
            Datei file = (Datei) value;
            if(file.isDirectory()) {
                label.setForeground(Color.red);
                label.setBackground(new Color(200, 200, 200));
                label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 12));
            } else {
                label.setForeground(Color.blue);
                label.setBackground(new Color(230, 230, 230));
                label.setFont(new Font("Courier New", Font.PLAIN, 12));
            }
        } else {
            label.setForeground(Color.red);
            label.setBackground(new Color(200, 200, 200));
            label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 12));
        }
        
        return label;
    }
    
}
