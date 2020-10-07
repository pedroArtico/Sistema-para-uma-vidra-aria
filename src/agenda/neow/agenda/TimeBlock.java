/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.agenda;
import java.io.Serializable;
import visit.Visit;
import agenda.neow.util.WeekDays;
import java.util.List;

/**
 * This class represents a block of time
 * @author andre
 */
public class TimeBlock implements Serializable{
    /**
     * The types of status of the current block
     */
    public enum StatusEnum {
        ALLOCATED(1), NOT_ALLOCATE(2), FREE(0);

        /**
         * Enum's constructor
         */
        public int value;
        StatusEnum(int val) {
            value = val;
        }

        /**
         * Sum of two status
         * @param a first enum
         * @param b second enum
         * @return  0 if the both enums are free. 1, 2 or 3 in other cases
         */
        static public int sum(StatusEnum a, StatusEnum b){
            return a.value + b.value;
        }
        
        /**
         * Sums the current enum with other enum
         * @param b other enum
         * @return  0 if the both enums are free. 1, 2 or 3 in other cases
         */
        public int sum(StatusEnum b){
            return this.value + b.value;
        }
        
        /**
         * Gets the value of the current enum
         * @return a value
         */
        public int getNum(){
            return this.value;
        }
        
        /**
         * Sums n enums, returning a enum representation 
         * @param other enums
         * @return a enum marked as FREE if all enums are FREE. NOT_ALLOCATE if the most enums are NOT_ALLOCATE. ALLOCATED if the most enums are ALLOCATED
         */
        public static StatusEnum sum(StatusEnum... other){
            int sum = 0;
            int allocated = 0;
            int notAllocate = 0;
            
            for(StatusEnum elem : other){
               sum += elem.value;
               if(elem == ALLOCATED){
                   allocated++;
               }else if(elem == NOT_ALLOCATE){
                   notAllocate++;
               }
            }
            if(sum == 0){
                return StatusEnum.FREE;
            }else if(allocated >= notAllocate){
                return StatusEnum.ALLOCATED;
            }else{
                return StatusEnum.NOT_ALLOCATE;
            }
        }
        
        /**
         * Sums n enums, returning a enum representing the 
         * @param other enums
         * @return a enum marked as FREE if all enums are FREE. NOT_ALLOCATE if the most enums are NOT_ALLOCATE. ALLOCATED if the most enums are ALLOCATED
         */
        public static StatusEnum sum(List<StatusEnum> other){
            int sum = 0;
            int allocated = 0;
            int notAllocate = 0;
            
            for(StatusEnum elem : other){
               sum += elem.value;
               if(elem == ALLOCATED){
                   allocated++;
               }else if(elem == NOT_ALLOCATE){
                   notAllocate++;
               }
            }
            if(sum == 0){
                return StatusEnum.FREE;
            }else if(allocated >= notAllocate){
                return StatusEnum.ALLOCATED;
            }else{
                return StatusEnum.NOT_ALLOCATE;
            }
        }
    }
    
    private Visit task;
    private StatusEnum status;
    private WeekDays.WeekDaysEnum day;

    /**
     * Instantiates a time block setting all the attributes
     * @param task a task
     * @param status a status
     * @param day a day
     */
    public TimeBlock(Visit task, StatusEnum status, WeekDays.WeekDaysEnum day) {
        this.task = task;
        this.status = status;
        this.day = day;
    }

    /**
     * Instantiates a time block marking it as ALLOCATED
     * @param task a task
     * @param day a day
     */
    public TimeBlock(Visit task, WeekDays.WeekDaysEnum day) {
        this.task = task;
        this.status = StatusEnum.ALLOCATED;
        this.day = day;
    }
    
    /**
     * Instantiates a time block marking it as FREE
     * @param day a day
     */
    public TimeBlock(WeekDays.WeekDaysEnum day){
        this.task = null;
        this.status = StatusEnum.FREE;
        this.day = day;
    }
    
    /**
     * Gets the task
     * @return a Visit
     */
    public Visit getTask() {
        return task;
    }

    /**
     * Sets the task
     * @param task a Visit
     */
    public void setTask(Visit task) {
        this.task = task;
    }

    /**
     * Gets the status
     * @return a Status
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the status
     * @param status a status
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Gets the weekday
     * @return a week day
     */
    public WeekDays.WeekDaysEnum getWeekDay() {
        return day;
    }
    
    /**
     * Sets the block as free
     * @deprecated 
     */
    public void setFree(){
        this.task = null;
        this.status = StatusEnum.FREE;
    }
    
    /**
     * Sets the block as free only if it's allocated
     */
    public void setFreeIfAllocated(){
        if(this.isAllocated()){
            this.setFree();
        }
    }
    
    /**
     * Sets the block as allocated
     * @param tsk the task that the time block is allocates for
     */
    public void setAllocated(Visit tsk){
        this.task = tsk;
        this.status = StatusEnum.ALLOCATED;
    }
    
    /**
     * Sets the block status as NOT_ALLOCATE
     */
    public void setNotAllocate(){
        this.task = null;
        this.status = StatusEnum.NOT_ALLOCATE;
    }
    
    /**
     * Tests if the block is free
     * @return true only if the block is marked as FREE
     */
    public boolean isFree(){
        return this.status.equals(StatusEnum.FREE);
    }
    
    /**
     * Tests if the block is allocated
     * @return true only if the block is marked as ALLOCATED
     */
    public boolean isAllocated(){
        return this.status.equals(StatusEnum.ALLOCATED);
    }
    
    /**
     * Tests if the block is marked as NOT_ALLOCATE
     * @return  true only if the block is marked as NOT_ALLOCATE
     */
    public boolean isBlocked(){
        return this.status.equals(StatusEnum.NOT_ALLOCATE);
    }
     /**
     * Convert an object to String. Gets a textual
     * representation of a specific object.
     * @return String
     */
    @Override

    public String toString() {
        return "{" + "task: " + task + ", status: " + status + ", day: " + day.getShortNamePt() + "}, ";
    }
    
    
}
