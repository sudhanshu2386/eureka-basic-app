package com.ibm.drama.model;

public class Reward {

	private String id;
	private String category;
	private String awards;

	public Reward() {

	}

	
	public Reward(String id, String category, String awards) {
		super();
		this.id = id;
		this.category = category;
		this.awards = awards;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getAwards() {
		return awards;
	}


	public void setAwards(String awards) {
		this.awards = awards;
	}


	@Override
	public String toString() {
		return "Reward [id=" + id + ", category=" + category + ", awards=" + awards + "]";
	}
}
