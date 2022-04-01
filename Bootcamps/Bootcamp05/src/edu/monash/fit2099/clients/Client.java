package edu.monash.fit2099.clients;

public class Client {
    //instance variables(3) of client class
    private int clientId;
    private String firstName;
    private String lastName;

    // Creating two constructors with different signatures to achieve overloading
    //First constructor
    public Client(int newClientId){
        this.clientId = newClientId;
    }

    //Second constructor
    public Client(int newClientId, String newFirstName, String newLastName){
        this.clientId = newClientId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }

    //Setter methods for firstname and lastname
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // assessor method that returns a description of the edu.monash.fit2099.clients.Client object
    public String description(){
        String clientDesc = ("MY" + this.clientId + " " + this.firstName + " " + this.lastName);
        return clientDesc;

    }

}
