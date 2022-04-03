package com.parkinglot.carsinfo;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.config.ParkingLotConfigManager;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;

import java.util.Scanner;

public class Parkinglot {
    public static void main (String[] args) throws InternalServerErrorException, NotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input");
            String inputCommand = scanner.nextLine();
            ParkingLotConfig parkingLotConfig = ParkingLotConfigManager.getParkingLotConfig(inputCommand);
            String[] executeCommand = inputCommand.split("\\s+");
            parkingLotConfig.implementCommand(executeCommand);
        }
    }
}
