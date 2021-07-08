package java21.com;
import javax.swing.*;

public class Authentication extends JFrame  {
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JButton button = new JButton("Log in");
    JTextField usernameField = new JTextField(20);
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
	    throw exc;
        }
    }
	
    public static void main(String[] args) {
	setLookAndFeel();
	Authentication auth1 = new Authentication();
    }
}
