package java21.com;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Multiplication extends JFrame implements FocusListener {
    JLabel lab = new JLabel("Podaj liczby");
    JTextField value1 = new JTextField("0", 8);
    JTextField value2 = new JTextField("0", 8);
    JTextField multi = new JTextField("0", 8);

    public Multiplication() {
        super("Mnożenie");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        value1.addFocusListener(this);
        value2.addFocusListener(this);
        multi.addFocusListener(this);
        add(lab);
        add(value1);
        add(value2);
        add(multi);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame obj1 = new Multiplication();
    }

    @Override
    public void focusGained(FocusEvent e) {
        multiply(e.getSource());
    }

    @Override
    public void focusLost(FocusEvent e) {
        multiply(e.getSource());
    }

    private void multiply(Object field) {
        JTextField textField = (JTextField) field;
        try {
            int fieldVal = Integer.parseInt(textField.getText());
            if (fieldVal < 0) {
                fieldVal = fieldVal * -1;
                textField.setText("" + fieldVal);
            }
        } catch (NumberFormatException exc) {
            textField.setText("0");
        }
    }
}
