import java.util.ArrayList;

public class SmartSwitch {
    private ArrayList<SmartBulb> smartBulbs;
    private boolean status;
    private double consumptionToday;

    public SmartSwitch(){
        this.smartBulbs = new ArrayList<SmartBulb>();
    }

    public void addBulb(SmartBulb _smartBulb){
        this.smartBulbs.add(_smartBulb);
    }

    public void turnAllOn(String colour){
        this.turnOn();
        for(SmartBulb smartBulb: smartBulbs){
            smartBulb.turnOn();
            smartBulb.setColour(colour);
        }
    }

    public void turnAllOff(){
        this.turnOn();
        for(SmartBulb smartBulb: smartBulbs){
            smartBulb.turnOff();
        }
    }

    public void turnOn() {
        this.status = true;
    }

    public void turnOff() {
        this.status = false;
    }

    public double getConsumptionToday() {
        double totalConsumption = 0;
        totalConsumption += this.consumptionToday;
        for(SmartBulb smartBulb: smartBulbs){
            totalConsumption += smartBulb.getConsumptionToday();
        }
        return totalConsumption;
    }

    public void display(){
        int i = 0;
        for (SmartBulb smartBulb: smartBulbs){
            i++;
            System.out.println("Bulb " + i + " is on: " + smartBulb.getStatus() + " Colour: " + smartBulb.getColour());
        }
    }
}
