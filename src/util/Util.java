package util;

import java.time.LocalDateTime;
import persons.Driver;
import visit.Vehicle;
import java.time.Instant;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import javafx.util.converter.LocalDateTimeStringConverter;

public class Util {

	/**
         * Tests if a driver can drive a vehicle
         * @param driver a driver
         * @param vehicle a vehicle
         * @return {@code true} if the driver has the needed license to drive the vehicle
         */
	public boolean canDriveVehicle(Driver driver, Vehicle vehicle) {
		return false;
	}
        
        /**
         * Formats a sentence includding "s" or not at the end
         * @param amount amount of things
         * @param str name of the thing
         * @return a string in the plural or not
         */
        public static String portugueesePlurarize(int amount, String str){
            return (amount == 1)?str:str+"s";
        }

}
