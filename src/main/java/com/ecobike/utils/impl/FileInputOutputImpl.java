package com.ecobike.utils.impl;

import com.ecobike.entities.Bike;
import com.ecobike.entities.ElectroBike;
import com.ecobike.entities.FoldingBike;
import com.ecobike.entities.Speedelec;
import com.ecobike.utils.FileInputOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes collection to a file
 */

@Component
public class FileInputOutputImpl implements FileInputOutput {

    @Value("${pathToFile}")
    private String filepath;

    @Override
    public List<Bike> readFromFile(String filename) throws IOException {

        if(new File(filepath + filename).exists())
            filepath = filepath + filename;
        else
            throw new FileNotFoundException();

        List<Bike> bikeList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));

        String line;
        while (((line = bufferedReader.readLine()) != null)) {

        String [] bikeProp = line.replaceAll(" ", "").split(";");

                if(bikeProp[0].contains("SPEEDELEC")){
                    bikeList.add(new Speedelec(bikeProp[0].replaceFirst("SPEEDELEC",""), Integer.parseInt(bikeProp[1]), Integer.parseInt(bikeProp[2]),
                            Boolean.parseBoolean(bikeProp[3]), Integer.parseInt(bikeProp[4]), bikeProp[5], Integer.parseInt(bikeProp[6])));
                }
                if(bikeProp[0].contains("FOLDINGBIKE")){
                    bikeList.add(new FoldingBike(bikeProp[0].replaceFirst("FOLDINGBIKE",""), Integer.parseInt(bikeProp[1]), Integer.parseInt(bikeProp[2]),
                            Integer.parseInt(bikeProp[3]), Boolean.parseBoolean(bikeProp[4]), bikeProp[5], Integer.parseInt(bikeProp[6])));
                }
                if(bikeProp[0].contains("E-BIKE")){
                    bikeList.add(new ElectroBike(bikeProp[0].replaceFirst("E-BIKE",""), Integer.parseInt(bikeProp[1]), Integer.parseInt(bikeProp[2]),
                            Boolean.parseBoolean(bikeProp[3]), Integer.parseInt(bikeProp[4]), bikeProp[5], Integer.parseInt(bikeProp[6])));
                }
            }

        bufferedReader.close();
        return bikeList;
    }

    @Override
    public void writeToFile(List<Bike> bikeList) throws IOException {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));

            for (Bike bike : bikeList)
                bufferedWriter.write(bike.prepareToWrite() + "\n");
            bufferedWriter.close();
    }
}
