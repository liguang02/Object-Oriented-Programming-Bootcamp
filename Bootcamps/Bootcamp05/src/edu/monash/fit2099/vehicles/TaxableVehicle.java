package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.taxation.TaxationManager;

/**
 * TaxableVehicle is an interface for representing a collection of taxable vehicles
 */
public interface TaxableVehicle {
    /**
     * Default method for this interface
     * Calculate the tax rate of the taxable vehicle
     * @param price price of the taxable vehicle
     * @return a double value representing the tax price of the taxable vehicle
     */
    public double calculateTaxRate(double price);

    /**
     * Add the object that calls this method into the taxableVehicleList in TaxationManager class
     */
    default void addToTaxationManager(){
        TaxationManager.getInstance().appendTaxableItem(this);
    }
}
