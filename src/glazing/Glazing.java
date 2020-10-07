package glazing;

import control.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.exceptions.FileCouldNotBeCreatetException;
import view.jframes.MainJFrame;

/**
 * This class contains the principal Main of the java application
 * @author andre
 */
public class Glazing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controller ctrl = new Controller(Controller.loadIt());
        /**
        PhysicalPerson[] pp = new PhysicalPerson[2];
        LegalPerson[] lp = new LegalPerson[1];
        Driver[] drvs = new Driver[3];
        Project[] prjs = new Project[3];
        Vehicle[] vehs = new Vehicle[3];
        
        pp[0] = new PhysicalPerson(1, "Rua 3", "Adamastor", "ada@mastor", "123-456");
        pp[1] = new PhysicalPerson(2, "Rua 2", "Maria Antonieta", "ada@mastor", "123-456");
        lp[0] = new LegalPerson(3, "Unk", "Unk", "Rua 3", "Mastor Ado", "ada@mastor", "123-456");
        
        
        //TODO: atualizar (criar agendas dos funcionários)
        
        
       NoWorkPattern nwp = new NoWorkPattern();
        
        
        nwp.appendPatternEveryDayWithFromTo(LocalTime.of(18, 0), LocalTime.of(6, 0));
        nwp.appendPatternEveryDayWithFromTo(LocalTime.of(0, 1), LocalTime.of(23, 59), WeekDays.WeekDaysEnum.SUNDAY);
        
        
        
        Agenda agd = new Agenda(nwp);
        
        drvs[0] = new Driver(Driver.licenseTypes.A, 123, 125, "Josué", "josu@e.josue", "Rua3", agd);
        drvs[1] = new Driver(Driver.licenseTypes.A, 123, 125, "Josefa", "josu@efa", "Rua3", agd);
        drvs[2] = new Driver(Driver.licenseTypes.A, 123, 125, "Cleusa", "cleu@sa", "Rua88", agd);
        
        vehs[0] = new Vehicle(Vehicle.licenseTypes.C, Vehicle.vehicleTypes.CAR, "ABC-4567", "infos", agd);
        vehs[1] = new Vehicle(Vehicle.licenseTypes.A, Vehicle.vehicleTypes.MOTORCYCLE, "ABC-1238", "infos", agd);
        vehs[2] = new Vehicle(Vehicle.licenseTypes.D, Vehicle.vehicleTypes.TRUCK, "ABC-3123", "infos", agd);
        
        prjs[0] = new Project("Prj1", "D-prj1", "", pp[0]);
        prjs[1] = new Project("Prj2", "D-prj2", "", pp[1]);
        prjs[2] = new Project("Prj3", "D-prj3", "", lp[0]);

        for(PhysicalPerson cli : pp){
            ctrl.append(cli);
        }
        
        for(LegalPerson cli : lp){
            ctrl.append(cli);
        }
        
        
        for(Driver drv : drvs){
            ctrl.append(drv);
        }
  //      
        for(Vehicle veh : vehs){
            ctrl.append(veh);
        }
  //      
       for(Project proj : prjs){
            ctrl.append(proj);
        }
  //      
  //      **/
        MainJFrame iniframe = new MainJFrame(ctrl);
        iniframe.setVisible(true);
        
        try {
            ctrl.persistIt();
        } catch (FileCouldNotBeCreatetException ex) {
            Logger.getLogger(Glazing.class.getName()).log(Level.SEVERE, null, ex);
        }    

    }
}
