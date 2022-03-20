public class Client {
    private int clientId;
    private String firstName;
    private String lastName;

    public Client(int newClientId){
        this.clientId = newClientId;
    }

    public Client(int newClientId, String newFirstName, String newLastName){
        this.clientId = newClientId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String description(){
        String clientDesc = ("MY" + this.clientId + " " + this.firstName + " " + this.lastName);
        return clientDesc;

    }
    //every car has at least 1 bid, 1 bid can have only 1 client,  1 client can have many bids

    // 1. create car
    // 2. display the car and bid
    // 3. exit program
}
