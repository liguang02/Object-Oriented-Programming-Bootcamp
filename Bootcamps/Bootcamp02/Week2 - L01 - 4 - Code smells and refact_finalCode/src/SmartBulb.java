public class SmartBulb {

    //private attributes
    private String ipAddress;
    private boolean status;
    private double consumptionToday; //inWatts
    private String colour;
    private String type;
    private int dimmingLevel;

    //constructor
    public SmartBulb(String _ipAddress, boolean _status, String _colour, String _type) {
        this.ipAddress = _ipAddress;
        this.status = _status;
        this.colour = _colour;
        this.type=_type; // "dimmable or notDimmable"
        this.dimmingLevel=100;
    }

    //getters and setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean getStatus() {
        return status;
    }


    public double getConsumptionToday() {
        return Utils.getRandomConsumption();
    }

    public void setDimmingLevel(int dimmingLevel) {
        if (this.type=="dimmable")
            this.dimmingLevel = dimmingLevel;
    }

    //other methods
    public void turnOn() {
        this.status = true;
        System.out.println("The SmartBulb at "+ this.ipAddress +" was turned ON successfully");
    }

    public void turnOff() {
        this.status = false;
        System.out.println("The SmartBulb at "+ this.ipAddress +" was turned OFF successfully");
    }


}
