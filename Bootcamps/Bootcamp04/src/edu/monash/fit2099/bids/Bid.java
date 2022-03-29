package edu.monash.fit2099.bids;//import java.util.Date;

public class Bid {
    // instance variables(4) of bid class
    private int bidId;
    private int clientId;
    private double bidPrice;
    // string
    private String date;

    // setter and getter methods for all the instance variables in this class
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //Constructor for bid class
    public Bid(Integer bidId, int clientId, double bidPrice, String date) {
        this.bidId = bidId;
        this.clientId = clientId;
        this.bidPrice = bidPrice;
        this.date = date;
    }



}
