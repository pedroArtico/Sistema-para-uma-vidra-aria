/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.nowork;

import java.io.Serializable;
import java.time.LocalTime;
import agenda.neow.agenda.AllocatorConsts;
import agenda.neow.util.WeekDays;
import agenda.neow.util.TimeUtil;

/**
 * This class represents a no work element, a component of the <code>NoWorkPattern</code>
 * @author andre
 */
public class NoWorkElement implements AllocatorConsts, Serializable{
    
    /**
     * Types of NoWorkElement
     */
    public enum Type{EVERY_DAY, EVERY_WEEK_DAY}
    
    private final LocalTime beginTime;
    private final LocalTime finalTime;
    private final WeekDays.WeekDaysEnum day;
    private final Type type;

    /**
     * Instantiates the class as a EVERY_DAY NoWorkElement
     * @param beginTime the start of the blocked period
     * @param finalTime the end of the blocked period
     */
    public NoWorkElement(LocalTime beginTime, LocalTime finalTime) {
        this.type = Type.EVERY_DAY;
        this.beginTime = beginTime;
        this.finalTime = finalTime;
        this.day = null;
    }

    /**
     * Instantiates the class as a EVERY_WEEK_DAY NoWorkElement
     * @param beginTime the start of the blocked period
     * @param finalTime the end of the blocked period
     * @param day the day of the week in which the element should be applied
     */
    public NoWorkElement(LocalTime beginTime, LocalTime finalTime, WeekDays.WeekDaysEnum day) {
        this.type = Type.EVERY_WEEK_DAY;
        this.beginTime = beginTime;
        this.finalTime = finalTime;
        this.day = day;
    }

    /**
     * Calculates how many minutes there are between 00:00 and the inital time
     * of "no work"
     * @return a int representing minutes
     */
    public int getMinutesToBegin(){
        return TimeUtil.toMinutes(beginTime.getHour(), beginTime.getMinute());
    }
    
    /**
     * Calculates how many minutes there are between 00:00 and the end time
     * of "no work"
     * @return a int representing minutes
     */
    public int getMinutesToEnd(){
        return TimeUtil.toMinutes(finalTime.getHour(), finalTime.getMinute());
    }
    
    /**
     * Gets the week day of the NoWorkElement
     * @return a WeekDaysEnum or null
     */
    public WeekDays.WeekDaysEnum getDay() {
        return day;
    }

    /**
     * Gets the type of the NoWorkElement
     * @return a Type instance
     */
    public Type getType() {
        return type;
    }
    
    /**
     * Returns true only if the type of the element is EVERY_DAY
     * @return a boolean representing the result of the operation
     */
    public boolean isEveryDay(){
        return this.type == Type.EVERY_DAY;
    }
    
    /**
     * Returns true only if the type of the element is EVERY_WEEK_DAY
     * @return a boolean representing the result of the operation
     */
    public boolean isEveryWeekDay(){
        return this.type == Type.EVERY_WEEK_DAY;
    }
}
