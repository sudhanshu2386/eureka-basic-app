package com.ibm.actor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.actor.model.Actor;
import com.ibm.actor.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	ActorRepository actorRepository;

	public void save(final Actor actor) {
		actorRepository.save(actor);
	}

	public List<Actor> getAllActors() {
		List<Actor> actors = new ArrayList<>();
		actorRepository.findAll().forEach(actor -> actors.add(actor));
		return actors;
	}

	public Actor getActorById(Integer id) {
		Optional<Actor> reward = actorRepository.findById(id);
		return reward.orElse(null);
	}

	public void delete(Integer id) {
		actorRepository.deleteById(id);
	}
}
