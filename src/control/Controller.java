package control;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import visit.Visit;
import visit.Vehicle;
import visit.Project;
import local.persistence.nLocalPersistence;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;
import persons.Administrator;
import persons.Assembler;
import persons.Draftsman;
import persons.Driver;
import persons.LegalPerson;
import persons.PhysicalPerson;
import persons.Secretary;

public class Controller implements Serializable{

    //Maps
    private Map<String, PhysicalPerson>phisicalPersons;
    private Map<String, LegalPerson>legalPerson;
    private Map<String, Administrator>administrators;
    private Map<String, Assembler>assemblers;
    private Map<String, Draftsman>draftsman;
    private Map<String, Driver>drivers;
    private Map<String, Secretary>secretaries;
    private Map<String, Project>projects;
    private Map<String, Vehicle>vehicles;
    private Map<String, Visit>visits;
    
    
    
    
    /**
     * Instantiates a new controller
     */
    public Controller() {
        this.phisicalPersons	= new TreeMap<>();
		this.legalPerson 		= new TreeMap<>();
		this.administrators 	= new TreeMap<>();
		this.assemblers 		= new TreeMap<>();
		this.draftsman 			= new TreeMap<>();
		this.drivers 			= new TreeMap<>();
		this.secretaries 		= new TreeMap<>();
		this.projects 			= new TreeMap<>();
		this.vehicles 			= new TreeMap<>();
		this.visits 			= new TreeMap<>();
    }
    
    /**
     * Instantiates a new controller copying the parameters from other one
     * @param copy a controller
     */
    public Controller(Controller copy) {
        this();
        this.phisicalPersons = copy.phisicalPersons;
		this.legalPerson 	 = copy.legalPerson;
		this.administrators  = copy.administrators;
		this.assemblers 	 = copy.assemblers;
		this.draftsman 		 = copy.draftsman;
		this.drivers 		 = copy.drivers;
		this.secretaries 	 = copy.secretaries;
		this.projects 		 = copy.projects;
		this.vehicles 		 = copy.vehicles;
		this.visits 		 = copy.visits;
    }
    /**
     * appends a client of type Physical Person
     * @param client is an object from Physical Person
     */    

    public void append(PhysicalPerson client){
        this.phisicalPersons.put(client.describe(),client);
    }
    /**
     * appends a client of type Legal Person
     * @param client is an object from Legal Person
     */        
    public void append(LegalPerson client){
        this.legalPerson.put(client.describe(),client);
    }
    /**
     * appends a employee of type Administrator
     * @param employee is an object administrator
     */        
    public void append(Administrator employee){
        this.administrators.put(employee.describe(),employee);
    }
    /**
     * appends a employee of type Assembler
     * @param employee is an object Assembler
     */
    public void append(Assembler employee){
        this.assemblers.put(employee.describe(),employee);
    }
    /**
     * appends a employee of type Draftsman
     * @param employee is an object Draftsman
     */

    public void append(Draftsman employee){
        this.draftsman.put(employee.describe(),employee);
    }
    /**
     * appends a employee of type Driver
     * @param employee is an object Driver
     */
    public void append(Driver employee){
        this.drivers.put(employee.describe(),employee);
    }
    /**
     * appends a employee of type Secrtary
     * @param employee is an object Secretary
     */
    public void append(Secretary employee){
        this.secretaries.put(employee.describe(),employee);
    }

    
    /**
     * 
     * Adds the submitted object to the projects list 
     * @param project instance of Project class
     * @see Project
     */
    public void append(Project project){
        this.projects.put(project.describe(),project);
    }
    
    /**
     * 
     * Adds the submitted object to the vehicles list 
     * @param vehicle instance of Vehicle class
     * @see Vehicle
     */
    public void append(Vehicle vehicle){
        this.vehicles.put(vehicle.describe(), vehicle);
    }
    
    /**
     * 
     * Adds the submitted object to the visits list 
     * @param visit instance of Visit class
     * @see Visit
     */
    public void append(Visit visit){
        this.visits.put(visit.describe(),visit);
    }
    

    
    /**
     * Removes the given object of projects list if it exists on it
     * @return <tt>true</tt> if the given object was found in projects list and successfully removed
     * @param project instance of class Project
     * @see Project
     */
    public boolean remove(Project project){
        return this.projects.remove(project.describe(), project);
    }
    
    /**
     * Removes the given object of vehicles list if it exists on it
     * @return <tt>true</tt> if the given object was found in vehicles list and successfully removed
     * @param vehicle instance of class Vehicles
     * @see Vehicle
     */
    public boolean remove(Vehicle vehicle){
        //System.out.println(vehicle.getLicence());
        //new ControlHelper<Vehicle>().delete(this.vehicles, vehicle);
        return this.vehicles.remove(vehicle.describe(), vehicle);
    }
    
    /**
     * Removes the given object of visits list if it exists on it
     * @return <tt>true</tt> if the given object was found in visits list and successfully removed
     * @param visit instance of class Visit
     * @see Visit
     */
    public boolean remove(Visit visit){
        return this.visits.remove(visit.describe(), visit);
    }  
    /**
     * Removes a client of type Physical Person
     * @param client is an object Physical Person
     */
    public void remove(PhysicalPerson client){
        this.phisicalPersons.remove(client.describe());
    }
     /**
     * Removes a client of type Legal Person
     * @param client is an object Legal Person
     */
    public void remove(LegalPerson client){
        this.legalPerson.remove(client.describe());
    }
     /**
     * Removes a employee of type Administrator
     * @param employee is an object Administrator
     */
    public void remove(Administrator employee){
        this.administrators.remove(employee.describe());
    }
     /**
     * Removes a employee of type Assembler
     * @param employee is an object Assembler
     */
    public void remove(Assembler employee){
        this.assemblers.remove(employee.describe());
    }
     /**
     * Removes a employee of type Draftsman
     * @param employee is an object Draftsman
     */

    public void remove(Draftsman employee){
        this.draftsman.remove(employee.describe());
    }
     /**
     * Removes a employee of type Driver
     * @param employee is an object Driver
     */
    public void remove(Driver employee){
        this.drivers.remove(employee.describe());
    }
     /**
     * Removes a employee of type Secretary
     * @param employee is an object Secretary
     */
    public void remove(Secretary employee){
        this.secretaries.remove(employee.describe());
    }
     /**
     * Returns a unmodifiableMap of Physical Personal
     * @return Map   
     */    
    public Map<String, PhysicalPerson> getPhysicalPerson(){
        Map<String, PhysicalPerson> rsp = Collections.unmodifiableMap(this.phisicalPersons);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Legal Personal
     * @return Map   
     */        
    public Map<String, LegalPerson> getLegalPerson(){
        Map<String, LegalPerson> rsp = Collections.unmodifiableMap(this.legalPerson);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Administrator
     * @return Map   
     */    
    public Map<String, Administrator> getAdministrator(){
        Map<String, Administrator> rsp = Collections.unmodifiableMap(this.administrators);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Assembler
     * @return Map   
     */    
    public Map<String, Assembler> getAssembler(){
        Map<String, Assembler> rsp = Collections.unmodifiableMap(this.assemblers);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Draftsman
     * @return Map   
     */    
    public Map<String, Draftsman> getDraftsman(){
        Map<String, Draftsman> rsp = Collections.unmodifiableMap(this.draftsman);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Driver
     * @return Map   
     */    
    public Map<String, Driver> getDriver(){
        Map<String, Driver> rsp = Collections.unmodifiableMap(this.drivers);
        return rsp;
    }
     /**
     * Returns a unmodifiableMap of Secretary
     * @return Map   
     */    
    public Map<String, Secretary> getSecretary(){
        Map<String, Secretary> rsp = Collections.unmodifiableMap(this.secretaries);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of projects
     * @return a project map
     */
    public Map<String,Project> getProjects() {
        Map<String,Project> rsp = Collections.unmodifiableMap(this.projects);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of vehicles
     * @return a vehicle map
     */
    public Map<String,Vehicle> getVehicles() {
        Map<String,Vehicle> rsp = Collections.unmodifiableMap(this.vehicles);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of visits
     * @return a visit map
     */
    public Map<String,Visit> getVisits() {
        Map<String,Visit> rsp = Collections.unmodifiableMap(this.visits);
        return rsp;
    }
   
    
    /**
     * Updates a Project using the old one's description
     * @param elem this is an object from class Project
     * @param oldDesc this is an object from class String
     * @return a boolean
     */
    public boolean update(Project elem, String oldDesc){
        return new ControlHelper<>().update(this.projects, oldDesc, elem);
    }
    
    /**
     * Updates a Vehicle using the old one's description
     * @param newVeh a vehicle
     * @param oldVehDescription a description
     * @return a boolean
     */
    public boolean update(Vehicle newVeh, String oldVehDescription){
        return new ControlHelper<Vehicle>().update(this.vehicles, oldVehDescription, newVeh);
    }
    
    /**
     * Updates a Visit using the old one's description
     * @param newVis a visit
     * @param oldVisDescription a description
     * @return a boolean
     */
    public boolean update(Visit newVis, String oldVisDescription){
        return new ControlHelper<Visit>().update(this.visits, oldVisDescription, newVis);
    }
    /**
     * Updates a Physical Person using the old one's description
     * @param elem is an element of Physucal Person
     * @param oldDesc is a String 
     * @return a boolean
     */    
    public boolean update(PhysicalPerson elem, String oldDesc){
        return new ControlHelper<PhysicalPerson>().update(this.phisicalPersons, oldDesc, elem);
    }
    /**
     * Updates a Legal Person using the old one's description
     * @param elem is an element of Legal Person
     * @param oldDesc is a String 
     * @return a boolean
     */        
    public boolean update(LegalPerson elem, String oldDesc){
        return new ControlHelper<LegalPerson>().update(this.legalPerson, oldDesc, elem);
    }
     /**
     * Updates a Administrator using the old one's description
     * @param elem is an element of Administrator
     * @param oldDesc is a String 
     * @return a boolean
     */    
    public boolean update(Administrator elem, String oldDesc){
        return new ControlHelper<Administrator>().update(this.administrators, oldDesc, elem);
    }
        /**
     * Updates a Assembler using the old one's description
     * @param elem is an element of Assembler
     * @param oldDesc is a String 
     * @return a boolean
     */    
    public boolean update(Assembler elem, String oldDesc){
        return new ControlHelper<Assembler>().update(this.assemblers, oldDesc, elem);
    }
        /**
     * Updates a Assembler using the old one's description
     * @param elem is an element of Assembler
     * @param oldDesc is a String 
     * @return a boolean
     */    
    public boolean update(Draftsman elem, String oldDesc){
        return new ControlHelper<Draftsman>().update(this.draftsman, oldDesc, elem);
    }
        /**
     * Updates a Driver using the old one's description
     * @param elem is an element of Driver
     * @param oldDesc is a String 
     * @return a boolean
     */    
    public boolean update(Driver elem, String oldDesc){
        return new ControlHelper<Driver>().update(this.drivers, oldDesc, elem);
    }
     /**
     * Updates a Secretary using the old one's description
     * @param elem is an element of Secretary
     * @param oldDesc is a String 
     * @return a boolean
     */
    public boolean update(Secretary elem, String oldDesc){
        return new ControlHelper<Secretary>().update(this.secretaries, oldDesc, elem);
    }
    
    /*===================================================================*/
    /**
     * Persists the controller using default configurations
     * @return a boolean
     * @throws FileCouldNotBeCreatetException if the file could not be created
     */
    public boolean persistIt() throws FileCouldNotBeCreatetException{
        nLocalPersistence<Controller> pers = new nLocalPersistence<>();
        return pers.persist(this, "__MainController__");
    }
    
    /**
     * Loads the controller using default configurations
     * @return a controller
     */
    public static Controller loadIt(){
        nLocalPersistence<Controller> pers = new nLocalPersistence<>();
        //Controller aux;
        try {
            return pers.load(Controller.class, "__MainController__");//There is a file to be loaded and become a controller object
        } catch (FileDoesNotExistException ex) {
            Controller ctrl =  new Controller();//Thre is no file to be loaded, just load a empty controller
            try {
                pers.persist(ctrl, "__MainController__");
            } catch (FileCouldNotBeCreatetException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);
                System.exit(-1);
            }
            return ctrl;
        }
    }

    public Map<String, Project> getProject() {
           Map<String,Project> rsp = Collections.unmodifiableMap(this.projects);
        return rsp;
}
}
