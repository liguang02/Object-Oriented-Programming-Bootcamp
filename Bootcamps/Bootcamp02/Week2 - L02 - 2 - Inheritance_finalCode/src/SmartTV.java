public class SmartTV extends SmartDevice{

    private boolean isTimerOn;
    private int timerMinutes;

    //constructor
    public SmartTV(String _ipAddress, boolean _status) {
        super(_ipAddress, _status);
    }

    //other methods
    public void turnOn() {
        super.setStatus(true);
        System.out.println("The SmartTV at "+ super.getIpAddress() +" was turned ON succesfully");
    }

    public void turnOff() {
        super.setStatus(false);
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
        System.out.println("SmartTv  at " + getIpAddress() + " is on: " + getStatus() + " Today's consumpion: " + getConsumptionToday());
    }
}
