package java21.com;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JFrame {
    public TitlePanel() {
        super("Tytuł ramki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        String iPannel = JOptionPane.showInputDialog(null, "Tytuł ramki","Wpisz tytuł ramki", JOptionPane.PLAIN_MESSAGE);
        setVisible(true);

    }
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception exc) {
            
        }
    }

    public static void main(String[] args) {
        TitlePanel panel1 = new TitlePanel();
    }
}
