public class CruiserBike  extends  Vehicle{
    private CruiseBikeType type;

    public enum CruiseBikeType{
        CHOPPER,
        BOBBER
    }
    public CruiserBike(String _carMake, String _carModel, int _carModelYear, CruiseBikeType _type) {
        super(_carMake, _carModel, _carModelYear);
        this.type = _type;
    }

    public CruiserBike(String _carMake, String _carModel, int _carModelYear, int _vehicleID, CruiseBikeType _type) {
        super(_carMake, _carModel, _carModelYear, _vehicleID);
        this.type = _type;
    }
}
