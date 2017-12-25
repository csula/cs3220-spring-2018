package edu.csula.cs3220.examples;

public class User {
    // Fields (beginning)
	private final String firstName;
	private final String lastName;
	// feilds (end)

	// Constructor (beginning)
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	// constructor (end)

	// Methods (beginning)
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	// methods (end)
}
