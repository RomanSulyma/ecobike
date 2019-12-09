package com.ecobike.utils.impl;

import com.ecobike.entities.Bike;
import com.ecobike.utils.SearchUtil;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Linear sorting algorithm
 */

@Component
public class SearchUtilImpl implements SearchUtil {

    @Override
    public Bike SearchFirstBike(List<Bike> bikeList, String brand) {

        for (Bike bike : bikeList)
            if (bike.getBrand().equals(brand.replace(" ","")))
                return bike;

        return null;
    }
}
