/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents a touple of two types of object
 * @author andre
 */
public class Touple<I, J> implements Serializable{
    private I a;
    private J b;
    
    /**
     * Default constructor
     */
    public Touple() {
    
    }

    /**
     * Constructing and setting the touple attributes
     * @param a the first
     * @param b the second
     */
    public Touple(I a, J b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Getts the first attribute
     * @return an object
     */
    public I getA() {
        return a;
    }

    /**
     * Sets the first attribute
     * @param a an object
     */
    public void setA(I a) {
        this.a = a;
    }

    /**
     * Gets the second attribute
     * @return an object
     */
    public J getB() {
        return b;
    }

    /**
     * Sets the second attibute
     * @param b the other
     */
    public void setB(J b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash + Objects.hashCode(this.a);
        hash = hash + Objects.hashCode(this.b);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Touple<?, ?> other = (Touple<?, ?>) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        return true;
    }
    
    /**
     * This method verifies that element A and element B are empty
     * @return boolean
     */
    
    public boolean isEmpty(){
        return a == null && b == null;
    }
    /**
     * This method checks whether element A or element B is empty
     * @return boolean
     */
    
    public boolean ispartiallyEmpty(){
        return a == null || b == null;
    }
    /**
     * Convert an object to String. Gets a textual representation 
     * of a specific object.
     * @return String
     */
    @Override
    public String toString() {
        String first = (a == null) ? "null" : a.toString();
        String second = (b == null) ? "null" :  b.toString();
        return "{a:"+ first +" , b:"+ second +"}, ";
    }
    
    
}
