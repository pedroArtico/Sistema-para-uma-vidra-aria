/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.util;
import java.io.Serializable;
/**
 * This class represents the days of a week
 * @author andre
 */
public class WeekDays implements Serializable {
    public enum WeekDaysEnum{
        SUNDAY      (0, true,   "SUN", "DOM"),
        MONDAY      (1, false,  "MON", "SEG"),
        TUESDAY     (2, false,  "TUE", "TER"),
        WEDNESDAY   (3, false,  "WED", "QUA"),
        THURSDAY    (4, false,  "THU", "QUI"),
        FRIDAY      (5, false,  "FRI", "SEX"),
        SATURDAY    (6, true,   "SAT", "SAB")
        ;
        
        private final int num;
        private final boolean weekend;
        private final String shortNameEn;
        private final String shortNamePt;
        
        /**
         * Enum's constructor
         * @param dayNum number of the day
         * @param weekend true if the day is a weekend
         * @param shortNameEn a shorthand name for it in english
         * @param shortNamePt a shorthand name for it in portugueese
         */
        WeekDaysEnum(int dayNum, boolean weekend, String shortNameEn, String shortNamePt){
            this.weekend = weekend;
            this.num = dayNum;
            this.shortNameEn = shortNameEn;
            this.shortNamePt = shortNamePt;
        }
        
        /**
         * Returns true if the day is a weekend
         * @return  a boolean
         */
        public boolean isWeekend(){
            return this.weekend;
        }
        
        /**
         * Gets the number of the day
         * @return a weekday
         */
        public int getNum(){
            return this.num;
        }
        
        /**
         * Gets the nmber of the day from the given enum
         * @param e a weekday
         * @return  an int
         */
        public static int getNum(WeekDaysEnum e){
            return e.num;
        }
        
        /**
         * Returns true if the given enum is a weekend day
         * @param e an weekday
         * @return a boolean
         */
        public static boolean isWeekend(WeekDaysEnum e){
            return e.weekend;
        }

        /**
         * Gets the shorthand name for the day in english
         * @return a short name
         */
        public String getShortNameEn() {
            return shortNameEn;
        }

        /**
         * Gets the shorthand anme for de day in portugueese
         * @return a short name
         */
        public String getShortNamePt() {
            return shortNamePt;
        }
    }
    
    /**
     * Prints the information about the enum
     */
    public static void PrintOptions(){
        for(WeekDaysEnum e : WeekDaysEnum.values()){
            System.out.println(e.getNum() + " :  " + e + ", " + e.getShortNameEn() + ", " + e.getShortNamePt());
        }
    }
    
    /**
     * Returns a WeekDaysEnum object based on the given number
     * @param num a number
     * @return if a unknown numer was given
     */
    public static WeekDaysEnum FactoryWeekdays(int num){
        for(WeekDaysEnum e : WeekDaysEnum.values()){
            if(e.getNum() == num){
                return e;
            }
        }
        return null;
    }
   
    /**
     * Returns a WeekDaysEnum object based on the given name (full name or shorthand in english or portugueese)
     * @param name the name
     * @return null if a unknown name was given
     */
    public static WeekDaysEnum FactoryWeekdays(String name){
        for(WeekDaysEnum e : WeekDaysEnum.values()){
            if(e.getShortNameEn().equals(name) || e.getShortNamePt().equals(name) || e.toString().equals(name)){
                return e;
            }
        }
        return null;
    }
}


