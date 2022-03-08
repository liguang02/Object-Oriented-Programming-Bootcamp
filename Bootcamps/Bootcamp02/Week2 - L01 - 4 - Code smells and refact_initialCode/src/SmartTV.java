public class SmartTV {

    //private attributes
    private String ipAddress;
    private boolean status;
    private double consumptionToday; //inWatts
    private boolean isTimerOn;
    private int timerMinutes;

    //constructor
    public SmartTV(String _ipAddress, boolean _status) {
        this.ipAddress = _ipAddress;
        this.status = _status;

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
    //other methods

    public void turnOn() {
        this.status = true;
        System.out.println("The SmartTV at "+ this.ipAddress +" was turned ON succesfully");
    }

    public void turnOff() {
        this.status = false;
        System.out.println("The SmartTV at "+ this.ipAddress +" was turned OFF succesfully");
    }

    public void setTimer(int _minutes)
    {
        this.isTimerOn=true;
        this.timerMinutes=_minutes;

        if(this.status)
        {

            System.out.println("The smart TV at "+ this.ipAddress + " will turn on in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }
        else
        {
            System.out.println("The smart TV at "+ this.ipAddress + " will turn off in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }

    }
    public void display() {
        System.out.println("Smart TV at " + this.getIpAddress() + " is on: " + this.getStatus() + ". Today's consumption: " + this.getConsumptionToday());
        ;
    }

}
