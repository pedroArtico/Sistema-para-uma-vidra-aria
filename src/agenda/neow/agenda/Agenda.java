/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.agenda;

import agenda.neow.nowork.NoWorkPattern;
import agenda.neow.nowork.NoWorkElement;
import agenda.circular.CircularList;
import agenda.neow.agenda.TimeBlock.StatusEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import agenda.neow.util.TimeUtil;
import agenda.neow.util.Touple;
import agenda.neow.util.WeekDays;
import java.util.ArrayList;
import java.util.List;
import visit.Visit;
/**
 * This class manages a agenda
 * The agenda is divided in blocks, each block represents a certain amount of
 * minutes of a day.
 * A circular list is used for representing the agenda, the head of the list
 * points to the most actual block (representing the current date).
 * 
 * Once the agenda is created a <code>NoWorkPattern</code> is applied indicating
 * the days that what is being allocated will not be avaliable
 * 
 * When the head moves, the blocks between the current and old dates are marked 
 * as free and automatically allocated for the same week day of a next week
 * @author andre
 * @see AllocatorConsts
 * @see CircularList
 * @see NoWorkPattern
 */
public class Agenda implements AgendaDefaults, Serializable{
    private CircularList<TimeBlock> agd;
    private LocalDateTime init;
    private NoWorkPattern noWorkPattern;

    /**
     * Constructor for the class
     * @param noWorkPattern a object indicating which days should be marked as blocked
     * @see NoWorkElement
     * @see NoWorkPattern
     * @see CircularList
     */
    public Agenda(NoWorkPattern noWorkPattern) {
        this.noWorkPattern = noWorkPattern;
        agd = new CircularList<>(BLOCKS);
        int minutes = 0;
        int day = 0;

        for (int i = 0; i < BLOCKS; i++) {
            agd.add(i,new TimeBlock(new Visit("tsk" + i), TimeBlock.StatusEnum.FREE, WeekDays.FactoryWeekdays(day)));
            
            if (minutes >= (TimeUtil.minutesInADay)) {
                minutes = 0;
                day = ++day % 7;
            }
            minutes += MIN_PER_BLOCK;
        }
        this.applyNoWorkPattern();
        this.initialize();
    }

    /**
     * Applies the <code>NoWorkPattern</code> in the agenda
     * @see NoWorkElement
     * @see NoWorkPattern
     */
    private void applyNoWorkPattern(){
        for(NoWorkElement nwelem : this.noWorkPattern.getPatterns()){
            if(nwelem.isEveryDay()){
                this.applyNoWorkElemForEveryDay(nwelem);
            }else if(nwelem.isEveryWeekDay()){
                this.applyNoWorkElemForEveryWeekDay(nwelem);
            }
        }
    }
    
    /**
     * Applies the <code>NoWorkPattern</code> in the agenda in the "apply for every day"
     * cases
     * @param nwe a <code>NoWorkElement</code> instance
     */
    private void applyNoWorkElemForEveryDay(NoWorkElement nwe){
        WeekDays.WeekDaysEnum oldDay = this.agd.get(-1).getWeekDay();
        int minutesInDayCount = 0;
        for(int i = 0; i < BLOCKS; i++){
            TimeBlock currenttb = this.agd.get(i);
            if((nwe.getMinutesToBegin()>= minutesInDayCount && nwe.getMinutesToEnd() <= minutesInDayCount) ||
               (nwe.getMinutesToBegin()<= minutesInDayCount && nwe.getMinutesToEnd() >= minutesInDayCount)
                    ){
                currenttb.setNotAllocate();
            }
            minutesInDayCount += MIN_PER_BLOCK;
            if(minutesInDayCount >= TimeUtil.minutesInADay){
                minutesInDayCount = 0;
            }
        }
    }
    
    /**
     * Applies the <code>NoWorkPattern</code> in the agenda in the "apply for every day x in the week"
     * cases
     * @param nwe a <code>NoWorkElement</code> instance
     */
    private void applyNoWorkElemForEveryWeekDay(NoWorkElement nwe){
        WeekDays.WeekDaysEnum oldDay = this.agd.get(-1).getWeekDay();
        int minutesInDayCount = 0;
        
        for(int i = 0; i < BLOCKS; i++){
            TimeBlock currenttb = this.agd.get(i);
            if(currenttb.getWeekDay() == nwe.getDay()  &&
                    (nwe.getMinutesToBegin()>= minutesInDayCount && nwe.getMinutesToEnd() <= minutesInDayCount
                    ||nwe.getMinutesToBegin()<= minutesInDayCount && nwe.getMinutesToEnd() >= minutesInDayCount
                    )){
                currenttb.setNotAllocate();
            }
            minutesInDayCount += MIN_PER_BLOCK;
            if(minutesInDayCount >= TimeUtil.minutesInADay){
                minutesInDayCount = 0;
            }
        }
    }
    
    /**
     * Sums agendas (to find free blocks in common)
     * @param agds agendas
     * @return the sum of the agendas
     */
    public static Agenda sum(Agenda... agds){
        NoWorkPattern[] patterns = new NoWorkPattern[agds.length];
        for(int i = 0; i < agds.length -1; i++){
            patterns[i] = agds[i].noWorkPattern;
        }

        NoWorkPattern masterNwp = NoWorkPattern.merge(patterns);
        Agenda supAgenda = new Agenda(masterNwp);
        
        for(int i = 0; i < BLOCKS; i++){
            TimeBlock.StatusEnum[] stts = new TimeBlock.StatusEnum[agds.length];
            for(int j = 0; j < agds.length -1; j++){
                TimeBlock tElem = agds[i].agd.get(i);
                stts[i] = tElem.getStatus();
            }
            supAgenda.agd.get(i).setStatus(TimeBlock.StatusEnum.sum(stts));
        }
        return supAgenda;
    }
    /**
     * Sums agendas in list form
     * @param agds Agenda
     * @return the sum of the agendas
     */
    
    public static Agenda sum(List<Agenda> agds){
        List<NoWorkPattern> patterns = new ArrayList<>(agds.size());
        for(int i = 0; i < agds.size() -1; i++){
            patterns.add(agds.get(i).getNoWorkPattern());
        }

        NoWorkPattern masterNwp = NoWorkPattern.merge(patterns);
        Agenda supAgenda = new Agenda(masterNwp);
        
        for(int i = 0; i < BLOCKS; i++){
            List<StatusEnum> stts = new ArrayList<>(agds.size());
            for(int j = 0; j < agds.size(); j++){
                TimeBlock tElem = agds.get(j).agd.get(i);
                stts.add(tElem.getStatus());
            }
            supAgenda.agd.get(i).setStatus(TimeBlock.StatusEnum.sum(stts));
        }
        return supAgenda;
    }
    
    /**
     * Initializes the agenda
     */
    private void initialize(){
        LocalDateTime actualDate = LocalDateTime.now();
        this.init = actualDate;
        WeekDays.WeekDaysEnum weekDay =  WeekDays.FactoryWeekdays(actualDate.getDayOfWeek().toString());

        int block;
        for(block = 0; block < BLOCKS; block++){
            if(this.agd.get(block).getWeekDay() == weekDay){//weekday found
                break;
            }
        }
        int minutes = TimeUtil.toMinutes(actualDate.getHour(), actualDate.getMinute());
        for(int i = 0; i <= minutes; i++){
            block++;
            i += minutes;
        }
        this.agd.setHead(block);
    }
    
    /**
     * Updates the agenda
     */
    public void update(){//Bring the head to the actual date, free old values
        LocalDateTime actualDate = LocalDateTime.now();
        long minuteDifference;
        
        for(minuteDifference = TimeUtil.differenceToMinutes(init, actualDate); minuteDifference > 0; minuteDifference += MIN_PER_BLOCK){
            this.agd.get(0).setFreeIfAllocated();
            this.agd.advanceHead();
        }
    }
    /**
     * Method that checks when an employee will be available
     * @param blocks are the blocks
     * @return TimeAnswer 
     */    

    @Override
    public TimeAnswer whenIsAvaliable(int blocks) {
        Set<Touple<Integer, Integer>> rsp = this.calculateFreeBlocks();
        //Technique 1: exact fit
        for(Touple<Integer, Integer> elem : rsp){
            if(elem.getB() == blocks){
                return new TimeAnswer(TimeUtil.add(elem.getA() * MIN_PER_BLOCK, this.init), elem.getA(), elem.getB());
            }
        }
        //Technique 1: first fit
        for(Touple<Integer, Integer> elem : rsp){
            if(elem.getB() <= blocks){
                return new TimeAnswer(TimeUtil.add(elem.getA() * MIN_PER_BLOCK, this.init), elem.getA(), elem.getB());
            }
        }
        return null;
    }
    /**
     * Method responsible for calculating all blocks that have free positions
     *@return Set 
     */
    
    public Set<Touple<Integer, Integer>> calculateFreeBlocks(){
        Set<Touple<Integer, Integer>> rsp = new HashSet<>();
        int emptyCount = 0;
        int firstNull = 0;
        
        for(int i = 0; i < BLOCKS; i++){//Percorrer todos os blocos
            if(this.agd.get(i).isFree() && i != BLOCKS -1){//Está livre
                if(emptyCount == 0){
                    firstNull = i;
                }
                emptyCount++;
            }
            else{//Não está livre ou é o último
                rsp.add(new Touple<>(firstNull, emptyCount-1));
                emptyCount = 0;
            }
        }
        return rsp;
    }
    /**
     * allocate the blocks to a visit
     * @param blocks are the blocks
     * @param init is the initial
     * @param elem is an object of Visit
     */    
    @Override
    public synchronized boolean allocate(int blocks, int init, Visit elem) {
         for(int i = init; i <= blocks; i++){//Percorrer todos os blocos
             TimeBlock block = this.agd.get(i);
             if(!block.isFree()){
                 return false;
             }
         }
         for(int i = init; i <= blocks + init; i++){//Percorrer todos os blocos
             TimeBlock block = this.agd.get(i);
             block.setAllocated(elem);
         }
         return true;
    }
    /**
     * clears a block
     * @param block is the block 
     */    
    @Override
    public void free(int block) {
        this.agd.get(block).setFree();
    }
    /**
     * clears the blocks of an object
     * @param o is an bject of Object 
     */    
    public void free(Object o){
        for(int i = 0; i < BLOCKS; i++){
            TimeBlock elem = this.agd.get(i);
            if(elem.getTask().equals(o)){
                elem.setFree();
            }
        }
    }
    /**
     * clear the blocks
     * @param init is the initial
     * @param blocks are the blocks 
     */    
    @Override
    public void free(int init, int blocks) {
        this.cleanBetween(init, init+blocks);
    }
    /**
     * clear between an initial position and a final position
     * @param init is the initial
     * @param end is the final
     */    
    public void cleanBetween(int init, int end) {
        for (int i = init; i < end; i++) {
            this.free(i);
        }
    }
    /**
     * This method return a representation of object String 
     * @return String
     */    
    @Override
    public String toString() {
        String rsp = "";

        for (int i = 0; i < BLOCKS; i++) {
            rsp += "[" + i + "]: " + agd.get(i).toString() + "\n";
        }
        return rsp;
    }
    /**
     * This method get the Agenda's noWorkPattern; 
     * @return NoWorkPattern
     */
    public NoWorkPattern getNoWorkPattern() {
        return noWorkPattern;
    }

    
}
