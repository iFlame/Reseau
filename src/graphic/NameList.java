package graphic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quentin on 15/11/2014.
 */
public class NameList extends JPanel {

    private DefaultListModel listModel;

    public NameList() {
        super();
        this.setLayout(new BorderLayout());
        listModel = new DefaultListModel();
        listModel.addElement("MAthis Couste ");
        listModel.addElement("Clement Audry ");
        listModel.addElement("Remi Pourtier ");
        JLabel label = new JLabel("Liste des noms / surnoms : ");

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        this.add(label, BorderLayout.NORTH);
        this.add(list, BorderLayout.SOUTH);
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;
    }

}
