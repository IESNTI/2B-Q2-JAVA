package Serie8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanneauFormulaire extends JPanel {
    private JLabel serialLabel, surnameLabel, nameLabel, birthdateLabel, sectionLabel, originLabel;
    private JTextField serialZone, surnameZone, nameZone, birthdateZone, sectionZone;
    private JCheckBox fellow, foreigner;
    private JComboBox originBox;
    private JRadioButton newStudent, reRegistration;
    private ButtonGroup newStudentOrReRegistration;
    private String[] originList = {"Europe", "Afrique", "Asie", "Amérique", "Océanie"};

    public PanneauFormulaire() {
        actionManager actionListener = new actionManager();
        itemManager itemListener = new itemManager();

        this.setLayout(new GridLayout(8, 2, 5, 5));

        serialLabel = new JLabel("Matricule:");
        serialLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(serialLabel);
        serialZone = new JTextField(30);
        serialZone.addActionListener(actionListener);
        this.add(serialZone);

        surnameLabel = new JLabel("Prénom:");
        surnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(surnameLabel);
        surnameZone = new JTextField(30);
        this.add(surnameZone);

        nameLabel = new JLabel("Nom:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(nameLabel);
        nameZone = new JTextField(30);
        this.add(nameZone);

        birthdateLabel = new JLabel("Date de naissance:");
        birthdateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(birthdateLabel);
        birthdateZone = new JTextField(30);
        this.add(birthdateZone);

        sectionLabel = new JLabel("Section:");
        sectionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(sectionLabel);
        sectionZone = new JTextField(30);
        sectionZone.setEnabled(false);
        this.add(sectionZone);

        fellow = new JCheckBox("Boursier");
        this.add(fellow);

        foreigner = new JCheckBox("Etranger");
        foreigner.addItemListener(itemListener);
        this.add(foreigner);

        originLabel = new JLabel("Origine:");
        originLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(originLabel);
        originBox = new JComboBox(originList);
        originBox.setEnabled(false);
        this.add(originBox);

        newStudentOrReRegistration = new ButtonGroup();

        newStudent = new JRadioButton("Nouvel étudiant");
        newStudent.addItemListener(itemListener);
        newStudentOrReRegistration.add(newStudent);
        this.add(newStudent);

        reRegistration = new JRadioButton("Réinscription");
        reRegistration.addItemListener(itemListener);
        newStudentOrReRegistration.add(reRegistration);
        this.add(reRegistration);
    }

    private class itemManager implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem() == foreigner) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    originBox.setEnabled(true);
                } else {
                    originBox.setEnabled(false);
                }
            } else if (e.getItem() == newStudent && e.getStateChange() == ItemEvent.SELECTED && fellow.isSelected()) {
                JOptionPane.showMessageDialog(null, "Veuillez vous rendre au secrétariat !", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            else if (e.getItem() == reRegistration && e.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null, "Veuillez rendre au secrétariat la liste des dispenses demandées !", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class actionManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == serialZone) {
                char firstSerialNumber = e.getActionCommand().charAt(0);
                switch (firstSerialNumber) {
                    case '1':
                        sectionZone.setText("TI");
                        break;
                    case '2':
                        sectionZone.setText("IR");
                        break;
                    case '3':
                        sectionZone.setText("IG");
                        break;
                    case '4':
                        sectionZone.setText("MK");
                        break;
                    case '5':
                        sectionZone.setText("AT");
                        break;
                    case '6':
                        sectionZone.setText("DR");
                        break;
                    case '7':
                        sectionZone.setText("CPT");
                        break;
                    case '8':
                        sectionZone.setText("RG");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La section numéro " + e.getActionCommand() + " est incorrecte!", "Erreur", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }

    }
}