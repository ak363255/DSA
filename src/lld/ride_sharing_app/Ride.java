package lld.ride_sharing_app;

public class Ride {
    private Location source;
    private Location destination;
    private Rider rider;
    private Driver driver;
    private double fair;

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void complete() {
        driver.rideCompleted();
    }
}
