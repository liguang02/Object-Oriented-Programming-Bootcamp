package edu.monash.fit2099.clients;

public class Client {
    //instance variables(3) of client class
    private int clientId;
    private String firstName;
    private String lastName;

    // Creating two constructors with different signatures to achieve overloading
    //First constructor
    private Client(int newClientId){
        this.clientId = newClientId;
    }

    //Second constructor
    private Client(int newClientId, String newFirstName, String newLastName){
        this.clientId = newClientId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }
    private Client(){}

    //Setter methods for firstname and lastname
    public boolean setFirstName(String firstName) {
        boolean isValid = false;
        if ((firstName.length() >=2) && (firstName.length() <=15)){
            this.firstName = firstName;
            isValid = true;
        }
        return isValid;
    }

    public boolean setLastName(String lastName) {
        boolean isValid = false;
        if ((firstName.length() >=2) && (firstName.length() <=15)){
            this.lastName = lastName;
            isValid = true;
        }
        return isValid;
    }

    // assessor method that returns a description of the edu.monash.fit2099.clients.Client object
    public String description(){
        String clientDesc = ("MY" + this.clientId + " " + this.firstName + " " + this.lastName);
        return clientDesc;
    }

    public static Client getInstance(String firstName, String lastName) {
        Client client = new Client();
        if (!(client.setFirstName(firstName) && client.setLastName(lastName)))
            client = null;
        return (client);
    }

}
