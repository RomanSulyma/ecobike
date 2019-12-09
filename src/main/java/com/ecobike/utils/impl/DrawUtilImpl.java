package com.ecobike.utils.impl;

import com.ecobike.entities.Bike;
import com.ecobike.entities.ElectroBike;
import com.ecobike.entities.FoldingBike;
import com.ecobike.entities.Speedelec;
import com.ecobike.utils.DrawUtil;
import com.ecobike.utils.FileInputOutput;
import com.ecobike.utils.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * draws menu and calls the read file method
 */

@Component
public class DrawUtilImpl implements DrawUtil {

    private Scanner scanner = new Scanner(System.in);
    private List<Bike> bikeList;

    @Autowired
    private SearchUtil searchUtil;

    @Autowired
    private FileInputOutput fileInputOutput;

    public void readFile() {

        boolean trigger = true;

        while (trigger) {
            System.out.println("Enter filename:");
            try {
                bikeList = fileInputOutput.readFromFile(scanner.nextLine());
                trigger = false;
            } catch (IOException e) {
                System.out.println("File not found");
                trigger = true;
            }
        }
    }

    @Override
    public void drawMenu() {

        boolean trigger = true;

            while (trigger) {
                System.out.println("Please make your choice:\n"
                        + "1 - Show the entire EcoBike catalog\n"
                        + "2 – Add a new folding bike\n"
                        + "3 – Add a new speedelec\n"
                        + "4 – Add a new e-bike\n"
                        + "5 – Find the first item of a particular brand\n"
                        + "6 – Write to file\n"
                        + "7 – Stop the program\n");

                switch (scanner.nextLine()) {
                    case "1":
                        for (Bike bike : bikeList)
                            System.out.println(bike.toString());
                        break;

                    case "2":
                        try {
                            Bike bike = new FoldingBike();
                            bike.createBikeInstance();
                            bikeList.add(bike);
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrect data format!");
                        }
                        break;

                    case "3":
                        try {
                            Bike bike = new Speedelec();
                            bike.createBikeInstance();
                            bikeList.add(bike);
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrect data format!");
                        }
                        break;

                    case "4":
                        try {
                            Bike bike = new ElectroBike();
                            bike.createBikeInstance();
                            bikeList.add(bike);
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrect data format!");
                        }
                        break;

                    case "5":
                        System.out.println("Enter brand:");
                        Bike bike = searchUtil.SearchFirstBike(bikeList, scanner.nextLine());
                        System.out.println(bike == null ? "Bike not found!" : bike);
                        break;

                    case "6":
                        System.out.println("Writing to file....");
                        try {
                            fileInputOutput.writeToFile(bikeList);
                            System.out.println("Writing completed!");
                        } catch (IOException e){
                            System.out.println("Writing failed!");
                        }
                        break;

                    case "7":
                        System.out.println("Program stopped");
                        scanner.close();
                        trigger = false;
                        break;

                    default:
                        System.out.println("Incorrect input!");
                        break;
                }
            }
        }
}

