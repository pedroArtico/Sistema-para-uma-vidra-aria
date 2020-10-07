package persons;

import java.io.Serializable;
import agenda.neow.agenda.Agenda;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This class is an Assembler derived from Driver class
 * @author Pedro
 */
public class Assembler extends Driver implements Serializable, Cloneable, Descriptible, Arrayable{

    /**
     * This is the constructor of the Assembler class
     * @param driverLicenseType this is the driverLicenseType of Assembler
     * @param personalNumber this is the personalNumber of Assembler
     * @param registration this is the registration of Assembler
     * @param name this is the name of Assembler
     * @param email this is the email of Assembler
     * @param contact this is the contact of Assembler
     * @param agd this is an object from Agenda
     */
    public Assembler(licenseTypes driverLicenseType, int personalNumber, int registration, String name, String email, String contact, Agenda agd) {
        super(driverLicenseType, personalNumber, registration, name, email, contact, agd);
    }
    @Override
    public String describe() {
        return "ASS" + sep + this.getName() + sep + this.getEmail()+ sep + this.getContact()+ sep + this.getPersonalNumber()+ sep + this.getRegistration() + sep + this.getDriverLicenseType();
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
            case "licenca":
                this.setDriverLicenseType(licenseTypes.getFromName((String) value));
                break;
                
            default:
                break;
        }
        return this;
    }
}
