package edu.monash.fit2099.clients;

/**
 * Client class represents the client in this program
 * @author lcha0068
 * @version 1.0.0
 */
public class Client {
    //instance variables(3) of client class
    /**
     * id for the client
     */
    private int clientId;
    /**
     * Client's first name
     */
    private String firstName;
    /**
     * Client's last name
     */
    private String lastName;

    // Creating two constructors with different signatures to achieve overloading

    /**
     * A constructor for client that takes in only client id
     * @param newClientId the id for the client
     */
    private Client(int newClientId){
        this.clientId = newClientId;
    }

    /**
     * Second constructor for client that takes in client id and their first name & last name
     * @param newClientId the id for the client
     * @param newFirstName the client's first name
     * @param newLastName the client's last name
     */
    private Client(int newClientId, String newFirstName, String newLastName){
        this.clientId = newClientId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }

    /**
     * Third and last constructor for client that takes in zero parameter
     * so that in the method getInstance() it can create a client instance
     * without any information and essentially gain access to the client's
     * methods such as the setters.
     */
    private Client(){}

    //Setter methods for firstname and lastname

    /**
     * A setter of firstname
     * @param firstName a string representing the client's first name
     * @return true if the length of the string is valid (between 2 and 5); false otherwise
     */
    public boolean setFirstName(String firstName) {
        boolean isValid = false;
        if ((firstName.length() >=2) && (firstName.length() <=15)){
            this.firstName = firstName;
            isValid = true;
        }
        return isValid;
    }
    /**
     * A setter of lastname
     * @param lastName a string representing the client's first name
     * @return true if the length of the string is valid (between 2 and 5); false otherwise
     */
    public boolean setLastName(String lastName) {
        boolean isValid = false;
        if ((firstName.length() >=2) && (firstName.length() <=15)){
            this.lastName = lastName;
            isValid = true;
        }
        return isValid;
    }

    /**
     * A method that display the description of the client
     * @return  a description of the client
     */
    public String description(){
        String clientDesc = ("MY" + this.clientId + " " + this.firstName + " " + this.lastName);
        return clientDesc;
    }

    /**
     * A static factory method that will check the input validity by creating an empty object (zero parameter)
     * and calling the setters which contains the validity check.
     * @param firstName the client's first name
     * @param lastName the client's last name
     * @return the client instance if it passed the validity check
     */
    public static Client getInstance(String firstName, String lastName, int clientID) {
        Client client = new Client();
        if (!(client.setFirstName(firstName) && client.setLastName(lastName)))
            client = null;
        client.clientId = clientID;
        return (client);
    }

}
