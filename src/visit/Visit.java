package visit;

import agenda.neow.util.TimeUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import persons.Client;
import persons.Driver;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This is the Visit class. 
 * This class is responsible for the data regarding the technical visit
 * made to the client.  
 * @author Pedro
 */
public class Visit implements Serializable, Descriptible, Arrayable{

    private LocalDateTime start;
    private LocalDateTime finish;
    private int status;
    private String description;
    private String name;
    private Project project;
    private List<Driver> visitor;
    private Client client;
    private Vehicle vehicle;

    /**
     * This is the constructor of the Visit class. This constructor
     * has six parameters
     * @param start this is an object from class LocalDateTime
     * @param finish this is an object from class LocalDateTime
     * @param name this is an object from class String
     * @param visitor this is an object from List
     * @param client this is an object from Client
     * @param vehicle this is an object from Vehicle
     */
    public Visit(LocalDateTime start, LocalDateTime finish, String name, List<Driver> visitor, Client client, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.name = name;
        this.visitor = visitor;
        this.client = client;
        this.vehicle = vehicle;
    }

    /**
     * This method set the Visit's name
     * @param name this is a name
     */
    public Visit(String name) {
        this.name = name;
    }
    
    /**
     * Starts a date
     * @return LocalDateTime
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Sets a initial date
     * @param start is the first date
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * Gets a finish date
     * @return LocalDateTime
     */
    public LocalDateTime getFinish() {
        return finish;
    }

    /**
     * Sets a finish date
     * @param finish is the last date 
     */
    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    /**
     * Gets the status
     * @return int 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status
     * @param status is the status from Visit
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Sets a description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a description
     * @param description is the description of Visit realized 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets a project 
     * @return Project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets a project
     * @param project is the Project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets a list of drivers
     * @return List
     */
    public List<Driver> getVisitor() {
        return visitor;
    }

    /**
     * Sets a list of drivers
     * @param visitor is the person that visit the client
     */
    public void setVisitor(List<Driver> visitor) {
        this.visitor = visitor;
    }

    /**
     * Gets a client
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets a client
     * @param client is the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets a vehicle
     * @return Vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets a vehicle
     * @param vehicle is the vehicle of Glazing
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Gets a name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a name
     * @param name is the name of vehicle
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String describe() {
       // String cli = (this.getClient().getName() == null)? "null" : this.client.getName();
        String proj = (this.project == null || this.getProject().getTitle() == null) ? "null" : this.project.getTitle();
        String rsp = "";
        rsp = this.name + sep 
                + TimeUtil.toCompleteString(this.start) + sep
                + TimeUtil.toCompleteString(this.finish) + sep
                + proj + sep 
                + proj;
        return rsp;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[3];

        int rspCount = 0;
        for (String s : order) {
                
                switch (s) {
                case "name":
                    rsp[rspCount] = this.getName();
                    break;
                    
                case "start data":
                    rsp[rspCount] = TimeUtil.toCompleteString(this.start);
                    break;
                case "finish data":
                    rsp[rspCount] =TimeUtil.toCompleteString(this.finish);
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
            case "name":
                this.setName((String) value);
                break;
                
            case "start data":
                TimeUtil.fromCompleteString((String) value);
                break;
            case "finish data":
                TimeUtil.fromCompleteString((String) value);
                break;

            default:
                break;
        }
        return this;
    }
}