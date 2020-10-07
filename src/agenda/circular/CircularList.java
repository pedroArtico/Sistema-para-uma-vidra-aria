/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.circular;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This class uses a <code>ArrayList</code> to simulate a circular list, it can be
 * accessed with negative or grather then the size of the list indexes
 * @author andre
 * @param <E> The object type that the list will hold
 * @see ArrayList
 */
public class CircularList<E> implements List<E>, Iterable<E>, Serializable{
    private final List<E> innerList;
    
    /**
     * A offest mark, describes the index into the original list where the circular
     * list begins and ends
     * If a list has 10 elements and the header is 5, execute <code>.get(0)</code>
     * shall return the fifth element (the element at the index pointed by the header)
     */
    private int head;

    /**
     * Constructor
     * @param initialSize inital size of the list (only allocates it) 
     */
    public CircularList(int initialSize) {
        innerList = new ArrayList<>(initialSize);
        head = 0;
    }
    
    /**
     * Advances the head of the list in one unit
     * @return the new header
     */
    public int advanceHead(){
        return this.advanceHead(1);
    }
    
    /**
     * Backs off the head of the list in one unit
     * @return the new header
     */
    public int backOffHead(){
        return this.backOffHead(1);
    }
    
    /**
     * Advance the head of the list
     * @param amount amount of units to advance
     * @return the new header
     */
    public int advanceHead(int amount){
        this.head = (this.head + amount) % this.innerList.size();
        return this.head;
    }
    
    /**
     * Backs off the head of the list
     * @param amount amount of units to back off
     * @return the new header
     */
    public int backOffHead(int amount){
        this.head = (this.head - amount) % this.innerList.size();
        return this.head;
    }
    
    /**
     * Set a value for the header
     * @param value new value for the header
     */
    public void setHead(int value){
        this.head = value % this.innerList.size();
    }
    
    /**
     * Obtain the value of the head
     * @return the value of the head
     */
    public int getHead(){
        return head;
    }
   
   /**
    * Converts a position in the original list to the matching position in 
    * the circular list
    * @param arrayPos a array index
    * @return a position
    */
    public int arrayPosToCircularPos(int arrayPos){
        if(arrayPos < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (head + arrayPos -1) % this.innerList.size();
    }
    
    /**
     * Converts a position in the circular list to the matching position in 
     * the original list
     * @param circularPos a position
     * @return a position
     */
    public int circularPosToArrayPos(int circularPos){
        if(this.innerList.isEmpty()){
            return 0;
        }
        
        int rsp = (head + circularPos) % this.innerList.size(); 
        return Math.abs(rsp);
    }
    /**
 * This method adds a header to the "e"
 * @param e is an object from E
 * @return boolean
 */
    @Override
    public boolean add(E e) {
        advanceHead();
        this.innerList.add(head, e);
        return true;
    }
    /**
 * This method gets a position from the circular list
 * @param index is an index of int type
 * @return E
 */    
    @Override
    public E get(int index) {
        return this.innerList.get(this.circularPosToArrayPos(index));
    }
    /**
 *This method sets a position of object
 * @param index is an index of int type
 * @param element is an object from E
 * @return E
 */        
    @Override
    public E set(int index, E element) {
        return this.innerList.set(this.circularPosToArrayPos(index), element);
    }
    /**
 *This method adds an element to the circular list
 * @param index is an index of int type
 * @param element is an object from E
 */            
    @Override
    public void add(int index, E element) {
        this.innerList.add(this.circularPosToArrayPos(index), element);
    }
    /**
    * This method aremoves an element to the circular list
    * @param index is an index of int type
    * @return E 
 */                   
    @Override
    public E remove(int index) {
         return this.innerList.remove(this.circularPosToArrayPos(index));
    }
    /**
 * This method obtains the index of an object
 * @param o is an index of int type
 * @return int 
 */                 
    @Override
    public int indexOf(Object o) {
        return this.arrayPosToCircularPos(this.innerList.indexOf(o));
    }
    /**
 * This method obtains the size of list
 * @return int
 */    
    @Override
    public int size() {
        return this.innerList.size();
    }
 /**
 * This method check if the list is empty
 * @return boolean
 */   
    @Override
     
    public boolean isEmpty() {
        return this.innerList.isEmpty();
    }
    /**
 * This method check if the list contains an object
     * @param o  is the object
 * @return boolean
 */        
    @Override
    public boolean contains(Object o) {
        return this.innerList.contains(o);
    }
    /**
 * This method removes an object from list
     * @param o is the object
 * @return boolean
 */            
    @Override
    public boolean remove(Object o) {
        return this.innerList.remove(o);
    }
    /**
    * Convert to Array
    * @return Object
    */    
    @Override
    public Object[] toArray() {
        return this.innerList.toArray();
    }
    /**
    * Converts to Array
     * @param <T> has a aray of objects
     * @param a is an object
    * @return Object
    */    
    @Override
    public <T> T[] toArray(T[] a) {
        return this.innerList.toArray(a);
    }
    /**
    * Is a sublist
     * @param fromIndex inicial index
     * @param toIndex from which index
    * @return List
    */    
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.innerList.subList(this.circularPosToArrayPos(fromIndex), this.circularPosToArrayPos(toIndex));
    }
    /**
    * This method assigns the value 0 to the head. This method clears the list
    */    
    @Override
    public void clear() {
       this.head = 0;
       this.innerList.clear();
    }
    /**
    * This method is an iterator
    * @return Iterator
    */ 
    
    @Override
    public Iterator<E> iterator() {
       //return new CircularIterator<>();
       return null;
    }
   

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * Convert an object to String. Gets a textual representation of 
    * a specific object.
    * @return String
    */ 
    @Override
    public String toString() {
        String rsp = "";
        
        System.out.println(head);
        for(int i = 0; i < this.size(); i++){
            rsp += "[" + this.get(i).toString() +"]";
        }
        return rsp;
    }
    
    /**
     * Returns a String that describes the list as it is in the original list
     * @return  a string representing the list
     */
    public String toString2() {
        String rsp = "";
        for(E elem : this.innerList){
            rsp += "["+elem.toString()+"]";
        }
        return rsp;
    }
    
    @Override
    public int lastIndexOf(Object o){
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Class that is responsible for doing Override of two Iterator methods
     * @param position;
     *
     */
    
    
    private class CircularListIterator<E> implements Iterator<E>{
        private int position = 0;
        /**
     * This method verify if has a next element
     * return boolean
     */
        @Override
        public boolean hasNext() {
            return position > arrayPosToCircularPos(head - 1);
        }

        @Override
        public E next() {
            throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
