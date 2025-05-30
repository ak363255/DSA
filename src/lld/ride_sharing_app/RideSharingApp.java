package lld.ride_sharing_app;

import java.util.ArrayList;
import java.util.List;

public class RideSharingApp {
    List<Driver> drivers = new ArrayList<>();
    Rider rider;
    FindNearestDriverService findNearestDriverService;

    public RideSharingApp(){
        drivers = addDummyDrivers();
        findNearestDriverService = new FindNearestDriver();
    }
    public void startDummyRide(){
        findARide();
    }

    private void findARide() {
        rider = createDummyRider();
        Location pickUpLocation  = new Location((2)*9.0,(2)*7.7);
        Location destinatoin = new Location((3)*7.0,(3)*7.8);
        System.out.println("Looking for a Driver Please wait....");
        Driver driver = findNearestDriverService.findDriver(pickUpLocation,drivers);
        driver.acceptRide();
        System.out.println("Driver found ->Accepted ->Cab is on the way Driver name "+driver.getName()+" vechicle no "+driver.getVehiicle().getVehicleNo());
        Ride ride = new Ride();
        ride.setSource(pickUpLocation);
        ride.setDestination(destinatoin);
        ride.setFair(89);
        ride.setRider(rider);
        ride.setDriver(driver);
        System.out.println("Journey started at Location "+ride.getSource().getLattitude()+" "+ride.getSource().getLongitude());
        ride.complete();
        System.out.println("Journey ended at "+ride.getDestination().getLattitude()+" "+ride.getDestination().getLongitude());
    }

    private Rider createDummyRider() {
        Rider rider = new Rider();
        rider.setName("Rider 1");
        rider.setEmail("r@gmail.com");
        rider.setMobile("1234567890");
        return rider;
    }

    private List<Driver> addDummyDrivers() {
        List<Driver> drivers = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Driver driver = new Driver();
            driver.setUserId(i);
            driver.setName("Testing "+i);
            driver.setEmail("Testing"+i+"@gmail.com");
            driver.setMobile(i+"23456789");
            driver.setAvailable(true);
            Vehiicle vehiicle = new Vehiicle();
            vehiicle.setVehicleNo(i);
            driver.setVehiicle(vehiicle);
            Location location = new Location((2+i)*7.0,(2+i)*8.0);
            driver.setLocation(location);
            drivers.add(driver);
        }
        return drivers;
    }
}
