package com.parkinglot.carsinfo;

import com.parkinglot.carsinfo.domain.*;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import com.parkinglot.carsinfo.config.ParkingLotConfigManager;


public class ParkingLotTest {

    @Test
    public void testCreateParkingLot() throws NotFoundException, InternalServerErrorException {
        String command = "create_parking_lot 5";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof BuildParkingLot);
    }

    @Test
    public void testStatus() throws NotFoundException, InternalServerErrorException {
        String command = "status";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof StatusParkingLot);
    }

    @Test
    public void testLeaveParkingLot() throws NotFoundException, InternalServerErrorException {
        String command = "leave 2";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof LeaveParkingLot);
    }

    @Test
    public void testParkVehical() throws NotFoundException, InternalServerErrorException {
        String command = "park";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof ParkingVehical);
    }

    @Test(expected = NotFoundException.class)
    public void testInvalidCommnad() throws NotFoundException {
        String command = "sts";
        ParkingLotConfigManager.getParkingLotConfig(command);
    }

    @Test
    public void testRegistrationNumberCarColor() throws NotFoundException {
        String command = "registration_numbers_for_cars_with_colour white";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof RegistratioNumberCarColor);
    }

    @Test
    public void testSlotNumberCarColor() throws NotFoundException {
        String command = "slot_numbers_for_cars_with_colour white";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof SlotNumberCarColor);
    }

    @Test
    public void testSlotNumberCarRegistration() throws NotFoundException {
        String command = "slot_number_for_registration_number MH-02-HH-1234";
        Assert.assertTrue(ParkingLotConfigManager.getParkingLotConfig(command) instanceof SlotNumberCarRegistration);
    }
}
