package com.parkinglot.carsinfo.config;

import com.parkinglot.carsinfo.domain.*;
import com.parkinglot.carsinfo.exception.NotFoundException;

public class ParkingLotConfigManager {
    public static ParkingLotConfig getParkingLotConfig(String executionCommand) throws NotFoundException {
        if (executionCommand.contains("create_parking_lot")) {
            return new BuildParkingLot();
        } else if(executionCommand.contains("status")) {
            return new StatusParkingLot();
        } else if(executionCommand.contains("leave")) {
            return new LeaveParkingLot();
        } else if(executionCommand.contains("park")) {
            return new ParkingVehical();
        } else if(executionCommand.contains("registration_numbers_for_cars_with_colour")) {
            return new RegistratioNumberCarColor();
        } else if(executionCommand.contains("slot_numbers_for_cars_with_colour")) {
            return new SlotNumberCarColor();
        } else if(executionCommand.contains("slot_number_for_registration_number")) {
            return new SlotNumberCarRegistration();
        } else {
            throw new NotFoundException("INVALID COMMAND");
        }
    }
}
