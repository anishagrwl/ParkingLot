package com.parkinglot.carsinfo.domain;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;

import java.util.List;

public class ParkingVehical extends ParkingLotConfig {
    @Override
    public void implementCommand(String[] implementationCommand) throws InternalServerErrorException, NotFoundException {
        try {


            if (!parkingLot.isEmpty() || parkingLot != null) {
                Vehical vehical = new Vehical(implementationCommand[1], implementationCommand[2]);
                List<Integer> slots = remainingSlots;
                if (slots.isEmpty()) {
                    System.out.println("Parking Lot Full!");
                } else {
                    Integer parkingSlotNumber = slots.get(0);
                    if (slots.size() <= sizeAlloted) {
                        parkingLot.put(parkingSlotNumber, vehical);
                        System.out.println("Allocated Slot Number:" + parkingSlotNumber);
                    }
                    slots.remove(0);
                }
            } else {
                throw new NotFoundException("Parking Lot Not Found. Please add a Parking Lot. Thank You!");
            }
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex.getMessage(), ex);
        }
    }
}
