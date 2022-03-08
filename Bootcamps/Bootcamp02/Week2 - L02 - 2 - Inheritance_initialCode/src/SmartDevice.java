public class SmartDevice {
    //private attributes
    private String ipAddress;
    private boolean status;
    private double consumptionToday; //inWatts

    public SmartDevice(String _ipAddress, boolean _status) {
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
        System.out.println("The SmartDevice at " + this.ipAddress + " was turned ON successfully");
    }

    public void turnOff() {
        this.status = false;
        System.out.println("The SmartDevice at " + this.ipAddress + " was turned OFF successfully");
    }
}
