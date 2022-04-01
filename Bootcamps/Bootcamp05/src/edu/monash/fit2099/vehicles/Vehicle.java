package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;

import java.util.ArrayList;

abstract public class Vehicle {
    //instance variables
    private String carMake;
    private String carModel;
    private int carModelYear;
//    private ArrayList<edu.monash.fit2099.bids.Bid> bids = new ArrayList<edu.monash.fit2099.bids.Bid>();
    private BidsManager bidsManager;
    private int vehicleID;

    public int getVehicleID() {
        return vehicleID;
    }

    //constructor
    public Vehicle(String _carMake, String _carModel, int _carModelYear){
        Utils util = new Utils();
        this.carMake = _carMake;
        this.carModel = _carModel;
        this.carModelYear = _carModelYear;
        this.vehicleID = util.nextID();
        this.bidsManager = new BidsManager();

    }
    public Vehicle(String _carMake, String _carModel, int _carModelYear, int _vehicleID){
        this.carMake = _carMake;
        this.carModel = _carModel;
        this.carModelYear = _carModelYear;
        this.vehicleID = _vehicleID;
        this.bidsManager = new BidsManager();
    }

    //getter and setter methods for carMake, carModel and carModelYear
    public String getCarMake() {
        return carMake;
    }

    public BidsManager getBidsManager() {
        return bidsManager;
    }

    public String getCarModel() {
        return carModel;
    }



    public int getCarModelYear() {
        return carModelYear;
    }




    // assessor method that returns a description of the edu.monash.fit2099.clients.Client object
    public String description(){
        String carDesc = ("MY" + this.getCarModelYear() + " " + this.getCarMake() + " " + this.getCarModel());
        return carDesc;
    }


    //this method will add a bid instance into the bid array list(declared in this class)
    public void addBid(int newClientId, double price, String date){
        bidsManager.addBid(newClientId,price,date);
    }

}