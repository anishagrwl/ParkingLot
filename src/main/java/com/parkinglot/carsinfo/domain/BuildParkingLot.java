package com.parkinglot.carsinfo.domain;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;

import java.util.ArrayList;
import java.util.List;

public class BuildParkingLot extends ParkingLotConfig {
    @Override
    public void implementCommand(String[] implementationCommand) throws InternalServerErrorException {
        try {
            Integer sizeOfParkingLot = Integer.parseInt(implementationCommand[1]);
            List<Integer> creatParkingLot = new ArrayList<>();
            for (int i = 1; i <= sizeOfParkingLot; i++) {
                creatParkingLot.add(i);
            }
            remainingSlots = creatParkingLot;
            sizeAlloted = sizeOfParkingLot;
            System.out.println("Created a Parking lot with " + sizeOfParkingLot + " slots");
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex.getMessage(), ex);
        }
    }
}
