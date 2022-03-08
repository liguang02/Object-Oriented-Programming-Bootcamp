import java.util.ArrayList;

public class SmartSwitch {

    //private attributes
    private String ipAddress;
    private boolean status;
    private double consumptionToday; //inWatts
    private ArrayList<SmartBulb> smartBulbs;

    //constructor
    public SmartSwitch(String _ipAddress, boolean _status) {
        this.ipAddress = _ipAddress;
        this.status = _status;
        this.smartBulbs = new ArrayList<SmartBulb>();
    }

    public void display() {
        System.out.println("SmartSwitch  at " + this.getIpAddress() + " is on: " + this.getStatus() + " Today's consumption: " + this.getConsumptionToday());
        int i = 0;
        for (SmartBulb smartBulb : this.getBulbs()) {
            i++;
            System.out.println("Bulb " + i + " at " + smartBulb.getIpAddress() + " is on: " + smartBulb.getStatus() + ". Colour:" + smartBulb.getColour() + ". Today's consumption: " + smartBulb.getConsumptionToday());
        }
    }

    //getters and setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean getStatus() {
        return status;
    }

    public double getConsumptionToday() {
        return Utils.getRandomConsumption();
    }

    //Other methods
    public void turnOn() {
        this.status = true;
        System.out.println("The SmartSwitch at "+ this.ipAddress +" was turned ON successfully");
    }

    public void turnOff() {
        this.status = false;
        System.out.println("The SmartSwitch at "+ this.ipAddress +" was turned OFF successfully");
    }


    public void addBulb(SmartBulb _smartBulb) {
        this.smartBulbs.add(_smartBulb);
    }

    public ArrayList<SmartBulb> getBulbs(){
        return this.smartBulbs;
    }

    public void turnAllOn(String colour) {
        this.status = true;
        for (SmartBulb smartbulb : smartBulbs
        ) {
            smartbulb.turnOn();
        }
    }

    public void turnAllOff() {
        this.status = true;
        for (SmartBulb smartbulb : smartBulbs
        ) {
            smartbulb.turnOff();
        }
    }

    public double getTotalConsumptionToday() {
        double totalConsumption = 0;
        totalConsumption += this.consumptionToday;
        for (SmartBulb smartbulb : smartBulbs
        ) {
            totalConsumption += smartbulb.getConsumptionToday();
        }
        return totalConsumption;
    }




}
