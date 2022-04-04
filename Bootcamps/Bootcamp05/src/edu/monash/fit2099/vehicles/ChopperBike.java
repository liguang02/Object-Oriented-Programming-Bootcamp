package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.BidsManager;

import java.util.Calendar;
/**
 * ChopperBike class is a class that represent the Chopper bike which is
 * a sub/children class of Vehicle class and implements TaxableVehicle interface.
 * @author lcha0068
 * @version 1.0.0
 */
public class ChopperBike extends Vehicle implements TaxableVehicle{
    /**
     * A constant that indicates this bike class is of the Bobber type
     */
    private final String bikeType = "CHOPPER";

    /**
     * A constructor for the ChopperBike class
     * @param maker the car maker of the Chopper bike
     * @param model the car model of the Chopper bike
     * @param modelYear the car model year of the Chopper bike
     * @param vehicleID the vehicle id of the Chopper bike
     * @throws Exception it can throw exception if the input is invalid
     */
    public ChopperBike(String maker, String model, int modelYear, int vehicleID) throws Exception {
        super(maker, model, modelYear, vehicleID);
        if (setCarMake(maker) && setCarModel(model) && setCarModelYear((modelYear))) {
            this.addToTaxationManager();
        }else{
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }

    /**
     * Returns the biketype of bobberbike class
     * @return a String constant representing the type of the bike which is BOBBER
     */
    public String getBikeType() {
        return bikeType;
    }

    /**
     * Calculate the tax rate of the chopper bike depending on its age (current year - car model year)
     * @param price a double representing the price of the chopper bike
     * @return the tax of the chopper bike
     */
    @Override
    public double calculateTaxRate(double price) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - super.getCarModelYear();
        return price*(0.001*age);
    }
}
