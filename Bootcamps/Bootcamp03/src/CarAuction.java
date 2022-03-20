import java.util.ArrayList;
public class CarAuction {
    // declared an array of size 3
    private ArrayList<Car> cars = new ArrayList<Car>();

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Car Auction Systems");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Car Auction System");
        //task 3 is as below:
//        Car c1 = new Car("Audi", "TT", 2014);
//        System.out.println(c1.getCarDescription());
    }

    public void createCars(){
        Car c1 = new Car("BMW", "X7", 2017);
        Car c2 = new Car("Audi", "TT", 2014);
        Car c3 = new Car("Chevrolet", "Corvette", 2020);
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
    }
    public ArrayList<Car> getCars() {
        return cars;
    }

    public void displayCars(){
        for(int i = 0; i < cars.size(); i++){
            int showingIndex = i + 1;
            System.out.println("Car (" + showingIndex + ") " + cars.get(i).description());
        }
    }
}