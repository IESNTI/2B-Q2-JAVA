package Serie8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame {

    private Container cont;
    private PanneauFormulaire panneau;

    public Fenetre() {
        super("Inscription à l’IESN");
        setBounds(200, 200, 300, 400);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        panneau = new PanneauFormulaire();
        cont = getContentPane();
        //cont.setLayout(new GridLayout(4,2,5,5));
        cont.add(panneau);
        setVisible(true);
    }
}