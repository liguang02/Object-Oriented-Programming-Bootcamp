package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;
import edu.monash.fit2099.vehicles.CruiserBikeType;
public class CruiserBike  extends Vehicle {
    private CruiserBikeType type;



    public CruiserBike(String _carMake, String _carModel, int _carModelYear, CruiserBikeType _type) {
        super(_carMake, _carModel, _carModelYear);
        this.type = _type;
    }

    public CruiserBike(String _carMake, String _carModel, int _carModelYear, int _vehicleID, CruiserBikeType _type) {
        super(_carMake, _carModel, _carModelYear, _vehicleID);
        this.type = _type;
    }
    public String description(){
        String carDesc = ("MY" + super.getCarModelYear() + " " + super.getCarMake() + " " + super.getCarModel() + " " + this.type);
        return carDesc;
    }
}
