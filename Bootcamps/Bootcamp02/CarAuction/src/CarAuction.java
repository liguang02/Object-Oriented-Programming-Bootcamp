public class CarAuction {
    // declared an array of size 3
    private Car[] cars = new Car[3];

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
        cars[0] = c1;
        cars[1] = c2;
        cars[2] = c3;
    }
    public Car[] getCars() {
        return cars;
    }

    public void displayCars(){
        for(int i = 0; i < cars.length ; i++){
            int showingIndex = i + 1;
            System.out.println("Car (" + showingIndex + ") " + cars[i].getCarDescription());

        }
    }
}
