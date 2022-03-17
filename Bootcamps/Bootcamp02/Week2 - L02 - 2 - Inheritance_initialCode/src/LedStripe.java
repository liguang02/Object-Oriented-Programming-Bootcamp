public class LedStripe extends SmartLighting{

    //private attributes


    private LedStripe nextLedStripe;

    //constructor
    public LedStripe(String _ipAddress, boolean _status, String _colour, String _type) {
        super(_ipAddress,_status, _colour, _type);

    }



    //getters and setters

    public LedStripe getNextLedStripe() {
        return this.nextLedStripe;
    }



    //other methods
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("The LedStripe at "+ super.getIpAddress() +" was turned on successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOn();
        }
    }
    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("The LedStripe at "+ super.getIpAddress() +" was turned off successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOff();
        }
    }
    public void attachLedStripe(LedStripe _ledStripe)
    {
        this.nextLedStripe=_ledStripe;
        if(super.getStatus())
            this.nextLedStripe.turnOn();
        else
            this.nextLedStripe.turnOff();
    }

    public void detachLedStripe()
    {
        this.nextLedStripe=null;
    }

    public void display() {
        System.out.println("LedStripe  at " + super.getIpAddress() + " is on: " + super.getStatus() + ". Colour:" + super.getColour() + " Today's consumption: " + super.getConsumptionToday());
        if (this.nextLedStripe != null)
            this.nextLedStripe.display();
    }

}
