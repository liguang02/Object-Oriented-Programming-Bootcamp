package edu.monash.fit2099;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.clients.Client;
import edu.monash.fit2099.taxation.TaxationManager;
import edu.monash.fit2099.vehicles.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * CarAuction class is a class that handles all the core activities
 * such as creating sport car/cruiserbike/bid/client and so on. It
 * is also responsible to display the menu items.
 */
public class CarAuction {
    /**
     * An array list of vehicles
     */
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    //created a scanner instance to use the methods to prompt user input
    /**
     * A scanner class to use the nextLine() to prompt the user input
     */
    static Scanner scanner = new Scanner(System.in);
    /**
     * An array list of client type
     */
    private ArrayList <Client> clients = new ArrayList<Client>();

    /**
     * This method will invoke the i/o menu method which is displayCarMenu()
     */
    public void printStatus(){
        System.out.println("Welcome to FIT2099 Car Auction Systems");
        displayCarMenu();
        System.out.println("Thank you for visiting FIT2099 Car Auction System");

    }



    /**
     *     this method will be called when the user wish to create a sport car so that it
     *     will prompt for user input and take in the details and store it the vehicles list
     * @exception Exception will throw an exception if the user input is invalid.
     */
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

        //a try and catch clause to check the user inputted values can be used to create the instances of the
        // sport car.
        try{
            SportCar car = new SportCar(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput, numOfSeatsInput, isConvertibleInput);
            vehicles.add(car);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    /**
     *     this method will be called when the user wish to create a cruisebike so that it
     *     will prompt for user input and take in the details and store it the vehicles list
     *     @exception Exception will throw an exception if the user input is invalid.
     */
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

        //a try and catch clause to check the user inputted values can be used to create the instances of the
        // cruiser bikes and check if the bike type is belongs to which cruiser bike. It will throw an
        //exception if the user input is invalid.
        try{
            ChopperBike chopperBike = new ChopperBike(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput);
            BobberBike bobberBike = new BobberBike(carMakerInput, carModelInput, carModelYearInput, vehicleIDInput);
            if(chopperBike.getBikeType().equals(bikeTypeInput.toUpperCase()) ){
                vehicles.add(chopperBike);
            } else if (bobberBike.getBikeType().equals(bikeTypeInput.toUpperCase())){
                vehicles.add(bobberBike);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }



    /**
     *   this method will prompt the user to input the client details and then create a
     *   client instance
     */
    public void createClient(){
        System.out.println("Please enter Client details: ");
        scanner.nextLine();
        System.out.println("Client First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Client Second name: ");
        String secondName = scanner.nextLine();

        Client client = Client.getInstance(firstName,secondName);
        clients.add(client);

    }


    /**
     * this method will prompt the user to input the bid details and then it will call the
     *  addBid() in BidManager class.
     */
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

    /**
     *   This method will display all the vehicles the users have created/inputted
     */
    public void displayFleet(){
        for (int i = 0; i < vehicles.size(); i++) {
            int showingCarIndex = i + 1;
            System.out.println("Car (" + showingCarIndex + ") " + vehicles.get(i).description());
        }
    }

    /**
     *     This method will display all the clients the users have created/inputted
     */
    public void displayClients(){
        for (int i = 0; i< clients.size(); i++){
            int showingClientIndex = i+ 1;
            System.out.println("Client (" + showingClientIndex + ") " + clients.get(i).description());
        }
    }

    /**
     *      This method will take care of the user input of carMenuitem()
     */
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

    /**
     * this method will printout the carMenu in console and prompt the user for an input
     * @return an integer representing the user's input of choice for a certain action
     */
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



}