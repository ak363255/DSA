package lld.ride_sharing_app;

public class Driver extends User {
    private boolean isAvailable = true;
    private Vehiicle vehiicle;
    private Location location;


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehiicle getVehiicle() {
        return vehiicle;
    }

    public void setVehiicle(Vehiicle vehiicle) {
        this.vehiicle = vehiicle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void acceptRide(){
        this.isAvailable = false;
    }
    public void rideCompleted(){
        this.isAvailable = true;
    }
}
