public class SmartLighting extends SmartDevice {

    private String colour;
    private String type;
    private int dimmingLevel;

    //constructor
    public SmartLighting(String _ipAddress, boolean _status, String _colour, String _type) {
        super(_ipAddress, _status);
        this.colour = _colour;
        this.type=_type; // "dimmable or notDimmable"
        this.dimmingLevel=100;
    }

    //getters and setters
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    //Other methods
    public void turnOn() {
        super.setStatus(true);
        System.out.println("The SmartLighting  at "+ super.getIpAddress() +" was turned ON succesfully");
    }

    public void turnOff() {
        super.setStatus(false);
        System.out.println("The SmartLighting  at "+ super.getIpAddress() +" was turned OFF succesfully");
    }

    public void setDimmingLevel(int dimmingLevel) {
        if (this.type.equals("dimmable"))
            this.dimmingLevel = dimmingLevel;
    }


}
