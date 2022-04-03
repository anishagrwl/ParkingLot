package com.parkinglot.carsinfo.config;


import com.parkinglot.carsinfo.domain.Vehical;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;

import java.util.HashMap;
import java.util.List;

public abstract class ParkingLotConfig {
    public static List<Integer> remainingSlots;
    public static int sizeAlloted;
    public static HashMap<Integer, Vehical> parkingLot = new HashMap<>();
    public abstract void implementCommand(String[] implementationCommand) throws InternalServerErrorException, NotFoundException;
}
