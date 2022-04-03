package com.parkinglot.carsinfo.domain;


import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;

public class StatusParkingLot extends ParkingLotConfig {

    @Override
    public void implementCommand(String[] implementationCommand) throws InternalServerErrorException {
        try {
            if (!parkingLot.isEmpty() || parkingLot != null) {
                System.out.println("Slot No.\tRegistration No.\tColor");
                for (int i = 0; i <= parkingLot.size(); i++) {
                    if (parkingLot.containsKey(i)) {
                        Vehical vehical = parkingLot.get(i);
                        System.out.println(i + "\t" + vehical.getRegistrationNumber() + "\t" + vehical.getColor());
                    }
                }
            } else {
                throw new NotFoundException("Parking Lot Not Found. Create one first");
            }
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }
    }
}
