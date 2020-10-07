package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;

/**
 * This is the abstract Client class, derived from the Person class
 * @author Pedro
 */
public abstract class Client extends Person implements Serializable, Descriptible{

    private String address;
        
    /**
     * This is the constructor of the abstract Client class. This constructor
     * has four parameters
     * @param address this is the address of client
     * @param name this is the name of client
     * @param email this is the email of client
     * @param contact this is the contact of client
     */
    public Client(String address, String name, String email, String contact) {
        super(name, email, contact);
        this.address = address;
    }

    /**
     *This is another constructor of the abstract Client class. This 
     * constructor has two parameters
     * @param address this is the address of client 
     * @param name this is the name of client
     */
    public Client(String address, String name) {
        super(name);
        this.address = address;
    }
        
    @Override
    public String describe() {
        return getName() + sep + getEmail();
    }

    /**
     * This method get the Client's address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method set the Client's address
     * @param address this is the address of client
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
}
