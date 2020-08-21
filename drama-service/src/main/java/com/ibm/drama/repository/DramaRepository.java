package com.ibm.drama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.drama.model.Artist;

@Repository
public interface DramaRepository extends JpaRepository<Artist, Integer>{

}
