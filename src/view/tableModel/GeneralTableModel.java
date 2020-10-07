/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tableModel;
import control.Controller;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persons.Client;
import persons.Employee;
import view.comboboxModel.Descriptible;
import visit.Project;
import visit.Vehicle;
import visit.Visit;

/**
 * This class creates a GeneralTableModel for any object that implements the 
 * Arrayable interface
 * @author andre
 * @param <E> a type
 */
public class GeneralTableModel<E extends Arrayable> extends AbstractTableModel{
    private final String[] columns;
    private final List<E> list;
    private final Controller ctrl;

    /**
     * Contructor
     * @param columns a array of Strings specifing the header of the table
     * @param list a list of objects where each one represents a line of the table
     * @param ctrl a controller
     */
    public GeneralTableModel(String[] columns, List<E> list, Controller ctrl) {
        this.columns = columns;
        this.list = list;
        this.ctrl = ctrl;
    }
    
    @Override
    /**
     * Gets the amount of rows in the table
     */
    public int getRowCount() {
        return list.size();
    }

    @Override
    /**
     * Gets the amount of columns in the table
     */
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    /**
     * Gets a value in a specified position of the table
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        E elem = this.list.get(rowIndex);
        return elem.attributesToArray(this.columns)[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columIndex){
        this.list.get(rowIndex).setValue(this.columns[columIndex], aValue);
        fireTableCellUpdated(rowIndex, columIndex);
    }
    
    @Override
    public String getColumnName(int col) {
        return this.columns[col];
    }
    /**
    * Gets the tObjectAt using as parameter the line
    * @param row this is the rows
    * @return E
     */
    public E getObjectAt(int row){
        System.out.println(row);
        return this.list.get(row);
    }

   
}
