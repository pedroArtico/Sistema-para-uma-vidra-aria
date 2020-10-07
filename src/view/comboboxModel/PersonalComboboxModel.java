/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 * This class is a comboboxModel
 * @author Pedro
 */
public class PersonalComboboxModel<E extends Descriptible> extends AbstractListModel implements ComboBoxModel {
    private List<E> elemList;
    private String separator;
    private E selected = null; /*(elemList != null && elemList.size() > 0)?elemList.get(0):null;*/
/**
 * Obtains the size of list
 * @return int
 */    
    @Override
    public int getSize() {
        if(this.elemList == null){
            return 0;
        }else{
            return this.elemList.size();
        }
    }
    /**
    * Gets an element at
    * @param index is an index of list
    * @return int
    */    
    @Override
    public E getElementAt(int index) {
        return this.elemList.get(index);
    }
    /**
    * Sets the item that is selected 
    * @param anItem is an object
    */    
    @Override
    public void setSelectedItem(Object anItem) {
        System.out.println("SELECTED!");
        this.selected = (E)anItem;
        fireContentsChanged(this.elemList, 0, this.elemList.size());
    }
    /**
    * Gets the item that is selected 
    * @return Object
    */    
    @Override
    public Object getSelectedItem() {
        return this.selected;
    }
    /**
    * Adds an element to the list 
    * @return element
    */    
    public boolean add(E element){
        this.elemList.add(element);
        fireContentsChanged(this.elemList, 0, this.elemList.size());
        return true;
    }
    
   
    /**
     * Generates a DefaultComboboxModel using the describe() operation to do so
     * @param elemList a elem list
     */
    public void add(List<E> elemList){
        this.elemList = elemList;
    }
    /**
    * Removes an element of list 
    * @return boolean
    */    
    public boolean remove(E element){
        this.elemList.remove(element);
        fireContentsChanged(this.elemList, 0, this.elemList.size());
        return true;
    }
    /**
    * Cleans an element of list 
    * @param element is a element of list
    */    
    public void clear(E element){
        this.elemList.clear();
        fireContentsChanged(this.elemList, 0, this.elemList.size());
    }
}
