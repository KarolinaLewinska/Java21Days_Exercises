package java21.com;

import java.awt.*;
import javax.swing.*;

public class ProgressMonitor extends JFrame {
    JProgressBar current;
    JTextField numField;
    int num = 0;

    public ProgressMonitor() {
        super("Monitorowanie postępu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(250, 150);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        numField = new JTextField("" + num, 3);
        panel.add(numField);
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        panel.add(current);
        setContentPane(panel);
        setVisible(true);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            numField.setText("" + num);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Wystąpił błąd " + e);
        }
    }

    public static void main(String[] args) {
        ProgressMonitor frame = new ProgressMonitor();
        frame.iterate();
    }
}
