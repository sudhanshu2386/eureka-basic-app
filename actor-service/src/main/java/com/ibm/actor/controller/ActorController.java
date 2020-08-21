package com.ibm.actor.controller;

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

import com.ibm.actor.model.Actor;
import com.ibm.actor.model.ActorException;
import com.ibm.actor.model.ActorList;
import com.ibm.actor.service.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	ActorService actorService;

	@PostMapping("/persistData")
	public String save(@RequestBody Actor actor) {
		actorService.save(actor);
		return "Actors Data saved !!";
	}

	@GetMapping("/fetchActors")
	public List<Actor> getAll() {
		return actorService.getAllActors();
	}

	@GetMapping("/actorsList")
	public ActorList getActors() {
		ActorList actorList = new ActorList();
		actorList.setActorList(actorService.getAllActors());
		return actorList;
	}

	@GetMapping("/getActorById/{Id}")
	public Actor getActorById(@PathVariable("Id") Integer id) {
		if (actorService.getActorById(id) == null)
			throw new ActorException(500, "actor Id{} :" + id + "is invalid");
		return actorService.getActorById(id);
	}

	@PutMapping("/updateActorById/{Id}")
	public Actor updateActorById(@PathVariable("Id") Integer id, @Valid @RequestBody Actor actorDetails) {
		if (actorService.getActorById(id) == null)
			throw new ActorException(500, "actor Id{} :" + id + "is invalid");
		Actor actor = actorService.getActorById(id);
		actor.setFirstName(actorDetails.getFirstName());
		actor.setLastName(actorDetails.getLastName());
		actor.setSeriesName(actorDetails.getSeriesName());
		actorService.save(actor);
		return actorService.getActorById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		if (actorService.getActorById(id) == null)
			throw new ActorException(500, "actor Id{} :" + id + "is invalid");
		actorService.delete(id);
	}
}
