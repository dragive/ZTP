package com.company;

import javax.swing.table.AbstractTableModel;

public class Adapter extends AbstractTableModel {
    private Data content;

    public void setContent(Data content) {
        this.content = content;
        fireTableDataChanged();
    }

    public Adapter(Data content) {
        this.content = content;
    }

    @Override
    public int getRowCount() {
        return content.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row,int column) {
        if (column==0) return row;
        else if(column==1) return content.get(row);
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==0) return false;
        if (columnIndex==1) return true;
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1) content.set(rowIndex,Integer.valueOf(aValue.toString()));
        super.setValueAt(aValue, rowIndex, columnIndex);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }
}
