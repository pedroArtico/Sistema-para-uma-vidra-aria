package persons;

import java.io.Serializable;
import view.tableModel.Arrayable;

/**
 * This is the LegalPerson class, derived from the Client class
 * @author Pedro
 */
public class LegalPerson extends Client implements Serializable, Cloneable, Arrayable{

    private int cnpj;
    private String companyType;
    private String conpanyDescription;

    /**
     * This is the constructor of the LegalPerson class. This constructor
     * has seven parameters
     * @param cnpj this is a cnpj of LegalPerson class 
     * @param companyType this is a companyType of LegalPerson class
     * @param conpanyDescription this is a conpanyDescription of LegalPerson
     * class
     * @param address this is an address of LegalPerson
     * @param name this is a name of LegalPerson
     * @param email this is an email of LegalPerson
     * @param contact this is a contact of LegalPerson
     */
    public LegalPerson(int cnpj, String companyType, String conpanyDescription, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cnpj = cnpj;
        this.companyType = companyType;
        this.conpanyDescription = conpanyDescription;
    }

    /**
     * This method get the LegalPerson's cnpj
     * @return int
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * This method set the LegalPerson's cnpj
     * @param cnpj this is a cnpj of LegalPerson
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * This method get the LegalPerson's companyType
     * @return String
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * This method set the LegalPerson's companyType
     * @param companyType this is a companyType of LegalPerson
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * This method get the LegalPerson's companyDescription
     * @return String
     */
    public String getConpanyDescription() {
        return conpanyDescription;
    }

    /**
     * This method set the LegalPerson's companyDescription
     * @param conpanyDescription this is a companyDescription of LegalPerson
     */
    public void setConpanyDescription(String conpanyDescription) {
        this.conpanyDescription = conpanyDescription;
    }

    @Override
    public String describe() {
        return this.getName() + sep + this.getEmail() + sep + this.getAddress() + sep + this.getCnpj() + sep + this.getCompanyType()+ sep + this.getConpanyDescription()+ sep + this.getContact();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[7];
        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "nome":
                    rsp[rspCount] = this.getName();
                    break;
                case "email":
                    rsp[rspCount] = this.getEmail();
                    break;
                case "endereco":
                    rsp[rspCount] = this.getAddress();
                    break;
                case "cnpj":
                    rsp[rspCount] = this.getCnpj();
                    break;
                case "tipo":
                    rsp[rspCount] = this.getCompanyType();
                    break;
                case "descricao":
                    rsp[rspCount] = this.getConpanyDescription();
                    break;    
                case "contato":
                    rsp[rspCount] = this.getContact();
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
                this.setEmail(((String) value));
                break;
            case "endereco":
                this.setAddress((String) value);
                break;
            case "cnpj":
                this.setCnpj(((int) value));
                break;
            case "tipo":
                this.setCompanyType((String) value);
                break;
            case "descricao":
                this.setConpanyDescription((String) value);
                break;
            case "contato":
                this.setContact((String) value);
                break;
            default:
                break;
        }
        return this;
    }
}
