package com.ibm.reward.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.reward.model.Reward;
import com.ibm.reward.repository.RewardRepository;

@Service
public class RewardService {

	@Autowired
	RewardRepository rewardRepository;

	public void save(final Reward reward) {
		rewardRepository.save(reward);
	}

	public List<Reward> getAllRewards() {
		List<Reward> rewards = new ArrayList<>();
		rewardRepository.findAll().forEach(reward -> rewards.add(reward));
		return rewards;
	}

	public Reward getRewardById(Integer id) {
		Optional<Reward> reward = rewardRepository.findById(id);
		return reward.orElse(null);
	}
	
	public void delete(Integer id) {
		rewardRepository.deleteById(id);
    }
}
