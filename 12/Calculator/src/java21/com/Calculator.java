package java21.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JTextField value1 = new JTextField("0", 5);
    JTextField value2 = new JTextField("0", 5);
    JButton plusMinus = new JButton("+");
    JButton equals = new JButton("=");
    JLabel label = new JLabel("Podaj liczby");
    JLabel result = new JLabel("");

    public Calculator() {
        super("Kalkulator");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        plusMinus.addActionListener(this);
        equals.addActionListener(this);
        add(label);
        add(value1);
        add(plusMinus);
        add(value2);
        add(equals);
        add(result);
        setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator1 = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == equals) {
            try {
                int val1 = Integer.parseInt(value1.getText());
                int val2 = Integer.parseInt(value2.getText());
                if (plusMinus.getText().equals("+")) {
                    result.setText("" + (val1 + val2));
                } else {
                    result.setText("" + (val1 - val2));
                }
            } catch (NumberFormatException exc) {
                value1.setText("0");
                value2.setText("0");
                result.setText("0");
            }
        }
        if (e.getSource() == plusMinus) {
            if (plusMinus.getText().equals("+")) {
                plusMinus.setText("-");
            } else {
                plusMinus.setText("+");
            }
        }
    }
}
