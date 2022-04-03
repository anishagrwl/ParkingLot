package com.parkinglot.carsinfo.inputhandler;

import com.parkinglot.carsinfo.config.ParkingLotConfig;
import com.parkinglot.carsinfo.config.ParkingLotConfigManager;
import com.parkinglot.carsinfo.exception.InternalServerErrorException;
import com.parkinglot.carsinfo.exception.NotFoundException;
import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class InputParser {
    public InputParser() throws NotFoundException, InternalServerErrorException {
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
