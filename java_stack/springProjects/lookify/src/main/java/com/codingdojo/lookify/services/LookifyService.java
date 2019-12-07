package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepository;


@Service
public class LookifyService {

	private LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    // returns all the lookifys
    public List<Lookify> allLookifys() {
        return lookifyRepository.findAll();
    }
    public List<Lookify> findTop10(){
    	return lookifyRepository.findTop10ByOrderByRatingDesc();
    }
    
    public List<Lookify> findByArtist(String artist){
    	return lookifyRepository.findByArtistContaining(artist);
    }
    
    // creates a lookify
    public Lookify createLookify(Lookify b) {
        return lookifyRepository.save(b);
    }
    // retrieves a lookify
	    public Lookify findLookify(Long id) {
	        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
	        if(optionalLookify.isPresent()) {
	            return optionalLookify.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteLookify(Long id) {
			lookifyRepository.deleteById(id);
			
		}
		public Lookify updateLookify(Lookify lookify) {	
			lookifyRepository.save(lookify);
			return null;
		}

}
