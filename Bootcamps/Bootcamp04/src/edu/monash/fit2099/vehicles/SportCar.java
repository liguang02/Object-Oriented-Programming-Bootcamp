package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

//sportcar is a sub class of vehicle class
public class SportCar extends Vehicle {
    //instance variable for edu.monash.fit2099.vehicles.SportCar class
    private int seats;
    private boolean isConvertible;

    // Creating two constructors with different signatures to achieve overloading
    public SportCar(String _carMake, String _carModel, int _carModelYear, int _seats, boolean _isConvertible) {
        super(_carMake, _carModel, _carModelYear);
        this.seats = _seats;
        this.isConvertible = _isConvertible;
    }

    public SportCar(String _carMake, String _carModel, int _carModelYear, int _vehicleID, int _seats, boolean _isConvertible){
        super(_carMake, _carModel, _carModelYear, _vehicleID);
        this.seats = _seats;
        this.isConvertible = _isConvertible;
    }

    @Override
    public String description(){
        String carDesc = ("MY" + super.getCarModelYear() + " " + super.getCarMake() + " " + super.getCarModel() + " " + this.seats + " seats.");
        return carDesc;
    }

}
