public class Car {
    //instance variables
    private String carMake;
    private String carModel;
    private int carModelYear;

    //constructor
    public Car(String _carMake, String _carModel, int _carModelYear){
        this.carMake = _carMake;
        this.carModel = _carModel;
        this.carModelYear = _carModelYear;
    }
    //getter and setter
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }

    //other methods
    public String getCarDescription(){
        String carDesc = ("MY" + this.carModelYear + " " + this.carMake + " " + this.carModel);
        return carDesc;
    }
}
