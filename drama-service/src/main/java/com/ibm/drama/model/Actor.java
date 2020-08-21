package com.ibm.drama.model;

public class Actor {

	private String id;
	private String firstName;
	private String lastName;
	private String seriesName;

	public Actor() {

	}

	public Actor(String id, String firstName, String lastName, String seriesName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.seriesName = seriesName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSeriesName() {
		return seriesName;
	} 

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", seriesName=" + seriesName
				+ "]";
	}
}
