package edu.monash.fit2099.bids;

import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;

import java.util.HashMap;

public class BidsManager {
    private HashMap<Integer, Bid> hashmap;

    public HashMap<Integer, Bid> getHashmap() {
        return hashmap;
    }

    public BidsManager(){
        this.hashmap = new HashMap<Integer, Bid>();
    }
//This method must create and a new instance of the edu.monash.fit2099.bids.Bid class and put in the HashMap attribute the <clientId, bid> pair.
    public void addBid(int clientID, double bidPrice, String bidDate){
        Utils util = new Utils();
        int bidID = util.nextID();
        Bid bid = new Bid(bidID, clientID, bidPrice, bidDate );
        hashmap.put(clientID, bid);
    }

}
