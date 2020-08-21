package com.ibm.drama.model;

import java.util.List;

public class ActorList {

	private List<Actor> actorList;

	private String message;

	public ActorList() {

	}

	public ActorList(String message) {
		this.message = message;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
