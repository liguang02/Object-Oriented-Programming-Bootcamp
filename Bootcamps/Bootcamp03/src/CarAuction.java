import java.util.ArrayList;
import java.util.Scanner;

public class CarAuction {
    // declared an array of size 3
    private ArrayList<Car> cars = new ArrayList<Car>();
    //created a scanner instance to use the methods to prompt user input
    private Scanner scanner = new Scanner(System.in);

    //This method will invoke the i/o menu method which is displayCarMenu()
    public void printStatus(){
        System.out.println("Welcome to FIT2099 Car Auction Systems");
        displayCarMenu();
        System.out.println("Thank you for visiting FIT2099 Car Auction System");

    }
    //a method that will create objects of car, client and bid with the data that is obtained
    //from the user input
    public void createCars(){
        System.out.println("Please enter Car details: ");
        scanner.nextLine();
        System.out.println("Car Maker: ");
        String _carMaker = scanner.nextLine();
        System.out.println("Car Model: ");
        String _carModel = scanner.nextLine();
        System.out.println("Car Model Year");
        int _carModelYear = Integer.parseInt(scanner.nextLine());

        Car c1 = new Car(_carMaker, _carModel, _carModelYear);
        cars.add(c1);

        int bidSelection;
        do{
            bidSelection = bidClientMenuItem();
            switch(bidSelection){
                case 1:
                    System.out.println("Please enter bid details: ");
                    scanner.nextLine();
                    System.out.println("Bid price: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    System.out.println("Date(dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.println("Please enter Client details: ");
                    System.out.println("Client First name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Client Second name: ");
                    String secondName = scanner.nextLine();

                    Utils util = new Utils();
                    int clientID = util.nextID();
                    Client newClient = new Client(clientID, firstName, secondName);
                    c1.addBid(newClient, price, date);
                    break;
                case 2:
                    displayCarMenu();
            }
        }while (bidSelection != 10);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
    //this method will print out the description of all the cars, bids and clients' information.
    public void displayCars(){
        for(int i = 0; i < cars.size(); i++){
            int showingCarIndex = i + 1;
            System.out.println("Car (" + showingCarIndex + ") " + cars.get(i).description());
            for (int j = 0; j < cars.get(i).getBids().size(); j++){
                int showingBidindex = j + 1;
                Bid bid = cars.get(i).getBids().get(j);
                System.out.println("Bid (" + showingBidindex + ")");
                System.out.println("BidID: " + bid.getBidId() + " Bid price: " + bid.getBidPrice() + " Bid Date: " + bid.getDate());
                System.out.println(bid.getClient().description());
                System.out.println("-----------------------------------------------");
            }

        }
    }
    // This method will take care of the user input of carMenuitem()
    public void displayCarMenu(){
        int carSelection;
        do{
            carSelection = carMenuItem();
            switch(carSelection){
                case 1:
                    createCars();
                    break;
                case 2:
                    displayCars();
                    break;
                case 3:
                    System.exit(0);
                case 4:
                    System.out.println("Please select a valid option(1-3)");
                    break;
            }

        }while (carSelection!=10);
    }

    //this method will printout the carMenu in console and prompt the user for an input
    public int carMenuItem(){
        System.out.println("-----------------------");
        System.out.println("1) Create car");
        System.out.println("2) Display car and bid");
        System.out.println("3) Exit");
        System.out.println("Select an option: ");
        int choice = scanner.nextInt();
        if (choice > 3  || choice < 1){
            choice = 4;
        }

        return choice;
    }

    //this method will printout the bid Menu in console and prompt the user for an input
    public int bidClientMenuItem(){
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

}