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
        
        // Set the layout manager
        setLayout(new BorderLayout());

        // Item List Label
        JLabel itemList = new JLabel("Item List");
        // Set the horizontal alignment of the label to left
        itemList.setHorizontalAlignment(JLabel.LEFT);
        // Set the font size of the label
        itemList.setFont(new Font("Arial", Font.BOLD, 25));
        // Add the label to the NORTH region of the layout manager
        add(itemList, BorderLayout.NORTH);

        // Right aligned buttons
        // Small refresh button

        // Add button
        JButton addButton = new JButton("Click me!");
        add(addButton, BorderLayout.EAST);

        // Remove button
        JButton removeButton = new JButton("Click me!");
        add(removeButton, BorderLayout.EAST);

        // Modify button
        JButton modifyButton = new JButton("Click me!");
        add(modifyButton, BorderLayout.EAST);

        // Settings button
        JButton settings = new JButton("Click me!");
        add(settings, BorderLayout.EAST);

        // Show the window
        setVisible(true);
    }
}
