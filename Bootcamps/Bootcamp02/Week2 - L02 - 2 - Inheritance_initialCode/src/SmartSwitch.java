import java.util.ArrayList;

public class SmartSwitch extends SmartDevice{

    //private attributes

    private ArrayList<SmartLighting> smartLightings;

    //constructor
    public SmartSwitch(String _ipAddress, boolean _status) {
        super(_ipAddress, _status);
        this.smartLightings = new ArrayList<SmartLighting>();
    }



    //getters and setters

    //Other methods
    public void turnOn() {
        super.turnOn();
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned ON successfully");
    }

    public void turnOff() {
        super.turnOff();
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned OFF successfully");
    }


    public void addLighting(SmartLighting _smartLighting) {
        this.smartLightings.add(_smartLighting);
    }

    public ArrayList<SmartLighting> getBulbs(){
        return this.smartLightings;
    }

    public void turnAllOn(String colour) {
        super.turnOn();
        for (SmartLighting smartLighting : smartLightings
        ) {
            smartLighting.turnOn();
        }
    }

    public void turnAllOff() {
        super.turnOff();
        for (SmartLighting smartLighting : smartLightings
        ) {
            smartLighting.turnOff();
        }
    }

    public double getTotalConsumptionToday() {
        double totalConsumption = 0;
        totalConsumption += super.getConsumptionToday();
        for (SmartLighting smartLighting : smartLightings
        ) {
            totalConsumption += smartLighting.getConsumptionToday();
        }
        return totalConsumption;
    }

    public void display() {
        System.out.println("SmartSwitch  at " + this.getIpAddress() + " is on: " + this.getStatus() + " Today's consumption: " + super.getConsumptionToday());
        int i = 0;
        for (SmartLighting smartLighting : this.getBulbs()) {
            i++;
            System.out.println("SmartLighting " + i + " at " + super.getIpAddress() + " is on: " + smartLighting.getStatus() + ". Colour:" + smartLighting.getColour() + ". Today's consumption: " + smartLighting.getConsumptionToday());
        }
    }


}
