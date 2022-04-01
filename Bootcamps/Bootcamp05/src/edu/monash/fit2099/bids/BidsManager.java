package edu.monash.fit2099.bids;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;

import java.util.HashMap;
//This class manages all bids of a vehicle, so that we can potentially perform special operations on the bids
//such as best/worst bids in the future.
public class BidsManager {
    // declared a hashmap that holds the key of integer type and bid type value.
    private HashMap<Integer, Bid> hashmap;

//    getter method for the hashmap instance var
    public HashMap<Integer, Bid> getHashmap() {
        return hashmap;
    }

//    constructor for bidsmanager
    public BidsManager(){
        this.hashmap = new HashMap<Integer, Bid>();
    }
//This method must create and a new instance of the Bid class and put in the HashMap attribute the <clientId, bid> pair.
    public void addBid(int clientID, double bidPrice, String bidDate){
        Utils util = new Utils();
        int bidID = util.nextID();
        Bid bid = new Bid(bidID, clientID, bidPrice, bidDate );
        hashmap.put(clientID, bid);
    }

}
