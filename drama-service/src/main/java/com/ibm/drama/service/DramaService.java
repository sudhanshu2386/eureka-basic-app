package com.ibm.drama.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.drama.model.Artist;
import com.ibm.drama.repository.DramaRepository;

@Service
public class DramaService {

	@Autowired
	DramaRepository dramaRepository;

	public void save(final Artist artist) {
		dramaRepository.save(artist);
	}

	public List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<>();
		dramaRepository.findAll().forEach(reward -> artists.add(reward));
		return artists;
	}

	public Artist getArtistById(Integer id) {
		Optional<Artist> artist = dramaRepository.findById(id);
		return artist.orElse(null);
	}

	public void delete(Integer id) {
		dramaRepository.deleteById(id);
	}
}
