package java21.com;

import javax.swing.*;
import java.awt.*;

public class Calendar extends JFrame {
    JLabel number;
    JLabel[] daysNames = new JLabel[7];
    String[] namesOfDays = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
	
    public Calendar() {
        super("Kalendarz na luty");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridLayout lay = new GridLayout(5,7,10,10);
        panel.setLayout(lay); 
        for (int i = 0; i < 7; i++) {
            daysNames[i] = new JLabel(namesOfDays[i]);
            panel.add(daysNames[i]);
        }  
        for (int i = 0; i < 28; i++) {
            number = new JLabel("" + (i + 1));
            panel.add(number);
        }
        add(panel);
        setLookAndFeel();
        pack();
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
		
	}
    }

    public static void main(String[] args) {
	    Calendar feb = new Calendar();
    }
}
