package lld.ride_sharing_app;

import java.util.ArrayList;
import java.util.List;

public class FindNearestDriver implements FindNearestDriverService{
    @Override
    public Driver findDriver(Location picupLoaction, List<Driver> drivers) {
        /*
        Logic to find Nearest driver
         */
         return drivers.get(0);
    }
}
