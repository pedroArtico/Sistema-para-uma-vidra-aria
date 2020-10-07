/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;

/**
 * Class regarding the FileCouldNotBeCreatetException exception that
 * is derived from FileDoesNotExistException
 * @author andre
 */
public class FileCouldNotBeCreatetException extends FileDoesNotExistException{
/**
 * Constructor of class
 */
    
    public FileCouldNotBeCreatetException() {
        super("The file could not be created.");
    }
/**
 * Another constructor of class
 * @param message this is a message of Exception
 */    
    public FileCouldNotBeCreatetException(String message) {
        super(message);
    }
    
    
}
