package persons;

import java.io.Serializable;
import view.comboboxModel.Descriptible;

/**
 *  This is the abstract Employee class, derived from the Person class
 * @author Pedro
 */
public abstract class Employee extends Person implements Serializable, Descriptible{

	private long personalNumber;
	private long registration;

    /**
     * This is the constructor of the abstract Employee class. This constructor
     * has five parameters
     * @param personalNumber this is a personalNumber of Employee
     * @param registration this is a registration of Employee
     * @param name this is a name of Employee
     * @param email this is a email of Employee
     * @param contact this is a contact of Employee
     */
    public Employee(long personalNumber, long registration, String name, String email, String contact) {
        super(name, email, contact);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    /**
     * This is another constructor of the abstract Employee class. This 
     * constructor has three parameters
     * @param personalNumber this is a personal number of type int
     * @param registration this is a registration of type int
     * @param name this is an object from String
     */
    public Employee(long personalNumber, long registration, String name) {
        super(name);
        this.personalNumber = personalNumber;
        this.registration = registration;
    }

    /**
     * This method get the Employee's personalNumber
     * @return int
     */
    public long getPersonalNumber() {
        return personalNumber;
    }

    /**
     * This method set the Employee's personalNumber
     * @param personalNumber  this is the personalNumber of Employee
     */
    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    /**
     * This method get the Employee's registration
     * @return int
     */
    public long getRegistration() {
        return registration;
    }

    /**
     * This method set the Employee's registration
     * @param registration this is the registration of Employee
     */
    public void setRegistration(long registration) {
        this.registration = registration;
    }
}