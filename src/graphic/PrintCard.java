package graphic;

import javax.swing.*;

/**
 * Created by Quentin on 15/11/2014.
 */
public class PrintCard extends JPanel {

    public PrintCard() {
        super();
        this.add(new JButton("Afficher tous"));
        this.add(new JButton("Afficher un couple"));
        this.add(new JTextField("Nom affiché.",20));
    }
}
