package com.parkinglot.carsinfo.domain;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;

import java.util.Collections;
import java.util.List;

public class LeaveParkingLot extends ParkingLotConfig {
    @Override
    public void implementCommand(String[] implementationCommand) throws InternalServerErrorException {
        try {
            if (!parkingLot.isEmpty() || parkingLot != null) {
                Integer parkingSlotNumber = Integer.parseInt(implementationCommand[1]);
                parkingLot.remove(parkingSlotNumber);
                System.out.println("Parking Lot Number " + parkingSlotNumber + " is now vacant");
                List<Integer> remSlot = remainingSlots;
                remSlot.add(parkingSlotNumber);
                Collections.sort(remSlot);
                remainingSlots = remSlot;
            } else {
                System.out.println("Parking Lot Not Found! Please create Parking Lot");
            }
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex.getMessage(), ex);
        }
    }
}
