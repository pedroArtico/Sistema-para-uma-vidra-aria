package visit;

import java.io.Serializable;
import java.util.List;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This is the Project class. 
 * This class represents a project made according to the request of a particular
 * client
 * @author Pedro
 */
public class Project implements Serializable, Descriptible, Arrayable{

    private String title;
    private String description;
    private String file;
    private Client client;

    /**
     * This is the constructor of the Project class. This constructor
     * has four parameters
     * @param title is a title of Project
     * @param description is a description of project
     * @param file is a file
     * @param client is a client
     */
    public Project(String title, String description, String file, Client client) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.client = client;
    }

    /**
     * This method get the Project's title
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method set the Project's title
     * @param title is the title of Project
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method get the Project's description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method set the Project's description
     * @param description references to Project's description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method get the Project's file
     * @return String
     */
    public String getFile() {
        return file;
    }

    /**
     * This method set the Project's file
     * @param file is an object of String
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * This method get the Project's client.
     * Returns an object of the client type
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * This method set the Project's client
     * @param client is a client of Project
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String describe() {
        return this.title + sep + this.getDescription()+ sep + this.getFile();
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[3];

        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "titulo":
                    rsp[rspCount] = this.getTitle();
                    break;
                case "descricao":
                    rsp[rspCount] = this.getDescription();
                    break;
                case "arquivo":
                    rsp[rspCount] = this.getFile();
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
            case "titulo":
                this.setTitle((String) value);
                break;
            case "descricao":
                this.setDescription((String) value);
                break;
            case "arquivo":
                this.setFile((String) value);
                break;
            default:
                break;
        }
        return this;
    }
    
}
