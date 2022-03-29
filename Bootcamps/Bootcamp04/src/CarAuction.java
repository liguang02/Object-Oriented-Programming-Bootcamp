import edu.monash.fit2099.Utils;
import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.clients.Client;
import edu.monash.fit2099.vehicles.CruiserBike;
import edu.monash.fit2099.vehicles.CruiserBikeType;
import edu.monash.fit2099.vehicles.SportCar;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class CarAuction {
    // declared an array of size 3
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    //created a scanner instance to use the methods to prompt user input
    static Scanner scanner = new Scanner(System.in);

    private ArrayList <Client> clients = new ArrayList<Client>();
    //This method will invoke the i/o menu method which is displayCarMenu()
    public void printStatus(){
        System.out.println("Welcome to FIT2099 Car Auction Systems");
        displayCarMenu();
        System.out.println("Thank you for visiting FIT2099 Car Auction System");

    }

    //a method that will create objects of car, client and bid with the data that is obtained
    //from the user input
    public void createSportCar(){
        System.out.println("Please enter Sport Car details: ");
        scanner.nextLine();
        System.out.println("Car Maker: ");
        String _carMaker = scanner.nextLine();
        System.out.println("Car Model: ");
        String _carModel = scanner.nextLine();
        System.out.println("Car Model Year: ");
        int _carModelYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of seats: ");
        int _numOfSeats = Integer.parseInt(scanner.nextLine());
        System.out.println("Is this car convertible?(True or False): ");
        boolean _isConvertible = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Vehicle ID: ");
        int _vehicleID = Integer.parseInt(scanner.nextLine());
//
        SportCar sportcar = new SportCar(_carMaker, _carModel, _carModelYear, _vehicleID, _numOfSeats, _isConvertible);
        vehicles.add(sportcar);

        Utils util = new Utils();
        int clientID = util.nextID();

    }
    public void createCruiseBike(){
        System.out.println("Please enter Cruise Bike details: ");
        scanner.nextLine();
        System.out.println("Bike Maker: ");
        String _carMaker = scanner.nextLine();
        System.out.println("Bike Model: ");
        String _carModel = scanner.nextLine();
        System.out.println("Bike Model Year: ");
        int _carModelYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Which type? (Chopper or Bobber): ");
        String _bikeType = scanner.nextLine();
        System.out.println("Vehicle ID: ");
        int _vehicleID = Integer.parseInt(scanner.nextLine());
        CruiserBikeType bobberBike = CruiserBikeType.BOBBER;
        CruiserBikeType chopperBike = CruiserBikeType.CHOPPER;

        CruiserBike cruiserBike = null;
        if (_bikeType.equalsIgnoreCase("bobber")){
            CruiserBikeType bikeType = bobberBike;
            cruiserBike = new CruiserBike(_carMaker, _carModel, _carModelYear, _vehicleID, bikeType);
            vehicles.add(cruiserBike);
        }
        else if (_bikeType.equalsIgnoreCase("chopper")){
            CruiserBikeType bikeType = chopperBike;
            cruiserBike = new CruiserBike(_carMaker, _carModel, _carModelYear, _vehicleID, bikeType);
            vehicles.add(cruiserBike);
        }
        else{
            System.out.println("Invalid Cruiser bike type! ");
        }

//



    }

    public void createClient(){
        int bidSelection;
        do{
            bidSelection = clientMenuItem();
            switch(bidSelection){
                case 1:
                    System.out.println("Please enter Client details: ");
                    System.out.println("Client First name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Client Second name: ");
                    String secondName = scanner.nextLine();

                    Utils util = new Utils();
                    int clientID = util.nextID();
                    Client client = new Client(clientID,firstName,secondName);
                    clients.add(client);
                    break;
                case 2:
                    displayCarMenu();
            }
        }while (bidSelection != 10);

    }

    public void createBid(){
        int bidSelection;
        do{
            bidSelection = bidMenuItem();
            switch(bidSelection){
                case 1:
                    System.out.println("Please enter bid details: ");
                    scanner.nextLine();
                    System.out.println("Vehicle ID: ");
                    int vehicleId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Client ID: ");
                    int clientId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Bid price: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    System.out.println("Date(dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    
                    for (int i = 0; i < vehicles.size() ; i++){
                        if (vehicleId == vehicles.get(i).getVehicleID()){
                            vehicles.get(i).addBid(clientId, price, date);
                        }
                    }

                    break;
                case 2:
                    displayCarMenu();
            }
        }while (bidSelection != 10);
    }
    public void displayFleet(){
        for (int i = 0; i < vehicles.size(); i++) {
            int showingCarIndex = i + 1;
            System.out.println("Car (" + showingCarIndex + ") " + vehicles.get(i).description());
        }
    }
    public void displayClients(){
        for (int i = 0; i< clients.size(); i++){
            int showingClientIndex = i+ 1;
            System.out.println("Client (" + showingClientIndex + ") " + clients.get(i).description());
        }
    }

    //this method will print out the description of all the cars, bids and clients' information.
//    public void displayCars(){
//        for(int i = 0; i < vehicles.size(); i++){
//            int showingCarIndex = i + 1;
//            System.out.println("Car (" + showingCarIndex + ") " + vehicles.get(i).description());
//            int j = 0;
//            for (int bidKey: vehicles.get(i).getBidsManager().getHashmap().keySet()){
//                int showingBidindex = j + 1;
//                Bid bid = vehicles.get(i).getBidsManager().getHashmap().get(bidKey);
//                System.out.println("Bid (" + showingBidindex + ")");
//                System.out.println("BidID: " + bid.getBidId() + " Bid price: " + bid.getBidPrice() + " Bid Date: " + bid.getDate());
//                System.out.println(bid.getClientId().description());
//                System.out.println("-----------------------------------------------");
//            }
//
//        }
//    }
    // This method will take care of the user input of carMenuitem()
    public void displayCarMenu(){
        int carSelection;
        do{
            carSelection = carMenuItem();
            switch(carSelection){
                case 1:
                    createSportCar();
                    break;
                case 2:
                    createCruiseBike();
                    break;
                case 3:
                    displayFleet();
                case 4:
                    createClient();
                case 5:
                    displayClients();
                case 6:
                    createBid();
                case 7:
                    System.exit(0);
                case 8:
                    System.out.println("Please select a valid option(1-3)");
                    break;
            }

        }while (carSelection!=10);
    }

    //this method will printout the carMenu in console and prompt the user for an input
    public int carMenuItem(){
        System.out.println("-----------------------");
        System.out.println("1) New Sport Car");
        System.out.println("2) New Cruiser Bike");
        System.out.println("3) Display fleet");
        System.out.println("4) Add Client");
        System.out.println("5) List Clients");
        System.out.println("6) Add Bid");
        System.out.println("7) Exit");
        System.out.println("Select an option: ");
        int choice = scanner.nextInt();
        if (choice > 7  || choice < 1){
            choice = 8;
        }

        return choice;
    }

   //this method will printout the bid Menu in console and prompt the user for an input
    public int bidMenuItem(){
        System.out.println("-----------------------");
        System.out.println("1) Add bid");
        System.out.println("2) back");
        System.out.println("Select an option: ");
        int choice = scanner.nextInt();
        if (choice > 2  || choice < 1){
            choice = 3;
        }
        return choice;
    }
    //this method will printout the client Menu in console and prompt the user for an input
    public int clientMenuItem(){
        System.out.println("-----------------------");
        System.out.println("1) Add client");
        System.out.println("2) back");
        System.out.println("Select an option: ");
        int choice = scanner.nextInt();
        if (choice > 2  || choice < 1){
            choice = 3;
        }
        return choice;
    }


}