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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class gui extends JFrame{
    private static JTable table; 
    private static boolean isAddWindowOpen = false;
    private static boolean isRemoveWindowOpen = false;
    private static boolean isModifyWindowOpen = false;

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
        table = new JTable(new NumberedTableModel());
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
        buttonPanel.add(loadAddButton());
        buttonPanel.add(loadRemoveButton());
        buttonPanel.add(loadModifyButton());
        // Settings button
        JButton settings = new JButton("Settings");
        buttonPanel.add(settings);

        return buttonPanel;
    }

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
        
                addExecutionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String link = linkTextField.getText();
                        String priceLimit = doubleTextField.getText();
                        itemList.addItem(link, Double.parseDouble(priceLimit));
                        table.setModel(new NumberedTableModel()); // Regenerates the model
                        table.updateUI();
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

    public static JButton loadRemoveButton(){
        JButton removeButton = new JButton("Remove");
        // Making the remove button open another window
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Check if an remove window is already open
                if (isRemoveWindowOpen) {
                    return;
                }

                // Set the flag to true to indicate that an remove window is open
                isRemoveWindowOpen = true;

                final JFrame frame = new JFrame("Remove item");
                JPanel panel = new JPanel();
                final JTextField doubleTextField = new JTextField(20);
                panel.add(new JLabel("Index:"));
                panel.add(doubleTextField);

                // Add the "Remove" button to the panel
                JButton removeExecutionButton = new JButton("Remove");
                panel.add(removeExecutionButton);
        
                removeExecutionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String itemIndex = doubleTextField.getText();
                        itemList.removeItem(Integer.parseInt(itemIndex));
                        table.setModel(new NumberedTableModel()); // Regenerates the model
                        table.updateUI();
                        frame.dispose(); // Close the window
                        isRemoveWindowOpen = false; // Set the flag to false
                    }
                });
                
                // Add a WindowListener to set the flag to false when the window is closed
                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        isRemoveWindowOpen = false;
                    }
                });

                frame.add(panel);
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        return removeButton;
    }

    public static JButton loadModifyButton(){
        JButton modifyButton = new JButton("Modify Limit");
        // Making the Modify Limit button open another window
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Check if an modify window is already open
                if (isModifyWindowOpen) {
                    return;
                }

                // Set the flag to true to indicate that an modify window is open
                isModifyWindowOpen = true;

                final JFrame frame = new JFrame("Modify Limit");
                JPanel panel = new JPanel();
                final JTextField indexTextField = new JTextField(20);
                final JTextField limitTextField = new JTextField(20);
                panel.add(new JLabel("Index:"));
                panel.add(indexTextField);
                panel.add(new JLabel("New limit:"));
                panel.add(limitTextField);

                // Add the "Modify" button to the panel
                JButton modifyExecutionButton = new JButton("Modify");
                panel.add(modifyExecutionButton);
        
                modifyExecutionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String itemIndex = indexTextField.getText();
                        String newLimit = limitTextField.getText();
                        itemList.modifyLimit(Integer.parseInt(itemIndex), Double.parseDouble(newLimit));
                        table.setModel(new NumberedTableModel()); // Regenerates the model
                        table.updateUI();
                        frame.dispose(); // Close the window
                        isModifyWindowOpen = false; // Set the flag to false
                    }
                });
                
                // Add a WindowListener to set the flag to false when the window is closed
                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        isModifyWindowOpen = false;
                    }
                });

                frame.add(panel);
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        return modifyButton;
    }
}
