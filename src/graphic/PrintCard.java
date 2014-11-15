package graphic;

import TCP.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quentin on 15/11/2014.
 */
public class PrintCard extends JPanel implements ActionListener{

    private Client client;

    public PrintCard(Client client) {
        super();
        this.client = client;
        JButton btn = new JButton("Afficher tous");
        btn.addActionListener(this);
        this.add(btn);

        JButton btn2 = new JButton("Afficher un couple");
        btn2.addActionListener(this);
        this.add(btn2);
        this.add(new JTextField("Nom affiché.", 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals( "Afficher tous")) {
            client.printNameNickname();
        } else {
            // TODO : Afficher un couple
        }
    }
}
