package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.BidsManager;

import java.util.Calendar;

public class ChopperBike extends Vehicle implements TaxableVehicle{


    private final String bikeType = "CHOPPER";

    // Creating two constructors with different signatures to achieve overloading

    public ChopperBike(String maker, String model, int modelYear) throws Exception {
        super(maker, model, modelYear);
        if (setCarMake(maker) && setCarModel(model) && setCarModelYear((modelYear))) {
            this.addToTaxationManager();
        }else{
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }


    public ChopperBike(String carMake, String carModel, int carModelYear, int vehicleID) {
        super(carMake, carModel, carModelYear, vehicleID);
        this.addToTaxationManager();

    }
    public String getBikeType() {
        return bikeType;
    }

    @Override
    public double calculateTaxRate(double price) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - super.getCarModelYear();
        return price*(0.001*age);
    }
}
