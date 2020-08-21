package com.ibm.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.reward.model.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

}
