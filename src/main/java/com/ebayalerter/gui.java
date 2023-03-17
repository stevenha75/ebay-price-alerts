package com.ebayalerter;

import javax.swing.*;
import java.awt.*;

public class gui extends JFrame{
    public gui() {
        // Creating window
        setTitle("Ebay Price Alerter");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Turns off window resizing

        // Right aligned button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5,1));
        // Add refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, buttonPanel.getPreferredSize().height / 2));
        buttonPanel.add(refreshButton);
        // Add button
        JButton addButton = new JButton("Add");
        buttonPanel.add(addButton);
        // Remove button
        JButton removeButton = new JButton("Remove");
        buttonPanel.add(removeButton);
        // Modify button
        JButton modifyButton = new JButton("Modify");
        buttonPanel.add(modifyButton);
        // Settings button
        JButton settings = new JButton("Settings");
        buttonPanel.add(settings);
        // Adding button panel to the east quadrant
        add(buttonPanel, BorderLayout.EAST);

        // Show the window
        setVisible(true);
    }
}
