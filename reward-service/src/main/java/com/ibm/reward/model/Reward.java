package com.ibm.reward.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reward {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String category;
	@Column
	private String awards;

	public Reward() {

	}

	public Reward(Integer id, String category, String awards) {
		super();
		this.id = id;
		this.category = category;
		this.awards = awards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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