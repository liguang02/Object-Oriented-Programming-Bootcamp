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
    public Vehicle(String carMake, String carModel, int carModelYear){
        Utils util = new Utils();
        this.carMake = carMake;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.vehicleID = util.nextID();
        this.bidsManager = new BidsManager();

    }
    public Vehicle(String carMake, String carModel, int carModelYear, int vehicleID){
        this.carMake = carMake;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.vehicleID = vehicleID;
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