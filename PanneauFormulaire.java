package Serie8;

import javax.swing.*;
import java.awt.*;

public class PanneauFormulaire extends JPanel {
    private JLabel serialLabel, surnameLabel, nameLabel, birthdateLabel, sectionLabel;
    private JTextField serialZone, surnameZone, nameZone, birthdateZone, sectionZone;
    private JCheckBox fellow, foreigner;
    private JComboBox origin;
    private JRadioButton newStudent, reRegistration;

    public PanneauFormulaire() {
        //this.setBounds(50, 50, 380, 200);
        this.setLayout(new GridLayout(4, 2, 5, 5));
        //this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        serialLabel = new JLabel("Matricule:");
        this.add(serialLabel);
        serialZone = new JTextField(30);
        this.add(serialZone);

        surnameLabel = new JLabel("Prénom:");
        this.add(surnameLabel);
        surnameZone = new JTextField(30);
        this.add(surnameZone);
        //this.setLayout(null);
    }
}
