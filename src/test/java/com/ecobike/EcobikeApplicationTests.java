package com.ecobike;

import com.ecobike.entities.Bike;
import com.ecobike.entities.ElectroBike;
import com.ecobike.entities.FoldingBike;
import com.ecobike.entities.Speedelec;
import com.ecobike.utils.FileInputOutput;
import com.ecobike.utils.SearchUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EcobikeApplicationTests {

    private static List<Bike> bikeList= new ArrayList<>();

    @Value("${classpath:test.txt}")
    private String pathToFile;

    @Autowired
    SearchUtil searchUtil;

    @Autowired
    FileInputOutput fileInputOutput;

    @BeforeAll
    static void setUpList(){
        bikeList.add(new ElectroBike("Farad", 30, 22500, true, 10000, "rose", 1745));
        bikeList.add(new Speedelec("AirWheel", 15, 11200, false, 11200, "pink", 419));
        bikeList.add(new FoldingBike("Titan", 24, 7, 16500, true, "golden", 1295));
    }

    @Test
    void searchBikeTest(){
        Assertions.assertEquals(bikeList.get(2), searchUtil.SearchFirstBike(bikeList,"Titan"));
    }

    @Test
    void electroBikePrepareToWriteTest(){
        Assertions.assertEquals("E-BIKE Farad;30;22500;true;10000;rose;1745", bikeList.get(0).prepareToWrite());
    }

    @Test
    void foldingBikePrepareToWriteTest(){
        Assertions.assertEquals("FOLDING BIKE Titan;24;7;16500;true;golden;1295", bikeList.get(2).prepareToWrite());
    }

    @Test
    void speedelecPrepareToWriteTest(){
        Assertions.assertEquals("SPEEDELEC AirWheel;15;11200;false;11200;pink;419", bikeList.get(1).prepareToWrite());
    }

    @Test
    void fileReadTest(){
        try {
            Assertions.assertEquals(bikeList, fileInputOutput.readFromFile(pathToFile));
        }catch (IOException e){
            System.out.println("Writing failed!");
        }
    }

    @Test
    void  fileReadFailTest(){
        try {
            Assertions.assertEquals(new FileNotFoundException(), fileInputOutput.readFromFile("incorrect.txt"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
