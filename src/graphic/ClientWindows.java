package graphic;

import TCP.Client;
import TCP.TCPClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Quentin on 14/11/2014.
 */
public class ClientWindows implements ItemListener {

    private Client TCPclient;
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Requète : Afficher";
    final static String TEXTPANEL = "Requète : Ajouter";

    public ClientWindows(Client client) {
        super();
        TCPclient = client;
        JFrame frame = new JFrame("TCP Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
      //  ClientWindows demo = new ClientWindows(client);
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
        cards.add(new PrintCard(),BUTTONPANEL);
        cards.add(new AddCard(TCPclient),TEXTPANEL);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        pane.add(new NameList(), BorderLayout.AFTER_LINE_ENDS);
        pane.add(new HistoricList(),BorderLayout.BEFORE_LINE_BEGINS);

    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
  /*  public static void createAndShowGUI(TCPClient client) {
        //Create and set up the window.
        JFrame frame = new JFrame("TCP Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ClientWindows demo = new ClientWindows();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        TCPclient = client;
    }

      public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
 /*       try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
  //      UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
   /*     javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
*/

}
