package lld.ride_sharing_app;

import java.util.List;

interface FindNearestDriverService {
    public Driver findDriver(Location picupLoaction, List<Driver> drivers);
}
