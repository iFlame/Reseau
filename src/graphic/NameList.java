package graphic;

import TCP.Client;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Quentin on 15/11/2014.
 */
public class NameList extends JPanel implements Observer {

    private DefaultListModel listModel;
    private JList list;

    public NameList() {
        super();
        this.setLayout(new BorderLayout());
        listModel = new DefaultListModel();
        listModel.addElement("MAthis Couste ");
        listModel.addElement("Clement Audry ");
        listModel.addElement("Remi Pourtier ");
        listModel.addElement("Laurene Picandet");
        JLabel label = new JLabel("Liste des noms / surnoms : ");

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        this.add(label, BorderLayout.NORTH);
        this.add(list, BorderLayout.SOUTH);
    }

    public void NameList(DefaultListModel listModel) {
        this.listModel = listModel;
        JLabel label = new JLabel("Liste des noms / surnoms : ");

        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        this.add(label, BorderLayout.NORTH);
    }


    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;
    }

    @Override
    public void update(Observable o, Object arg) {
        listModel.clear();
        HashMap<String, ArrayList<String>> inst1 = (HashMap<String, ArrayList<String>>)arg;
        listModel = new DefaultListModel<String>();
        int i= 0;
        for(Map.Entry<String, ArrayList<String>> entry : inst1.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            if(entry.getValue() != null) {
                for(int k = 0; k < entry.getValue().size(); k++) {
                    String test = entry.getValue().get(k);
                    String retour = "Nom : "+  key + "/ Surnom : " +  test;
                    System.out.println(retour);
                    listModel.add(i,retour);
                }
            } else {
                listModel.add(0,key);
            }
        }
        this.list.setModel(listModel);
    }
}
