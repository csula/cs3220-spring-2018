package edu.csula.cs3220.examples;

public class GuestBookEntry {
	public final int id;
	public final String name;
	public final String comment;

	public GuestBookEntry (int id, String name, String comment) {
		this.id = id;
		this.name = name;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}
}
