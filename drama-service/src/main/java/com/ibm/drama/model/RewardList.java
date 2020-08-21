package com.ibm.drama.model;

import java.util.List;

public class RewardList {

	private List<Reward> rewardList;

	private String message;

	public RewardList() {

	}

	public RewardList(String message) {
		this.message = message;
	}

	public List<Reward> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<Reward> rewardList) {
		this.rewardList = rewardList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
