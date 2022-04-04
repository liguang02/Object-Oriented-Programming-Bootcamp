package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.BidsManager;

/**
 * BobberBike class is a class that represent the Bobber bike which is
 * a sub/children class of Vehicle class
 * @author lcha0068
 * @version 1.0.0
 */
public class BobberBike extends Vehicle{
    //instance variable for BobberBike class
    /**
     * A constant that indicates this bike class is of the Bobber type
     */
    private final String bikeType = "BOBBER";

    /**
     * A constructor for the BobberBike class
     * @param maker the car maker of the bobber bike
     * @param model the car model of the bobber bike
     * @param modelYear the car model year of the bobber bike
     * @param vehicleID the vehicle id of the bobber bike
     * @throws Exception it can throw exception if the input is invalid
     */
    public BobberBike(String maker, String model, int modelYear, int vehicleID) throws Exception {
        super(maker, model, modelYear, vehicleID);
        if (!setCarMake(maker) || !setCarModel(model) || !setCarModelYear((modelYear))) {
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }


    // getter method

    /**
     * Returns the biketype of bobberbike class
     * @return a String constant representing the type of the bike which is BOBBER
     */
    public String getBikeType(){
        return bikeType;
    }
}
