import java.util.Scanner;


public class SmartHomeDriver {

    public static void main(String[] args) {

        //SETUP IOT Ecosystem
        SmartSwitch smartSwitch1=new SmartSwitch("128.1.1.1",false);
        smartSwitch1.addBulb(new SmartBulb("128.1.1.2",false,"red","dimmable"));
        smartSwitch1.addBulb(new SmartBulb("128.1.1.3",false,"blue", "nonDimmable"));

        SmartTV smartTVV1 = new SmartTV("128.1.1.4", false);

        SmartHeater smartHeater1= new SmartHeater("128.1.1.5", false);
        SmartHeater smartHeater2= new SmartHeater("128.1.1.6", false);

        LedStripe ledStripe1 = new LedStripe("128.1.1.7",false,"yellow", "dimmable");
        LedStripe ledStripe2 = new LedStripe("128.1.1.8",false,"yellow", "dimmable");
        ledStripe1.attachLedStripe(ledStripe2);



        //LOAD CONTROL MENU
        int selection;
        do {
            selection = menuItem();
            switch (selection) {
                case 1:
                    smartSwitch1.turnOn();
                    smartSwitch1.turnAllOn("red");
                    smartTVV1.turnOn();
                    smartHeater1.turnOn(20);
                    smartHeater2.turnOn(20);
                    ledStripe1.turnOn();
                    break;
                case 2:
                    smartSwitch1.turnOff();
                    smartSwitch1.turnAllOff();
                    smartTVV1.turnOff();
                    smartHeater1.turnOff();
                    smartHeater2.turnOff();
                    ledStripe1.turnOff();
                    break;
                case 3:
                    smartSwitch1.display();
                    smartTVV1.display();
                    smartHeater1.display();
                    smartHeater2.display();
                    ledStripe1.display();
                    break;

                case 0:
                    System.exit(0);
            }


        } while (selection != 7);
    }

    public static int menuItem() {
            Scanner sel = new Scanner(System.in);

            System.out.println("+-------------------------------------+");
            System.out.println("|            Welcome to the           |");
            System.out.println("|      Smart Home control system      |");
            System.out.println("+-------------------------------------+");

            System.out.println("1) Turn all devices ON");
            System.out.println("2) Turn all devices OFF");
            System.out.println("3) Display status of all devices");


            System.out.println("0) Exit");
            System.out.print("Select an option:");
            int choice = Integer.parseInt(sel.nextLine()); // try catch must be added
            return choice;
        }



}
