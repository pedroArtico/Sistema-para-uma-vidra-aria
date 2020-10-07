/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.nowork;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import agenda.neow.agenda.AllocatorConsts;
import agenda.neow.util.WeekDays;
import agenda.neow.util.TimeUtil;
import java.util.List;

/**
 * This class represents the periods of time where a element should be not available
 * @author andre
 */
public class NoWorkPattern implements AllocatorConsts, Serializable{
    private final Set<NoWorkElement> patterns;

    /**
     * Constructor for the class
     */
    public NoWorkPattern() {
        this.patterns = new HashSet<>();
    }
    
    /**
     * Appends a element to the pattern that should be repeated every day
     * @param begin the begin of the period
     * @param span the span from the begin
     */
    public void appendPatternEveryDay(LocalTime begin, LocalTime span){
        this.patterns.add(new NoWorkElement(begin, span));
    }
    
    /**
     * Appends a element to the pattern that should be repeated every week day
     * @param begin the begin of the period
     * @param span the span from the begin
     * @param day the day of the week to appy the element
     */
    public void appendPatternEveryWeekDay(LocalTime begin, LocalTime span, WeekDays.WeekDaysEnum day){
        NoWorkElement e = new NoWorkElement(begin, span, day);
        this.patterns.add(e);
    }
    
    /**
     * Appends a element to the pattern that should be repeated every day
     * @param from the begin of the period
     * @param to the end of the period
     */
    public void appendPatternEveryDayWithFromTo(LocalTime from, LocalTime to){
        NoWorkElement e = new NoWorkElement(from, TimeUtil.difference(from, to));
        this.patterns.add(e);
    }
    
    /**
     * Appends a element to the pattern that should be repeated every week day
     * @param from the begin of the period
     * @param to the end of the period
     * @param day the day of the week to appy the element
     */
    public void appendPatternEveryDayWithFromTo(LocalTime from, LocalTime to, WeekDays.WeekDaysEnum day){
        NoWorkElement e = new NoWorkElement(from, TimeUtil.difference(from, to), day);
        this.patterns.add(e);
    }
    /**
     * Appends a element to the pattern
     * @param e is an object
     */
    
    public void appendNwe(NoWorkElement e){
        this.patterns.add(e);
    }

    /**
     * Gets the pattern set as a unmodifiableSet object
     * @return an set of patterns
     */
    public Set<NoWorkElement> getPatterns() {
        return Collections.unmodifiableSet(patterns);
    }
    
    /**
     * Gets the pattern set as a object
     * @return an set of patterns
     */
    public Set<NoWorkElement> getPatterns2() {
        return this.patterns;
    }
    
    /**
     * Clears all the patterns
     */
    public void clearPatterns(){
        this.patterns.clear();
    }
    
    /**
     * Merges n patterns
     * @param patterns a list of patterns to merge
     * @return a noworkpattern
     */
    public static NoWorkPattern merge(NoWorkPattern... patterns){
        NoWorkPattern rsp = new NoWorkPattern();
        for(NoWorkPattern nwp : patterns){
            for(NoWorkElement nwe : nwp.getPatterns2()){
                rsp.appendNwe(nwe);
            }
            //rsp.patterns.addAll(nwp.getPatterns());
        }
        return rsp;
    }
    
    /**
     * Merges n patterns
     * @param patterns a list of patterns to merge
     * @return a noworkpattern
     */
    public static NoWorkPattern merge(List<NoWorkPattern> patterns){
        NoWorkPattern rsp = new NoWorkPattern();
        for(NoWorkPattern nwp : patterns){
            for(NoWorkElement nwe : nwp.getPatterns2()){
                rsp.appendNwe(nwe);
            }
        }
        return rsp;
    }
    
    
    
}
