package edu.monash.fit2099.vehicles;

public class BobberBike extends Vehicle{
    private final String bikeType = "BOBBER";

    public BobberBike(String carMake, String carModel, int carModelYear) {
        super(carMake, carModel, carModelYear);
    }

    public BobberBike(String carMake, String carModel, int carModelYear, int vehicleID) {
        super(carMake, carModel, carModelYear, vehicleID);
    }
    public String getBikeType(){
        return bikeType;
    }
}
