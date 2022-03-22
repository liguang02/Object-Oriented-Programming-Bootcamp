//import java.util.Date;

public class Bid {
    // instance variables(4) of bid class
    private int bidId;
    private Client client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
    public Bid(Integer bidId, Client client, double bidPrice, String date) {
        this.bidId = bidId;
        this.client = client;
        this.bidPrice = bidPrice;
        this.date = date;
    }



}
