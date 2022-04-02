package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.BidsManager;

public class BobberBike extends Vehicle{
    private final String bikeType = "BOBBER";


    public BobberBike(String maker, String model, int modelYear) throws Exception {
        super(maker, model, modelYear);
        if (!setCarMake(maker) || !setCarModel(model) || !setCarModelYear((modelYear))) {
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }

    public BobberBike(String carMake, String carModel, int carModelYear, int vehicleID) {
        super(carMake, carModel, carModelYear, vehicleID);

    }
    public String getBikeType(){
        return bikeType;
    }
}
