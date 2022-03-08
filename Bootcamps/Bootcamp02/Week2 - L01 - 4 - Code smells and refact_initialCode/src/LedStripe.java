public class LedStripe {

    //private attributes
    private String ipAddress;
    private boolean status;
    private String colour;
    private double consumptionToday; //inWatts
    private String type;
    private int dimmingLevel;

    private LedStripe nextLedStripe;

    //constructor
    public LedStripe(String _ipAddress, boolean _status, String _colour, String _type) {
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

    public LedStripe getNextLedStripe() {
        return this.nextLedStripe;
    }

    public void setDimmingLevel(int dimmingLevel) {
        if (this.type=="dimmable")
            this.dimmingLevel = dimmingLevel;
    }

    //other methods
    public void turnOn() {
        this.status = true;
        System.out.println("The LedStripe at "+ this.ipAddress +" was turned on successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOn();
        }
    }

    public void turnOff() {
        this.status = false;
        System.out.println("The LedStripe at "+ this.ipAddress +" was turned off successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOff();
        }
    }
    public void attachLedStripe(LedStripe _ledStripe)
    {
        this.nextLedStripe=_ledStripe;
        if(this.status)
            this.nextLedStripe.turnOn();
        else
            this.nextLedStripe.turnOff();
    }

    public void detachLedStripe()
    {
        this.nextLedStripe=null;
    }

    public void display() {
        System.out.println("LedStripe  at " + this.getIpAddress() + " is on: " + this.getStatus() + ". Colour:" + this.getColour() + " Today's consumption: " + this.getConsumptionToday());
        if(this.nextLedStripe != null)
            this.nextLedStripe.display();
    }



}
