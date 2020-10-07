package local.persistence;

import java.io.Serializable;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;

/**
 * 
 * @author andre
 * @param <E> Any class that implements the interface Serializable
 * @see java.io.Serializable
 */
public interface ObjectKeeper<E extends Serializable>{
    public boolean persist(E elem, String name) throws FileCouldNotBeCreatetException;
    public E load(Class classOf, String name) throws FileDoesNotExistException;
    public String toFilename(Class classOf, String objectName);
}
