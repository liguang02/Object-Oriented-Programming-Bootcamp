import java.util.ArrayList;

public class SmartSwitch extends SmartDevice{

    //private attributes
    private ArrayList<SmartLighting> smartLightings;

    //constructor
    public SmartSwitch(String _ipAddress, boolean _status) {
        super(_ipAddress, _status);
        this.smartLightings = new ArrayList<>();
    }

    //getters and setters
    public void addLightingDevice(SmartLighting _smartLighting) {
        this.smartLightings.add(_smartLighting);
    }

    public ArrayList<SmartLighting> getBulbs(){
        return this.smartLightings;
    }

    //Other methods
    public void turnOn() {
        super.setStatus(true);
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned ON succesfully");
    }

    public void turnOff() {
        super.setStatus(false);
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned OFF succesfully");
    }

    public void turnAllOn(String colour) {
        super.setStatus(true);
        for (SmartLighting smartbulb : smartLightings
        ) {
            smartbulb.turnOn();
        }
    }

    public void turnAllOff() {
        super.setStatus(false);
        for (SmartLighting smartbulb : smartLightings
        ) {
            smartbulb.turnOff();
        }
    }

    public double getTotalConsumptionToday() {
        double totalConsumption = 0;
        totalConsumption += super.getConsumptionToday();
        for (SmartLighting smartbulb : smartLightings
        ) {
            totalConsumption += smartbulb.getConsumptionToday();
        }
        return totalConsumption;
    }

    public void display() {
        System.out.println("SmartSwitch  at " + super.getIpAddress() + " is on: " + super.getStatus() + " Today's consumpion: " + super.getConsumptionToday());
        int i = 0;
        for (SmartLighting smartLighting : this.getBulbs()) {
            i++;
            System.out.println("Bulb " + i + " at " + smartLighting.getIpAddress() + " is on: " + smartLighting.getStatus() + ". Colour:" + smartLighting.getColour() + ". Today's consumpion: " + smartLighting.getConsumptionToday());
        }
    }


}
