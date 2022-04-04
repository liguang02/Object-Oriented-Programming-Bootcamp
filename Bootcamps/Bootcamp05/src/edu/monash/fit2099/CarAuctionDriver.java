package edu.monash.fit2099;

import edu.monash.fit2099.CarAuction;
/**
 * <h1>Car Auction Driver</h1>
 * The Car Auction Driver program implements an application that it can
 * simulate a car auction such that the users are able to create vehicles
 * and add bid on the vehicles and store the client details.
 * @author lcha0068
 * @version 1.0
 * @since 4/4/2022
 */
public class CarAuctionDriver {
    public static void main(String[] args) {
        //create an instance of car auction so it can invoke the printstatus where the core functionalities are.
        CarAuction carAuction1 = new CarAuction();
        carAuction1.printStatus();
    }
}

