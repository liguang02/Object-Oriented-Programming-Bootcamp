package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

//sportcar is a sub class of vehicle class
public class SportCar extends Vehicle implements TaxableVehicle {
    //instance variable for edu.monash.fit2099.vehicles.SportCar class
    private int seats;
    private boolean isConvertible;

    // Creating two constructors with different signatures to achieve overloading
    public SportCar(String carMake, String carModel, int carModelYear, int seats, boolean isConvertible) {
        super(carMake, carModel, carModelYear);
        this.seats = seats;
        this.isConvertible = isConvertible;
        this.addToTaxationManager();

    }


    public SportCar(String carMake, String carModel, int carModelYear, int vehicleID, int seats, boolean isConvertible){
        super(carMake, carModel, carModelYear, vehicleID);
        this.seats = seats;
        this.isConvertible = isConvertible;
        this.addToTaxationManager();

    }

    @Override
    public String description(){
        String carDesc = ("MY" + super.getCarModelYear() + " " + super.getCarMake() + " " + super.getCarModel() + " " + this.seats + " seats.");
        return carDesc;
    }

    @Override
    public double calculateTaxRate(double price) {
        if (this.isConvertible){
            return (price*(this.seats*0.01));
        }else{
            return (price * 0.02);
        }
    }
}
