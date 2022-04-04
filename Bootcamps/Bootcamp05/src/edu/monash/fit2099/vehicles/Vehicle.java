package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;

import java.util.ArrayList;

/**
 * Vehicle class is a base class that represents a generic vehicle types
 *
 * @author lcha0068
 * @version 1.0.0
 */
abstract public class Vehicle {
    //instance variables for Vehicle class
    /**
     * car maker of the vehicle
     */
    private String carMake;
    /**
     *  car model of the vehicle
     */
    private String carModel;
    /**
     * car model year of the vehicle
     */
    private int carModelYear;
    /**
     * the bidmanager that handles all the bids of a vehicle
     */
    private BidsManager bidsManager;
    /**
     * the vehicle id
     */
    private int vehicleID;


    //constructor

    /**
     * A constructor for the Vehicle class
     * @param maker the car maker of the vehicle
     * @param model the car model of the vehicle
     * @param modelYear the car model year of the vehicle
     * @param vehicleID the vehicle id of the vehicle
     * @throws Exception it can throw exception if the input is invalid
     */
    public Vehicle(String maker, String model, int modelYear, int vehicleID) throws Exception {
        if (setCarMake(maker) && setCarModel(model) && setCarModelYear((modelYear))) {
            this.bidsManager = new BidsManager();
            this.vehicleID = vehicleID;
            this.carMake = maker;
            this.carModel = model;
            this.carModelYear = modelYear;

        } else {
            throw new Exception("Incorrect Vehicle's Maker, Model or Make/Model Year ");
        }
    }


    //getter and setter methods for carMake, carModel and carModelYear

    /**
     *  A getter for the car maker
     * @return the car maker as a string
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     * A getter for the bidsmanager
     * @return a bidmanager as BidManager type
     */
    public BidsManager getBidsManager() {
        return bidsManager;
    }

    /**
     *  A getter for the car model
     * @return the car model as a string
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     *  A getter for the vehicle id
     * @return the vehicleID as an int
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     *  A getter for the car model year
     * @return the car model year as an int
     */
    public int getCarModelYear() {
        return carModelYear;
    }

    /**
     * The setter for car maker
     * @param carMake A string containing the car maker
     * @return true if the length of the string is valid (between 3 and 15); false otherwise
     */
    public boolean setCarMake(String carMake) {
        boolean isValid = false;
        if ((carMake.length() >2 ) && (carMake.length() <=15)){
            this.carMake = carMake;
            isValid = true;
        }
        return isValid;
    }

    /**
     * The setter for car model
     * @param carModel A string containing the car model
     * @return true if the length of the string is valid (between 3 and 15); false otherwise
     */
    public boolean setCarModel(String carModel) {
        boolean isValid = false;
        if ((carModel.length() > 2) && (carModel.length() <=15)){
            this.carModel = carModel;
            isValid = true;
        }
        return isValid;
    }
    /**
     * The setter for car model year
     * @param carModelYear An integer containing the car model year
     * @return true if year is valid (>1000); false otherwise
     */
    public boolean setCarModelYear(int carModelYear) {
        boolean isValid = false;
        if (carModelYear >1000){
            this.carModelYear = carModelYear;
            isValid = true;
        }
        return isValid;
    }


    /**
     * A method that will display the description of the vehicle
     * @return a string that contains the description of the vehicle
     */
    public String description(){
        String carDesc = ("MY" + this.getCarModelYear() + "|" + this.getCarMake() + "|" + this.getCarModel() + "|");
        return carDesc;
    }



//    //this method will add a bid instance into the bid array list(declared in this class)
//    public void addBid(int newClientId, double price, String date){
//        bidsManager.addBid(newClientId,price,date);
//    }

}