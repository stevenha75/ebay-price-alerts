/*
 * To do:
 * - Empty the temporary table values
 * - Link up this class w/ the itemList class
 * - Link up this class with the GUI
 */

package com.ebayalerter;

import javax.swing.table.AbstractTableModel;

public class NumberedTableModel extends AbstractTableModel {
    private String[] columnNames = {"index", "name", "price", "price limit"};
    private Object[][] data = {
        {"Temporary", "$50", "$25"},
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {
            return String.valueOf(row + 1);
        } else {
            return data[row][column - 1];
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        if (column == 0) {
            return String.class;
        } else {
            return getValueAt(0, column).getClass();
        }
    }
}
