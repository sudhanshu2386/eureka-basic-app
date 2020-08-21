package com.ibm.drama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Artist {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String seriesName;
	@Column
	private String genre;
	@Column
	private Integer rating;

	public Artist() {
	}

	public Artist(Integer id, String seriesName, String genre, Integer rating) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.genre = genre;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", seriesName=" + seriesName + ", genre=" + genre + ", rating=" + rating + "]";
	}
}
