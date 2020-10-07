/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 * This class generates a ComboboxModel for any object that implements the
 * interface Descriptible
 * @author andre
 * @param <E> a type of object
 */
public class GeneralComboboxModel<E extends Descriptible> {
    /**
     * Generates a DefaultComboboxModel using the toString() operation to do so
     * @param elemList a list of elements
     * @return  a ComboBoxMode
     */
    public DefaultComboBoxModel getComboBoxModelUsingToString(List<E> elemList){
        List<String> elemInfo = new ArrayList<>(elemList.size());
        
        for(E element : elemList){
            elemInfo.add(element.toString());
        }
        return new DefaultComboBoxModel(elemInfo.toArray());
    }
   
    /**
     * Generates a DefaultComboboxModel using the describe() operation to do so
     * @param elemList a elem list
     * @return a DefaultComboBoxModel
     */
    public DefaultComboBoxModel getComboBoxModelUsingDescription(List<E> elemList){
        List<String> elemInfo = new ArrayList<>(elemList.size());
        for(E element : elemList){
            String strElemDescription = element.describe();
            elemInfo.add(strElemDescription);
        }
        return new DefaultComboBoxModel(elemInfo.toArray());
    }
    
    /**
     * Gets a name and return a object
     * @param stack a list of object
     * @param needle the searched object
     * @param sep the separator
     * @return an object
     */
    public E nameToObject(List<E> stack, String needle, String sep){
        for(E elem : stack){
            if(elem.describe() == needle){
                return elem;
            }
        }
        return null;
    }
}
