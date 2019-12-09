package com.codingdojo.ninjasdojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ninjasdojos.models.Ninja;
import com.codingdojo.ninjasdojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
	// returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
    // creates a ninja
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    // retrieves a ninja
	    public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteNinja(Long id) {
			ninjaRepository.deleteById(id);
			
		}
		public Ninja updateNinja(Ninja ninja) {	
			ninjaRepository.save(ninja);
			return null;
		}
}
