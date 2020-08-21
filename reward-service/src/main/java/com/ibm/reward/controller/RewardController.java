package com.ibm.reward.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.reward.model.Reward;
import com.ibm.reward.model.RewardException;
import com.ibm.reward.model.RewardList;
import com.ibm.reward.service.RewardService;

@RestController
@RequestMapping("/reward")
public class RewardController {

	@Autowired
	RewardService rewardService;

	@PostMapping("/persistData")
	public String save(@RequestBody Reward reward) {
		rewardService.save(reward);
		return "Rewards Data saved !!";
	}

	@GetMapping("/fetchRewards")
	public List<Reward> getAll() {
		return rewardService.getAllRewards();
	}

	@GetMapping("/rewardList")
	public RewardList getRewards() {
		RewardList houseList = new RewardList();
		houseList.setRewardList(rewardService.getAllRewards());
		return houseList;
	}

	@GetMapping("/getRewardById/{Id}")
	public Reward getRewardById(@PathVariable("Id") Integer id) {
		if (rewardService.getRewardById(id) == null)
			throw new RewardException(500, "Reward Id{} :" + id + "is invalid");
		return rewardService.getRewardById(id);
	}

	@PutMapping("/updateRewardById/{Id}")
	public Reward updateRewardById(@PathVariable("Id") Integer id, @Valid @RequestBody Reward rewardDetails) {
		if (rewardService.getRewardById(id) == null)
			throw new RewardException(500, "Reward Id{} :" + id + "is invalid");

		Reward reward = rewardService.getRewardById(id);
		reward.setAwards(rewardDetails.getAwards());
		reward.setCategory(rewardDetails.getCategory());
		rewardService.save(reward);
		return rewardService.getRewardById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		if (rewardService.getRewardById(id) == null)
			throw new RewardException(500, "Reward Id{} :" + id + "   is invalid");
		rewardService.delete(id);
	}
}
