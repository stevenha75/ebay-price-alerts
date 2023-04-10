/*
 * To do:
 * - Make buttons functional & link up w/ the other classes
 * - Decide if a settings button is necessary
 */

package com.ebayalerter;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class gui extends JFrame{
    private static boolean isAddWindowOpen = false;

    public gui() {
        // Creating window
        setTitle("Ebay Price Alerter");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Turns off window resizing

        JPanel buttonPanel = loadButtons();
        // Adding button panel to the east quadrant
        add(buttonPanel, BorderLayout.EAST);

        // Adding the table
        JTable table = new JTable(new NumberedTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Show the window
        setVisible(true);
    }

    public static JPanel loadButtons(){
        // Right aligned button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5,1));
        // Add refresh button
        JButton refreshButton = new JButton("Refresh");
        buttonPanel.add(refreshButton);
        // Add button
        buttonPanel.add(loadAddButton());
        // Remove button
        JButton removeButton = new JButton("Remove");
        buttonPanel.add(removeButton);
        // Modify button
        JButton modifyButton = new JButton("Modify Limit");
        buttonPanel.add(modifyButton);
        // Settings button
        JButton settings = new JButton("Settings");
        buttonPanel.add(settings);

        return buttonPanel;
    }

    /*
     * To do:
     * Add functionality to update the data table
     */
    public static JButton loadAddButton(){
        JButton addButton = new JButton("Add");
        // Making the add button open another window
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Check if an add window is already open
                if (isAddWindowOpen) {
                    return;
                }

                // Set the flag to true to indicate that an add window is open
                isAddWindowOpen = true;

                final JFrame frame = new JFrame("Add item");
                JPanel panel = new JPanel();
                final JTextField linkTextField = new JTextField(20);
                final JTextField doubleTextField = new JTextField(20);
                panel.add(new JLabel("Link:"));
                panel.add(linkTextField);
                panel.add(new JLabel("Price limit:"));
                panel.add(doubleTextField);

                // Add the "Add" button to the panel
                JButton addExecutionButton = new JButton("Add");
                panel.add(addExecutionButton);
        
                /*
                 * To do:
                 * Integrate addItem w/ updating the data in the NumberedTable class
                 * Dynamically update the tableUI
                 */
                // Add an ActionListener to the "Add" button to dispose of the window when clicked
                addExecutionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String link = linkTextField.getText();
                        String priceLimit = doubleTextField.getText();
                        itemList.addItem(link, Double.parseDouble(priceLimit));
                        frame.dispose(); // Close the window
                        isAddWindowOpen = false; // Set the flag to false
                    }
                });
                
                // Add a WindowListener to set the flag to false when the window is closed
                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        isAddWindowOpen = false;
                    }
                });

                frame.add(panel);
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        return addButton;
    }
}
