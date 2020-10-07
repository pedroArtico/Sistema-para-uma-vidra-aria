/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

/**
 * Defines a object where the arguments can be descripted as a String
 * @author andre
 */
public interface Descriptible {
    /**
     * Requires a description of the object arguments as a String
     */
    public static final String sep = " | ";
    /**
     * Gets the data of the class and creates a string describing it
     * @return String 
     */
    public String describe();
}

