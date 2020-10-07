/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;
import my.exceptions.InvalidFileNameStringException;

/**
 *
 * @author andre
 * @param <E> a type
 */
public class nLocalPersistence<E extends Serializable> implements ObjectKeeper<E>{
    private static final Logger LOG = Logger.getLogger(nLocalPersistence.class.getName());
    private Object lock = new Object();
    /**
     * Constructor of the class
     */
    public nLocalPersistence() {
        LOG.setLevel(Level.INFO);
    }

    /**
     * Persiste a element of type E in a file where the name depends 
     * on the class of the object and a given String
     * @param elem an element
     * @param name a name
     * @return a boolean
     * @throws FileCouldNotBeCreatetException if the file could not be created
     */
    @Override
    public boolean persist(E elem, String name) throws FileCouldNotBeCreatetException{
        String filename = toFilename(elem.getClass(), name);
        Path serializedFile = FileSystems.getDefault().getPath(filename);
        return serialize(elem, serializedFile);
    }
    
    /**
     * Loads a object from a file using its class and name to generate the filename 
     * @param classOf the class of the file
     * @param name the name of the file
     * @return an object
     * @throws FileDoesNotExistException if the file does not exists
     */
    @Override
    public E load(Class classOf, String name) throws FileDoesNotExistException{
        String filename = toFilename(classOf, name);
        Path serializedFile = FileSystems.getDefault().getPath(filename);
        return loadSerialized(serializedFile);
    } 
    
    
    /**
     * Loads a serialized file to a object of type E
     * @return
     * @throws FileDoesNotExistException 
     */
    private E loadSerialized(Path serializedFile) throws FileDoesNotExistException {
        ObjectInputStream is;
        E data = null;
        try {
            is = new ObjectInputStream(Files.newInputStream(serializedFile));
            data = (E) is.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            LOG.log(Level.SEVERE, "loadSerialized ", ex);
            throw new FileDoesNotExistException();
        }
        return data;
    }
    
    /**
     * Serializes a Object of type E in the given Path
     * @param elem
     * @param serializedFile
     * @return
     * @throws FileCouldNotBeCreatetException 
     */
    private boolean serialize(E elem, Path serializedFile) throws FileCouldNotBeCreatetException{
        try {
            //System.out.println(serializedFile.getFileName());
            ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(serializedFile));
            
            synchronized(lock){
                os.writeObject(elem);
                //os.close();
            }
           
            return true;
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "persist ", ex);
            throw new FileCouldNotBeCreatetException();
        }
    }
    
     /**
     * Creates a filename based on a class and a given string
     * @param classOf the class of the object
     * @param objectName the name of the object
     * @return the filename
     */
    public static String fNameIt(Class classOf, String objectName){
        String nObjectName = objectName;
        nObjectName = nObjectName.replaceAll("[^A-Za-z0-9-\\[\\]]", "");
        
        if(nObjectName.isEmpty()){
            throw new InvalidFileNameStringException("Name given \""+objectName+"\"");
        }
        
        String editedName = "["+classOf+"]["+objectName+"]";
        editedName = editedName.replaceAll("[. ]", "-");
        editedName = editedName.replaceAll("[^A-Za-z0-9-\\[\\]]", "#");
        editedName += ".dat";
        editedName = "_SERIALZED." + editedName;
        return editedName;
    }    

    @Override
    public String toFilename(Class classOf, String objectName) {
        return fNameIt(classOf, objectName);
    }
}
