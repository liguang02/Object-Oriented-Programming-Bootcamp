package edu.monash.fit2099.taxation;

import edu.monash.fit2099.vehicles.TaxableVehicle;

import java.util.ArrayList;

public class TaxationManager {
    private ArrayList<TaxableVehicle> taxableVehicleList;
    private static TaxationManager instance;

    //constructor
    private TaxationManager(){
        taxableVehicleList = new ArrayList<>();
    }
    public static TaxationManager getInstance(){
        if (instance == null){
            instance = new TaxationManager();
        }
        return instance;
    }

    public void appendTaxableItem(TaxableVehicle item){
        this.taxableVehicleList.add(item);
    }

    public ArrayList<TaxableVehicle> getTaxableVehicle() {
        return new ArrayList<TaxableVehicle>(this.taxableVehicleList);
    }

}
