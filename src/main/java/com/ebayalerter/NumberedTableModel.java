package com.ebayalerter;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class NumberedTableModel extends AbstractTableModel {
    private String[] columnNames = { "index", "name", "price", "price limit" };
    // Builds default itemTable with itemList class
    private ArrayList<String[]> data = itemList.buildItemTable();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        String[] rowData = data.get(row);
        if (column == 0) {
            return String.valueOf(row + 1);
        } else {
            return rowData[column - 1];
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
