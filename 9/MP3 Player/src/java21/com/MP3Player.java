package java21.com;

import javax.swing.*;
import java.awt.image.ImagingOpException;


public class MP3Player extends JFrame {
    JButton previous, play, pause, next;

    public MP3Player() {
        super("MP3 player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        ImageIcon playIcon = new ImageIcon("src/java21/icons/play.png");
        ImageIcon pauseIcon = new ImageIcon("src/java21/icons/pause.png");
        ImageIcon nextIcon = new ImageIcon("src/java21/icons/next.png");
        ImageIcon previousIcon = new ImageIcon("src/java21/icons/previous.png");
        play = new JButton("play", playIcon);
        pause = new JButton("pause", pauseIcon);
        next = new JButton("next", nextIcon);
        previous = new JButton("previous", previousIcon);
        panel.add(play);
        panel.add(pause);
        panel.add(next);
        panel.add(previous);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
	    MP3Player mp3 = new MP3Player();
    }
}
