package edu.monash.fit2099.bids;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;

import java.util.HashMap;

/**
 * BidManager class manages all bids of a vehicle, so that we can potentially perform special operations on the bids
 * such as best/worst bids in the future.
 * @author lcha0068
 * @version 1.0.0
 */
public class BidsManager {
    // declared a hashmap that holds the key of integer type and bid type value.
    /**
     * A hashmap that holds the key value pair (client ID as key; Bid as value)
     */
    private HashMap<Integer, Bid> hashmap;

    /**
     * A constructor for BidManager class
     */
    //    constructor for bidsmanager
    public BidsManager(){
        this.hashmap = new HashMap<Integer, Bid>();
    }

//    getter method for the hashmap instance var
    /**
     * A getter for the hashmap
     * @return a hashmap containing the clientID as key and bid as value
     */
    public HashMap<Integer, Bid> getHashmap() {
        return hashmap;
    }

    /**
     * addBid() method will create and a new instance of the Bid class and put in the HashMap attribute the <clientId, bid> pair.
     * @param clientID id for the client
     * @param bidPrice bid price
     * @param bidDate bid date
     */
    public void addBid(int clientID, double bidPrice, String bidDate){
        Utils util = new Utils();
        int bidID = util.nextID();
        Bid bid = new Bid(bidID, clientID, bidPrice, bidDate );
        hashmap.put(clientID, bid);
    }

}
