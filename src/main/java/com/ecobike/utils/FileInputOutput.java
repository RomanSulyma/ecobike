package com.ecobike.utils;

import com.ecobike.entities.Bike;
import java.io.IOException;
import java.util.List;

public interface FileInputOutput {

    List<Bike> readFromFile(String filename) throws IOException;

    void writeToFile(List<Bike> bikeList) throws IOException;
}
