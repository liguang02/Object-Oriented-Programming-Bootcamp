import org.w3c.dom.ls.LSOutput;

//import java.util.Date;

public class Bid {
    private int bidId;
    private Client client;
    private double bidPrice;
    // string
    private String date;

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

    public Bid(int bidId, Client client, double bidPrice, String date) {
        this.bidId = bidId;
        this.client = client;
        this.bidPrice = bidPrice;
        this.date = date;
    }
}
