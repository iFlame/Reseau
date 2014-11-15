package graphic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Quentin on 15/11/2014.
 */
public class HistoricList extends JPanel {

    public HistoricList() {
        super();
        this.setLayout(new BorderLayout());
        DefaultListModel listModel2 = new DefaultListModel();
        JLabel label2 = new JLabel("Historique des requètes : ");

        JList list2 = new JList(listModel2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setSelectedIndex(0);

        this.add(label2,BorderLayout.NORTH);
        this.add(list2,BorderLayout.SOUTH);
    }
}
