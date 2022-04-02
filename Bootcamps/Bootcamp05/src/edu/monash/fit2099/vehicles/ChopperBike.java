package edu.monash.fit2099.vehicles;

import java.util.Calendar;

public class ChopperBike extends Vehicle implements TaxableVehicle{


    private final String bikeType = "CHOPPER";

    // Creating two constructors with different signatures to achieve overloading

    public ChopperBike(String carMake, String carModel, int carModelYear) {
        super(carMake, carModel, carModelYear);
        this.addToTaxationManager();

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
