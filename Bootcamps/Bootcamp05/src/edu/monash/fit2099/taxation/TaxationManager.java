package edu.monash.fit2099.taxation;

import edu.monash.fit2099.vehicles.TaxableVehicle;

import java.util.ArrayList;

/**
 * TaxationManager class
 * @author lcha0068
 * @version 1.0.0
 */
public class TaxationManager {
    /**
     * An array list of taxable vehicles
     */
    private ArrayList<TaxableVehicle> taxableVehicleList;
    /**
     * A taxationManager instance
     */
    private static TaxationManager instance;

    //constructor

    /**
     * A constructor for TaxationManager
     */
    private TaxationManager(){
        taxableVehicleList = new ArrayList<>();
    }

    /**
     * A getter that will return an instance of TaxtionManager
     * @return An instance of type TaxationManager
     */
    public static TaxationManager getInstance(){
        if (instance == null){
            instance = new TaxationManager();
        }
        return instance;
    }

    /**
     * A method that append an item of type TaxableVehicle into the taxableVehicleList
     */
    public void appendTaxableItem(TaxableVehicle item){
        this.taxableVehicleList.add(item);
    }

    /**
     * A getter for the taxableVehicleList
     * @return a new arraylist of taxableVehicle, so that it can prevent any modification made by outside this class.
     */
    public ArrayList<TaxableVehicle> getTaxableVehicle() {
        return new ArrayList<TaxableVehicle>(this.taxableVehicleList);
    }

}
