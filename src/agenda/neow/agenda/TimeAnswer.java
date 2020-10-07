/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.agenda;

import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * This class represents a amount of time blocks starting from a position
 * and the corresponding date
 * @author andre
 */
public class TimeAnswer implements Serializable{
    public final LocalDateTime time;
    public final int initialBlock;
    public final int blocksAmount;

    /**
     * Construvtor for the class
     * @param time a date 
     * @param initialBlock a block matching the date
     * @param blocksAmount a amount of blocks from the initialBlock
     */
    public TimeAnswer(LocalDateTime time, int initialBlock, int blocksAmount) {
        this.time = time;
        this.initialBlock = initialBlock;
        this.blocksAmount = blocksAmount;
    }
}
