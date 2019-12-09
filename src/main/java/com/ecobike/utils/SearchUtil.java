package com.ecobike.utils;

import com.ecobike.entities.Bike;
import java.util.List;

public interface SearchUtil {

    Bike SearchFirstBike(List<Bike> bikeList, String brand);
}
