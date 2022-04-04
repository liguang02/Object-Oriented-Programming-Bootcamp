package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

/**
 * SportCar class is a class that represent the Sport Car which is
 * a sub/children class of Vehicle class implements TaxableVehicle interface.
 * @author lcha0068
 * @version 1.0.0
 */

public class SportCar extends Vehicle implements TaxableVehicle {
    //instance variables for sportcar
    /**
     * Number of the seats the sport car has
     */
    private int seats;
    /**
     * Indicates if the sport car is a convertible car or not
     */
    private boolean isConvertible;

    // Creating two constructors with different signatures to achieve overloading

    /**
     * A constructor for the SportCar class
     * @param carMake the car maker of the Sport car
     * @param carModel the car model of the Sport car
     * @param carModelYear the car model year of the sport car
     * @param vehicleID the vehicle id of the sport car
     * @param seats the number of seats of the sport car
     * @param isConvertible the type of the sport car (is it convertible or no)
     * @throws Exception it can throw exception if the input is invalid
     */
    public SportCar(String carMake, String carModel, int carModelYear, int vehicleID,  int seats, boolean isConvertible) throws Exception{
        super(carMake, carModel, carModelYear, vehicleID);
        if (setCarMake(carMake) && setCarModel(carModel) && setCarModelYear((carModelYear)) && setSeats(seats)){
            this.seats = seats;
            this.isConvertible = isConvertible;
            this.addToTaxationManager();
        }else{
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }

    /**
     * A setter of the number of seats
     * @param seats an int representing the new number of seats
     * @return true if the number of seats is valid (between 2 and 5); false otherwise
     */
    public boolean setSeats(int seats) {
        boolean isValid = false;
        if ((seats >=2) && (seats <= 5))  {
            this.seats = seats;
            isValid = true;
        }
        return isValid;
    }

    /**
     * Calculate the tax rate of the sport car depending if it's a convertible or not
     * @param price a double representing the price of the sport car
     * @return the tax of the sport car
     */
    @Override
    public double calculateTaxRate(double price) {
        if (this.isConvertible){
            return (price*(this.seats*0.01));
        }else{
            return (price * 0.02);
        }
    }


//    public SportCar(String carMake, String carModel, int carModelYear, int vehicleID, int seats, boolean isConvertible){
//        super(carMake, carModel, carModelYear, vehicleID);
//        this.seats = seats;
//        this.isConvertible = isConvertible;
//        this.addToTaxationManager();
//
//    }
    //    @Override
//    public String description(){
//        String carDesc = ("MY" + super.getCarModelYear() + " " + super.getCarMake() + " " + super.getCarModel() + " " + this.seats + " seats.");
//        return carDesc;
//    }
}
