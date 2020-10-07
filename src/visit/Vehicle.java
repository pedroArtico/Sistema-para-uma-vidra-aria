package visit;

import java.io.Serializable;
import java.util.List;
import agenda.neow.agenda.Agenda;

/**
 * This is the Vehicle class. 
 * This class represents the company's vehicles that are used for technical 
 * visits and delivery of orders 
 * @author Pedro
 */
public class Vehicle implements Serializable, view.comboboxModel.Descriptible, view.tableModel.Arrayable {

    public Vehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
         * Get name of license type
         * @param name is a name
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
     *This is the enum used to store the types of vehicle with which 
     * the glazing works.
     */
    public enum vehicleTypes {

        /**
         *It is a type of vehicle used by the company
         */
        MOTORCYCLE,

        /**
         *It is a type of vehicle used by the company
         */
        CAR,

        /**
         *It is a type of vehicle used by the company
         */
        TRUCK;

        /**
         *This method takes the type of vehicle, given the name
         * @param name is a name of vehicle's type
         * @return vehicleTypes
         */
        public static vehicleTypes getFromName(String name) {
            for (vehicleTypes type : vehicleTypes.values()) {
                if (type.toString().equals(name)) {
                    return type;
                }
            }
            return vehicleTypes.MOTORCYCLE;
        }
    }

    private licenseTypes licence;
    private vehicleTypes vehType;
    private String registration;
    private String info;
    private Agenda agd;

    /**
     * Instantiates a new vechicle
     *
     * @param licence the license that the person driving the vehicle must have to do so (in the Brazilian standard)
     * @param vehType an type of vehicle
     * @param registeation vehicle's plate in the Brazilian standard
     * @param agd an agenda
     * @param info an information field
     */
    public Vehicle(licenseTypes licence, vehicleTypes vehType, String registeation, String info, Agenda agd) {
        this.licence = licence;
        this.vehType = vehType;
        this.registration = registeation;
        this.info = info;
        this.agd = agd;
    }

    /**
     * This method obtains the necessary license for the driver
     * @return licenseTypes
     */
    public licenseTypes getLicenseNeeded() {
        return this.licence;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @return a registration
     */
    public String getRegistration() {
        return this.registration;
    }

    /**
     * A string representing the vehicle's plate in the Brazilian standard
     *
     * @param registration a registration
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * This method gets the info
     * @return String
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method sets the info
     * @param info information of vehicle
     */
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String describe() {
        return this.info + sep + this.vehType.toString() + sep + this.registration + sep + this.licence.toString();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[4];

        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "info":
                    rsp[rspCount] = this.info;
                    break;
                case "tipo":
                    rsp[rspCount] = this.vehType.toString();
                    break;
                case "placa":
                    rsp[rspCount] = this.registration;
                    break;
                case "carteira":
                    rsp[rspCount] = this.licence.toString();
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }

    @Override
    public Object setValue(String variable, Object value) {
        switch (variable) {
            case "info":
                this.info = (String) value;
                break;
            case "tipo":
                this.vehType = vehicleTypes.getFromName((String) value);
                break;
            case "placa":
                this.registration = (String) value;
                break;
            case "carteira":
                this.licence = licenseTypes.getFromName((String) value);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * Get licence of drivers
     * @return licenseTypes
     */
    public licenseTypes getLicence() {
        return licence;
    }

    /**
     * Get the vehicle type
     * @return vehicleTypes
     */
    public vehicleTypes getVehType() {
        return vehType;
    }

    /**
     ** This method return an object of type Agenda.
     * @return Agenda
     */
    public Agenda getAgd() {
        return agd;
    }
    
}
