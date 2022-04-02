package edu.monash.fit2099;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.clients.Client;
import edu.monash.fit2099.taxation.TaxationManager;
import edu.monash.fit2099.vehicles.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CarAuction {
    // declared an arraylist of vehicle type
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    //created a scanner instance to use the methods to prompt user input
    static Scanner scanner = new Scanner(System.in);
    // declared an arraylist of client type
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
        String carMakerInput = scanner.nextLine();
        System.out.println("Car Model: ");
        String carModelInput = scanner.nextLine();
        System.out.println("Car Model Year: ");
        int carModelYearInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of seats: ");
        int numOfSeatsInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Is this car convertible?(True or False): ");
        boolean isConvertibleInput = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Vehicle ID: ");
        int vehicleIDInput = Integer.parseInt(scanner.nextLine());

        try{
            SportCar car = new SportCar(carMakerInput, carModelInput, carModelYearInput, numOfSeatsInput, isConvertibleInput);
            vehicles.add(car);
            System.out.println(car);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        SportCar sportcar = new SportCar(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput, numOfSeatsInput, isConvertibleInput);
        vehicles.add(sportcar);

        Utils util = new Utils();
        int clientID = util.nextID();

    }
//    this method will be called when the user wish to create a cruisebike so that it
//    will prompt for user input and take in the details and store it the vehicles list
    public void createCruiseBike(){
        System.out.println("Please enter Cruise Bike details: ");
        scanner.nextLine();
        System.out.println("Bike Maker: ");
        String carMakerInput = scanner.nextLine();
        System.out.println("Bike Model: ");
        String carModelInput = scanner.nextLine();
        System.out.println("Bike Model Year: ");
        int carModelYearInput = Integer.parseInt(scanner.nextLine());
        System.out.println("Which type? (Chopper or Bobber): ");
        String bikeTypeInput = scanner.nextLine();
        System.out.println("Vehicle ID: ");
        int vehicleIDInput = Integer.parseInt(scanner.nextLine());


        try{
            ChopperBike chopperBike = new ChopperBike(carMakerInput, carModelInput, carModelYearInput);
            BobberBike bobberBike = new BobberBike(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput);
            System.out.println(chopperBike);
            System.out.println(bobberBike);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ChopperBike chopper = new ChopperBike(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput);
        BobberBike bobber = new BobberBike(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput);
//       it will loop through the enum class and check if the user input biketype
//        is the same and then it will add it into the vehicle list

        if(chopper.getBikeType().equals(bikeTypeInput.toUpperCase()) ){
            vehicles.add(chopper);
        } else if (bobber.getBikeType().equals(bikeTypeInput.toUpperCase())){
            vehicles.add(bobber);
        }

    }

//this method will prompt the user to input the client details and then create a
//  client instance
    public void createClient(){
        System.out.println("Please enter Client details: ");
        scanner.nextLine();
        System.out.println("Client First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Client Second name: ");
        String secondName = scanner.nextLine();

        Utils util = new Utils();
        int clientID = util.nextID();
        Client client = Client.getInstance(firstName,secondName);
        clients.add(client);

    }
//this method will prompt the user to input the bid details and then it will call the
// addBid() in BidManager class.
    public void createBid(){
        System.out.println("Please enter bid details: ");
        scanner.nextLine();
        System.out.println("Vehicle ID: ");
        int vehicleId = Integer.parseInt(scanner.nextLine());
        System.out.println("Client ID: ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("Bid price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Date(dd/mm/yyyy): ");
        String date = scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < vehicles.size() ; i++){
            if (vehicleId == vehicles.get(i).getVehicleID()){
                BidsManager bidsManager= vehicles.get(i).getBidsManager();
                bidsManager.addBid(clientId, price, date);
                String vehicleDesc;
                String bidDesc;
                String taxDesc = "";
                vehicleDesc = "Bid for vehicle: " + vehicles.get(i).getVehicleID() + "| " + vehicles.get(i).description();
                for (Integer key : bidsManager.getHashmap().keySet()){
                    Bid bid = bidsManager.getHashmap().get(key);
                    bidDesc = String.join(",", "BidID=" + bid.getBidId(), " BuyerID=" + key , " price=" + bid.getBidPrice(), " date=" + bid.getDate().substring(bid.getDate().length()-4));
                    for (TaxableVehicle vehicle : TaxationManager.getInstance().getTaxableVehicle()){
                        if (vehicles.get(i).equals(vehicle)){
                            taxDesc = "Price: " + bid.getBidPrice() + " Tax: " + vehicle.calculateTaxRate(bid.getBidPrice());
                            break;
                        }else{
                            taxDesc = "Price: " + bid.getBidPrice() + " Tax: NO TAX";
                        }}
                    System.out.println(vehicleDesc + "\n" + bidDesc + "\n" + taxDesc);

                }
            }
        }
    }
    //    This method will display all the vehicles the users have created/inputted
    public void displayFleet(){
        for (int i = 0; i < vehicles.size(); i++) {
            int showingCarIndex = i + 1;
            System.out.println("Car (" + showingCarIndex + ") " + vehicles.get(i).description());
        }
    }
    //This method will display all the clients the users have created/inputted

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
                    break;
                case 4:
                    createClient();
                    break;
                case 5:
                    displayClients();
                    break;
                case 6:
                    createBid();
                    break;
                case 7:
                    System.exit(0);
                    break;
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
//    public int bidMenuItem(){
//        System.out.println("-----------------------");
//        System.out.println("1) Add bid");
//        System.out.println("2) back");
//        System.out.println("Select an option: ");
//        int choice = scanner.nextInt();
//        if (choice > 2  || choice < 1){
//            choice = 3;
//        }
//        return choice;
//    }
    //this method will printout the client Menu in console and prompt the user for an input
//    public int clientMenuItem(){
//        System.out.println("-----------------------");
//        System.out.println("1) Add client");
//        System.out.println("2) back");
//        System.out.println("Select an option: ");
//        int choice = scanner.nextInt();
//        if (choice > 2  || choice < 1){
//            choice = 3;
//        }
//        return choice;
//    }


}