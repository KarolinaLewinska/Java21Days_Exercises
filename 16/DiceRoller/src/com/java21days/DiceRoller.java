package com.java21days;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller extends JFrame {
    class DiceWorker extends SwingWorker {
        int timesToRoll;

        public DiceWorker(int timesToRoll) {
            super();
            this.timesToRoll = timesToRoll;
        }

        protected int[] doInBackground() {
            int[] result = new int[16];
            for (int i = 0; i < this.timesToRoll; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += Math.floor(Math.random() * 6);
                }
                result[sum] = result[sum] + 1;
            }
            return result;
        }
    }

    JTextField[] total = new JTextField[16];
    JTextField quantity;
    JButton roll;
    DiceWorker worker;

    public DiceRoller() {
        super("Rzucanie kostką");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850, 145);
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1, 16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {
            total[i] = new JTextField("0", 4);
            JLabel label = new JLabel((i + 3) + ": ");
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);
            topPane.add(cell);
        }
        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Liczba rzutów: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Rzuć");
        roll.addActionListener(act);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);
        GridLayout frameGrid = new GridLayout(2, 1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);
        setVisible(true);
    }

    PropertyChangeListener change = (event) -> {
        try {
            int[] result = (int[]) worker.get();
            for (int i = 0; i < result.length; i++) {
                total[i].setText("" + result[i]);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    };
    ActionListener act = (event) -> {
        int timesToRoll;
        try {
            timesToRoll = Integer.parseInt(quantity.getText());
            roll.setEnabled(false);
            worker = new DiceWorker(timesToRoll);
            worker.addPropertyChangeListener(change);
            worker.execute();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    };

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println("Wystąpił błąd " + exc);
        }
    }

    public static void main(String[] args) {
        new DiceRoller();
    }
}

