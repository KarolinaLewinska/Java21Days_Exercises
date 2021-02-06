package java21.com;
import javax.swing.*;

public class Authentication extends JFrame  {
    JButton button = new JButton("Log in");
    JLabel username = new JLabel("Username");
    JTextField usernameField = new JTextField(20);
    JLabel password = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField(20);


    public Authentication() {
        super("Authentication");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel authPanel = new JPanel();
        authPanel.add(username);
        authPanel.add(usernameField);
        authPanel.add(password);
        authPanel.add(passwordField);
        authPanel.add(button);
        add(authPanel);
        pack();
        setLookAndFeel();
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exc) {

        }
    }



    public static void main(String[] args) {
	setLookAndFeel();
	Authentication auth1 = new Authentication();
    }
}
