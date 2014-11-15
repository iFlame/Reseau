package graphic;

import TCP.Client;
import TCP.TCPClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quentin on 15/11/2014.
 */
public class AddCard extends JPanel implements ActionListener {

    private JTextField name;
    private JTextField nickname;
    private Client client;

    public AddCard(Client client) {
        super();
        this.client = client;

        name = new JTextField("Nom",20);
        this.add(name);

        nickname = new JTextField("Surnom",20);
        this.add(nickname);


        JButton add = new JButton("Ajouter");
        add.addActionListener(this);
        this.add(add);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        client.addNameNickname(this.getName(),this.getNickname());
    }


    public String getName() {
        return name.getText();
    }

    public String getNickname() {
        return nickname.getText();
    }

    public void setClient(Client client) {
        this.client = client;
    }
}