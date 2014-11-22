package graphic;

import TCP.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Quentin on 14/11/2014.
 */
public class ClientWindows implements ItemListener {

    private Client client;
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Requète : Afficher";
    final static String TEXTPANEL = "Requète : Ajouter";
    private NameList nameList;

    public ClientWindows(Client client) {
        super();
        this.client = client;
        JFrame frame = new JFrame("TCP Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public void addComponentToPane(Container pane) {

        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(new PrintCard(client),BUTTONPANEL);
        cards.add(new AddCard(client),TEXTPANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        nameList = new NameList();
        pane.add(nameList, BorderLayout.AFTER_LINE_ENDS);
        pane.add(new HistoricList(),BorderLayout.BEFORE_LINE_BEGINS);

    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public NameList getNameList() {
        return nameList;
    }
}
