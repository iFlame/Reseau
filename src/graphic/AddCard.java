package graphic;

import Client.ObjectTCPClient;
import Client.VirtualClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Quentin on 15/11/2014.
 */
public class AddCard extends JPanel implements ActionListener {

    private JTextField name;
    private JTextField nickname;
    private VirtualClient client;

    public AddCard(VirtualClient client) {
        super();
        this.client = client;

        name = new JTextField("Nom",20);
        this.add(name);

        nickname = new JTextField("Surnom",20);
        this.add(nickname);


        JButton add = new JButton("Ajouter");
        add.addActionListener(this);
        this.add(add);

        JButton dsiconnect = new JButton("Deconnexion");
        dsiconnect.addActionListener(this);
        this.add(dsiconnect);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ajouter")) {
            client.addNameNickname(this.getName(), this.getNickname());
        } else if (e.getActionCommand().equals("Deconnexion"))  {
            client.disconnect();
        }
    }


    public String getName() {
        return name.getText();
    }

    public String getNickname() {
        return nickname.getText();
    }

    public void setClient(VirtualClient client) {
        this.client = client;
    }
}
