
import java.awt.Color;
/*
 * Task List:
 * Fix set Background
 * Design and implement a gui
 */

import javax.swing.JFrame;

public class gui extends JFrame{
    public gui() {
        // Creating window
        setTitle("Ebay Price Alerter");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.darkGray); 
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Turns off window resizing
        setVisible(true);
    }
}
