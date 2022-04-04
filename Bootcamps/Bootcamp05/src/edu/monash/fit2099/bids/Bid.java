package edu.monash.fit2099.bids;//import java.util.Date;
/**
 * Bid class represents the bid in this program
 * @author lcha0068
 * @version 1.0.0
 */
public class Bid {
    // instance variables(4) of bid class
    /**
     * the id for the each bid
     */
    private int bidId;
    /**
     * the id for client
     */
    private int clientId;
    /**
     * the bid price
     */
    private double bidPrice;
    /**
     * the bid date
     */
    private String date;

    /**
     * A constructor for the bid class
     * @param bidId id for bid
     * @param clientId id for client
     * @param bidPrice bid price
     * @param date bid date
     */
    //Constructor for bid class
    public Bid(Integer bidId, int clientId, double bidPrice, String date) {
        this.bidId = bidId;
        this.clientId = clientId;
        this.bidPrice = bidPrice;
        this.date = date;
    }

    // setter and getter methods for all the instance variables in this class

    /**
     * A getter for the bid id
     * @return an int representing the bid id
     */
    public int getBidId() {
        return bidId;
    }

    /**
     * A getter for the bid price
     * @return a double representing the bid price
     */
    public double getBidPrice() {
        return bidPrice;
    }

    /**
     * A getter for the bid date
     * @return a string representing the bid date
     */
    public String getDate() {
        return date;
    }





}
