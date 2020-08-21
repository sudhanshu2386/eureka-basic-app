package com.ibm.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.actor.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
