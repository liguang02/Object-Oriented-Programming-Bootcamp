package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.taxation.TaxationManager;

public interface TaxableVehicle {
    public double calculateTaxRate(double price);

    default void addToTaxationManager(){
        TaxationManager.getInstance().appendTaxableItem(this);
    }
}
