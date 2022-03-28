public class SportCar extends Vehicle{
    //instance variable for SportCar class
    private int seats;
    private boolean isConvertible;

    public SportCar(String _carMake, String _carModel, int _carModelYear, int _seats, boolean _isConvertible) {
        super(_carMake, _carModel, _carModelYear);
        this.seats = _seats;
        this.isConvertible = _isConvertible;
    }

    public SportCar(String _carMake, String _carModel, int _carModelYear, int _vehicleID, int _seats, boolean _isConvertible){
        super(_carMake, _carModel, _carModelYear, _vehicleID);
        this.seats = _seats;
        this.isConvertible = _isConvertible;
    }

}
