public class SmartTV extends SmartDevice{

    //private attributes

    private boolean isTimerOn;
    private int timerMinutes;

    //constructor
    public SmartTV(String _ipAddress, boolean _status) {
        super(_ipAddress,_status);

    }

    //getters and setters



    //other methods

    public void turnOn() {
        super.turnOn();
        System.out.println("The SmartTV at "+ super.getIpAddress() +" was turned ON succesfully");
    }

    public void turnOff() {
        super.turnOff();
        System.out.println("The SmartTV at "+ super.getIpAddress() +" was turned OFF succesfully");
    }

    public void setTimer(int _minutes)
    {
        this.isTimerOn=true;
        this.timerMinutes=_minutes;

        if(super.getStatus())
        {

            System.out.println("The smart TV at "+ super.getIpAddress() + " will turn on in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }
        else
        {
            System.out.println("The smart TV at "+ super.getIpAddress() + " will turn off in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }

    }

    public void display() {
        System.out.println("SmartTv  at " + getIpAddress() + " is on: " + getStatus() + " Today's consumption: " + super.getConsumptionToday());
    }
}
