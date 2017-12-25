package edu.csula.cs3220.examples.jaxrs.models;

public class User {
    private String firstName;
    private String lastName;

    public User () {
        this.firstName = "";
        this.lastName = "";
    }

    public User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
