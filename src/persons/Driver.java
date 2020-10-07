package persons;

import java.io.Serializable;
import agenda.neow.agenda.Agenda;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This is the Driver class, derived from the Employee class
 * @author Pedro
 */
public class Driver extends Employee implements Serializable, Descriptible, Arrayable{
    private Agenda agd;
    private licenseTypes driverLicenseType;
    
    /**
     * This is the enum that contains the possible license types that 
     * a driver can have
     */
    public enum licenseTypes {

        /**
         * Two or three-wheel motor vehicle driver, with or without side car.
         * Ex.: Motorcycle, Moped, Moped or Tricycle.
         */
        A,

        /**
         * Driver of vehicles, whose total gross weight does not exceed three
         * thousand five hundred kilograms or whose stocking does not exceed 08
         * (eight) seats, excluding that of the driver. Ex: Automobile, pickup
         * truck, van, utility.
         */
        B,

        /**
         * A driver of vehicles used for the carriage of cargo whose total
         * gross weight exceeds three thousand five hundred kilograms.
         * Ex: truck
         */
        C,

        /**
         * Driver of vehicles, used for the transport of passengers, whose
         * capacity exceeds 08 passengers, excluding the driver.
         * All vehicles in categories "B" and "C". 
         * Ex: Mini bus, Bus.
         */
        D;

        /**
         * obtains the name. Type String
         * @param name name of licence Types
         * @return licenseTypes
         */
        public static licenseTypes getFromName(String name) {
            for (licenseTypes type : licenseTypes.values()) {
                if (type.toString().equals(name)) {
                    return type;
                }
            }
            return licenseTypes.A;
        }
    }
    
    /**
     * This is the constructor of the Driver class. This constructor
     * has seven parameters
     * @param driverLicenseType this is a driverLicenseType of Driver
     * @param personalNumber this is a personalNumber of Driver
     * @param registration this is a registration of Driver
     * @param name this is a name of Driver
     * @param email this is a email of Driver
     * @param contact this is a contact of Driver
     * @param agd this is an object from Agenda of Driver
     */
    public Driver(licenseTypes driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(personalNumber, registration, name, email, contact);
        this.driverLicenseType = driverLicenseType;
        this.agd = agd;
        //this.agenda = new Agenda(5000, 10);
    }

    /**
     * Gets the license Type pf a driver
     * @return licenseTypes 
     */
    public licenseTypes getDriverLicenseType() {
        return driverLicenseType;
    }

    
    @Override
    public String describe() {
        return "DRV" + sep + this.getName() + sep + this.getEmail() + sep + this.getContact()+ sep + this.getPersonalNumber()+ sep + this.getRegistration()+ sep + this.getDriverLicenseType();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[6];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome":
                    rsp[rspCount] = this.getName();
                    break;
                case "email":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "contato":
                    rsp[rspCount] = this.getContact();
                    break;
                case "personal number":
                    rsp[rspCount] = this.getPersonalNumber();
                    break;
                case "registro":
                    rsp[rspCount] = this.getRegistration();
                    break;
                case "licenca":
                    rsp[rspCount] = this.getDriverLicenseType().toString();
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }

    /**
     * Convert an object to String. Gets a textual representation
     * of a specific object.
     * @return String
     */
    @Override
    public String toString() {
        return this.describe();
    }

    /**
     * This method set the Driver's DriverLicenseType
     * @param driverLicenseType the driverLicenseType to set
     */
    public void setDriverLicenseType(licenseTypes driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }
    
    

    @Override
        public Object setValue(String variable, Object value) {
        switch (variable) {
            case "nome":
                this.setName((String) value);
                break;
            case "email":
                this.setEmail((String) value);
                break;
            case "contato":
                this.setContact((String) value);   
                break;
            case "personal number":
                this.setPersonalNumber((int) value);
                break;
            case "registro":
                this.setRegistration((int) value);
                break;
            case "licenca":
                this.setDriverLicenseType(licenseTypes.getFromName((String) value));
                break;
                
            default:
                break;
        }
        return this;
    }

    /**
     ** This method return an object of type Agenda.
     * @return Agenda
     */
    public Agenda getAgd() {
        return agd;
    }
    
    
    
}
