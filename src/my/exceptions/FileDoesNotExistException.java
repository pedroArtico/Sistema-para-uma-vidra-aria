/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class regarding the FileDoesNotExistException exception that
 * is derived from FileNotFoundException
 * @author andre
 */
public class FileDoesNotExistException extends FileNotFoundException{
    /**
 * Constructor of class
 */
    public FileDoesNotExistException() {
        super("The file does not exists.");
    }
    /**
 * Another constructor of class
 * @param  message this is a message from Exception
 */
    public FileDoesNotExistException(String message){
        super(message);
    }
}