package persons;

import java.io.Serializable;
import view.tableModel.Arrayable;

/**
 * This is the PhysicalPerson class, derived from the Client class
 * @author Pedro
 */
public class PhysicalPerson extends Client implements Serializable, Cloneable, Arrayable{

    private int cpf;

    /**
     * This is the constructor of the PhysicalPerson class. This constructor
     * has five parameters
     * @param cpf this is a cpf of PhysicalPerson
     * @param address this is a address of PhysicalPerson
     * @param name this is a name of PhysicalPerson
     * @param email this is a email of PhysicalPerson
     * @param contact this is a contact of PhysicalPerson
     */
    public PhysicalPerson(int cpf, String address, String name, String email, String contact) {
        super(address, name, email, contact);
        this.cpf = cpf;
    }

    @Override
    public String describe() {
        return getName() + sep + this.getEmail() + sep + this.getAddress() + sep + this.getCpf() + sep + this.getContact();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[5];
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
                case "cpf":
                    rsp[rspCount] = this.getCpf();
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
                this.setEmail((String) value);
                break;
            case "endereco":
                this.setAddress((String) value);
                break;
            case "cpf":
                this.setCpf((int) value);
                break;
            case "contato":
                this.setContact((String) value);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * This method get the PhysicalPerson's cpf 
     * @return int
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * This method set the PhysicalPerson's cpf
     * @param cpf this is a cpf
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
}
