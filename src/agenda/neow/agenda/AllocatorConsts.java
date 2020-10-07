/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.agenda;

import agenda.neow.util.TimeUtil;
/**
 *
 * @author Pedro
 */
public interface AllocatorConsts {
    /**
     * Minutes per block of time
     */
    public static final int MIN_PER_BLOCK = 60;
    
    
    /**
     * Amount of blocks in the agenda
     */
    public static final int BLOCKS = (4 * 7 * 24 * 60)/10;
    
    /**
     * Amount of blocks per day
     */
    public static final int BLOCKS_PER_DAY = TimeUtil.minutesInADay / MIN_PER_BLOCK;
    
    /**
     * Amount of blocks per week
     */
    public static final int BLOCKS_PER_WEEK = TimeUtil.minutesInAWeek / MIN_PER_BLOCK;
    
}
