/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;


/**
 * Exception
 * @author andre
 */
public class NotAllowedValueException extends IllegalArgumentException{
    public String message = "Valor inserido não pode ser utilizado";
   
    /**
     * Returns the message of the exception
     * @return a message
     */
    @Override
    public String getMessage(){
        return message;
    }
}
