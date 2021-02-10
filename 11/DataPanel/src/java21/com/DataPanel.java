package java21.com;

import javax.swing.*;
import java.awt.*;

public class DataPanel extends JFrame {
    JLabel nameLab = new JLabel("Imię", SwingConstants.LEFT);
    JLabel surnLab = new JLabel("Nazwisko", SwingConstants.LEFT);
    JTextField name = new JTextField(30);
    JTextField surname = new JTextField(30);
    JLabel emailLab = new JLabel("Adres email", SwingConstants.LEFT);
    JTextField email = new JTextField(30);
    JLabel phoneLab = new JLabel("Telefon", SwingConstants.LEFT);
    JTextField phone = new JTextField(30);
    DataPanel2 panel2 = new DataPanel2();
    DataPanel3 panel3 = new DataPanel3();
    DataPanel4 panel4 = new DataPanel4();
    DataPanel5 panel5 = new DataPanel5();

    public DataPanel() {
        super("Dane osobowe");
        setSize(350, 450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout lay1 = new FlowLayout();
        setLayout(lay1);
        add(nameLab);
        add(name);
        add(surnLab);
        add(surname);
        add(emailLab);
        add(email);
        add(phoneLab);
        add(phone);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        setLookAndFeel();
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println("Błąd " + exc);
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();
        JFrame panel = new DataPanel();
    }
}

class DataPanel2 extends JPanel {
    JLabel genderLab = new JLabel("Płeć", SwingConstants.LEFT);
    JRadioButton[] genders = new JRadioButton[2];

    DataPanel2() {
        FlowLayout lay2 = new FlowLayout();
        setLayout(lay2);
        genders[0] = new JRadioButton("kobieta ");
        genders[1] = new JRadioButton("mężczyzna");
        add(genderLab);
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton gender : genders) {
            group.add(gender);
            add(gender);
        }
    }
}

class DataPanel3 extends JPanel {
    JLabel aboutMeLab = new JLabel("O mnie  ");
    JTextArea aboutMe = new JTextArea(5, 20);
    JPanel aboutPanel = new JPanel();
    JScrollPane scroll = new JScrollPane(aboutMe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    DataPanel3() {
        BoxLayout lay3 = new BoxLayout(aboutPanel, BoxLayout.LINE_AXIS);
        aboutMe.setLineWrap(true);
        aboutPanel.setLayout(lay3);
        aboutPanel.setLayout(lay3);
        aboutPanel.add(aboutMeLab);
        aboutPanel.add(scroll);
        add(aboutPanel);
    }
}

class DataPanel4 extends JPanel {
    JCheckBox internship = new JCheckBox("Stażysta");
    JCheckBox student = new JCheckBox("Student");
    JCheckBox employee = new JCheckBox("Pracownik");

    DataPanel4() {
        add(internship, false);
        add(student, false);
        add(employee, false);
    }
}

class DataPanel5 extends JPanel {
    JButton save = new JButton("Zapisz dane");
    JButton delete = new JButton("Usuń dane");

    DataPanel5() {
        add(save);
        add(delete);
    }
}

