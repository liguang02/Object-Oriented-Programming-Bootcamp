public class SmartHomeDriver {

    public static void main(String[] args) {


        System.out.println("Welcome to the Smart Home System");

        SmartSwitch smartSwitch = new SmartSwitch();

        smartSwitch.turnOn();

        smartSwitch.addBulb(new SmartBulb(true,"red "));
        smartSwitch.addBulb(new SmartBulb(false, "blue"));

        smartSwitch.display();

        smartSwitch.turnAllOff();
        smartSwitch.turnAllOn("black");

        smartSwitch.display();
//        SmartBulb SB1 = new SmartBulb();
//        SmartBulb SB2 = new SmartBulb(true, "BLUE");
//        String c1 = SB1.getColour();
//        String c2 = SB2.getColour();
//        System.out.println(c1);
//        System.out.println(c2);
//
//        SB1.setColour("BLACK");
//        SB2.setColour("RED");
//        String c3 = SB1.getColour();
//        String c4 = SB2.getColour();
//        System.out.println(c3);
//        System.out.println(c4);
//
//        boolean s1 = SB1.getStatus();
//        boolean s2 = SB2.getStatus();
//        System.out.println(s1);
//        System.out.println(s2);
//
//        SB1.turnOn();
//        SB2.turnOff();

//        boolean s3 = SB1.getStatus();
//        boolean s4 = SB2.getStatus();
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(SB1.getConsumptionToday());

    }

}