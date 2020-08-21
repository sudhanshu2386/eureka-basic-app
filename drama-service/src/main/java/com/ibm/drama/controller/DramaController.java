package com.ibm.drama.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.drama.model.ActorList;
import com.ibm.drama.model.Artist;
import com.ibm.drama.model.DramaException;
import com.ibm.drama.model.RewardList;
import com.ibm.drama.service.DramaService;

@RestController
@RequestMapping("/drama")
public class DramaController {
	
	 private final Logger logger = LoggerFactory.getLogger(DramaController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	DramaService dramaService;

	@PostMapping("/persistData")
	public String save(@RequestBody Artist artist) {
		dramaService.save(artist);
		return "Artists Data saved !!";
	}

	@GetMapping("/fetchArtists")
	public List<Artist> getAll() {
		return dramaService.getAllArtists();
	}

	@GetMapping("/getArtistById/{Id}")
	public Artist getArtistById(@PathVariable("Id") Integer id) {
		if (dramaService.getArtistById(id) == null)
			throw new DramaException(500, "Artist Id{} :" + id + "is invalid");
		return dramaService.getArtistById(id);
	}
	
	@PutMapping("/updateArtistById/{Id}")
	public Artist updateActorById(@PathVariable("Id") Integer id, @Valid @RequestBody Artist artistDetails) {
		if (dramaService.getArtistById(id) == null)
			throw new DramaException(500, "Artist Id{} :" + id + "is invalid");
		Artist artist = dramaService.getArtistById(id);
		artist.setGenre(artistDetails.getGenre());
		artist.setRating(artistDetails.getRating());
		artist.setSeriesName(artistDetails.getSeriesName());
		dramaService.save(artist);
		return dramaService.getArtistById(id);
	}
	

	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		if (dramaService.getArtistById(id) == null)
			throw new DramaException(500, "Artist Id{} :" + id + "is invalid");
		dramaService.delete(id);
	}

	@GetMapping("/acts")
	@com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(fallbackMethod = "fallbackMethodForGetActor", commandKey = "test-Act", groupKey = "test-Act")
	public ActorList getActors() {
		ActorList actorList = restTemplate.getForObject("http://actor-service/actor/actorsList", ActorList.class);
		return actorList;
	}

	@GetMapping("/rwds")
	@com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(fallbackMethod = "fallbackMethodForGetReward", commandKey = "test-Rwd", groupKey = "test-Rwd")
	public RewardList getRewards() {
		RewardList rewardList = restTemplate.getForObject("http://reward-service/reward/rewardList", RewardList.class);
		return rewardList;
	}

	public ActorList fallbackMethodForGetActor() {
		return new ActorList(" Requested Actor page is under maintenance!!");
	}

	public RewardList fallbackMethodForGetReward() {
		return new RewardList("Requested Reward page is under maintenance!!");
	}
}
