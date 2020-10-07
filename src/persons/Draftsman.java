package persons;

import agenda.neow.agenda.Agenda;
import java.io.Serializable;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * The Draftsman class is derived from the Driver class.
 * This class represents the Draftsman of the glazing.
 * @author Pedro
 */
public class Draftsman extends Driver implements Serializable, Descriptible, Arrayable{

    /**
     * This is the class constructor (there is only one), which has 7 parameters
     * @param driverLicenseType this is an object from licensetypes
     * @param personalNumber this is an personalNumber of type int
     * @param registration this is an registration of type int
     * @param name this is the name of Draftsman
     * @param email this is the email of Draftsman
     * @param contact this is the contact of Draftsman
     * @param agd this is an Object from Agenda
     */
    public Draftsman(licenseTypes driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(driverLicenseType, personalNumber, registration, name, email, contact, agd);
    }
    @Override
    public String describe() {
        return "DRAFT" + sep + this.getName() + sep + this.getEmail() + sep + this.getContact() + sep + this.getPersonalNumber() + sep + this.getRegistration() + sep + this.getDriverLicenseType();
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
                case "carteira":
                    rsp[rspCount] = this.getDriverLicenseType();
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
            case "carteira":
                this.setDriverLicenseType(licenseTypes.getFromName((String) value));
                
                break;
                
            default:
                break;
        }
        return this;
    }
}
