/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author andre
 */
public class TimeUtil implements Serializable{
    public static final int minutesInAnHour = 60;
    public static final int minutesInADay = 24 * minutesInAnHour;
    public static final int minutesInAWeek = 7 * minutesInADay;
    public static final int minutesInAMonth = 30 * minutesInADay;
    
    /**
     * Gives how many minutes there are in the given amount of hours
     *
     * @param hours an int representing hours
     * @return an int representing minutes
     */
    static public int hoursToMinutes(int hours) {
        return hours / 60;
    }

    /**
     * Gives how many minutes there are in the given amount of days
     *
     * @param days an int representing days
     * @return an int representing minutes
     */
    static public int daysToMinutes(int days) {
        return days / 24 / 60;
    }

    /**
     * Sums minutes
     *
     * @param minuteElem an int (indicating minutes)
     * @return an amount of minutes
     */
    static public int minutesSum(Integer... minuteElem) {
        int sum = 0;
        for (Integer elem : minuteElem) {
            sum += elem;
        }
        return sum;
    }
    
    /**
     * Returns the difference of two dates in minutes
     * @param endDate a date
     * @param startDate a date
     * @return an long representing minutes
     */
    static public long differenceToMinutes(LocalDateTime endDate, LocalDateTime startDate){
        return Duration.between(startDate, endDate).toMinutes();
    }
    
    /**
     * Returns the difference of two times in minutes
     * @param startTime a date
     * @param endTime a date
     * @return a date
     */
    static public LocalTime difference(LocalTime startTime, LocalTime endTime){
        int hours = 0;
        long minutes = 0;
        
        for(minutes = Math.abs(Duration.between(startTime, endTime).toMinutes()); minutes > 59; minutes -= 60){
            hours++;
        }
        
        return LocalTime.of(hours, (int) minutes);
    }
    
    /**
     * Counts how many blocks a certain amount of time (in minutes) contains
     * @param minutesPerBlock the amount of minutes in one block
     * @param minutes a amount of minutes
     * @return an int
     */
    static public int blocksIn(int minutesPerBlock, int minutes){
        return minutes / minutesPerBlock; 
    }
    
    static public int toMinutes(int hours, int minutes){
        return  minutes + (hours * 60);
    }
    
    

    /**
     * Convenience method to add a specified number of minutes to a
     * LocalDateTime object Based on:
     * http://stackoverflow.com/questions/9043981/how-to-add-minutes-to-my-date
     *
     * @param minutes minutes to add
     * @param beforeTime the original date
     * @return a date
     */
    public static LocalDateTime add(int minutes, LocalDateTime beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
        Date beforeTimeDate = asDate(beforeTime);
        long curTimeInMs = beforeTimeDate.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        return asLocalDateTime(afterAddingMins);
    }

    /**
     * Converts a LocalDate object to a Date object
     *
     * @param localDate a date
     * @return a date
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a LocalDateTime object to an Date object
     *
     * @param localDateTime a date
     * @return a date
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a Date object to an LocalDate object
     * @param date a date
     * @return a date
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Converts a Date object to an LocalDateTime object
     *
     * @param date a date
     * @return a string
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Gets a LocalDateTime object and returns a String of it in the format "dd/MM/yyyy HH:mm"
     * @param dt a date
     * @return a string
     */
    public static String toCompleteString(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dt.format(formatter);
    }

    /**
     * Gets a LocalDateTime object and returns a String of it in the format "dd/MM/yyyy"
     * @param dt a date
     * @return a string
     */
    public static String toDateString(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(formatter);
    }

    
    /**
     * Gets a LocalDateTime object and returns a String of it in the format "HH:mm"
     * @param dt a date
     * @return a string
     */
    public static String toTimeString(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dt.format(formatter);
    }

    /**
     * Gets a LocalDate object and returns a String of it in the format "dd/MM/yyyy"
     * @param dt a date
     * @return  a string
     */
    public static String toString(LocalDate dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(formatter);
    }

    /**
     * Gets a String object and returns a LocalDate object of it using the format "dd/MM/yyyy"
     * @param source a string
     * @return an localdate
     */
    public static LocalDate fromString(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(source,formatter);
    }
    public static LocalDateTime fromCompleteString(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(source,formatter);
    }
    
    
}
