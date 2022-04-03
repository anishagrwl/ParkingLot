package com.parkinglot.carsinfo.domain;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

public class SlotNumberCarColor extends ParkingLotConfig {
    @Override
    public void implementCommand(String[] implementationCommand) throws InternalServerErrorException, NotFoundException {
        if (!parkingLot.isEmpty() || parkingLot != null) {
            String color = implementationCommand[1];
            boolean flag = false;
            Collection<Vehical> allVehicals = parkingLot.values();
            List<String> slotNumber = new ArrayList<>();
            for (Vehical vehical : allVehicals) {
                if (color.equalsIgnoreCase(vehical.getColor())) {
                    for (Entry<Integer, Vehical> entry : parkingLot.entrySet()) {
                        if (entry.getValue().equals(vehical)) {
                            flag = true;
                            String slot = entry.getKey().toString();
                            slotNumber.add(slot);
                        }
                    }
                }
            }
            if (flag == false) {
                System.out.println("No Vehical with Color" + implementationCommand[1] + " found");
            } else {
                System.out.println(String.join(",", slotNumber));
            }
        } else {
            throw new NotFoundException("Parking Lot Not Found. Create one first");
        }
    }
}
