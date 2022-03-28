import java.util.ArrayList;

abstract public class Vehicle {
    //instance variables
    private String carMake;
    private String carModel;
    private int carModelYear;
    private ArrayList<Bid> bids = new ArrayList<Bid>();
    private int vehicleID;


    //constructor
    public Vehicle(String _carMake, String _carModel, int _carModelYear){
        this.carMake = _carMake;
        this.carModel = _carModel;
        this.carModelYear = _carModelYear;
    }
    public Vehicle(String _carMake, String _carModel, int _carModelYear, int _vehicleID){
        this.carMake = _carMake;
        this.carModel = _carModel;
        this.carModelYear = _carModelYear;
        this.vehicleID = _vehicleID;
    }
    //getter and setter methods for carMake, carModel and carModelYear
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }


    // assessor method that returns a description of the Client object
    public String description(){
        String carDesc = ("MY" + this.carModelYear + " " + this.carMake + " " + this.carModel);
        return carDesc;
    }

    //this method will add a bid instance into the bid array list(declared in this class)
    public void addBid(Client newClient, double price, String date){
        Utils util = new Utils();
        int bidID = util.nextID();
        Bid b1 = new Bid(bidID, newClient,price,date);
        bids.add(b1);
    }

}