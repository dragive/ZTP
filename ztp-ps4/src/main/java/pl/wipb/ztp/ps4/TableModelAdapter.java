package pl.wipb.ztp.ps4;

import javax.swing.table.AbstractTableModel;

public class TableModelAdapter extends AbstractTableModel {

    private Data content;

    public void setContent(Data content) {
        this.content = content;
        fireTableDataChanged();
    }

    public TableModelAdapter(Data content) {
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
        return content.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex!=0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        if(columnIndex==1) content.set(rowIndex,Integer.parseInt(aValue.toString()));

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }
}
