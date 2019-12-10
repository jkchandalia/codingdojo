package com.codingdojo.ninjasdojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ninjasdojos.models.Dojo;
import com.codingdojo.ninjasdojos.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
	// returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    // retrieves a dojo
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteDojo(Long id) {
			dojoRepository.deleteById(id);
			
		}
		public Dojo updateDojo(Dojo dojo) {	
			dojoRepository.save(dojo);
			return null;
		}
		public List<Object[]> getAllDojosWithNinjas(){
			return dojoRepository.dojoAndNinjaJoin();
		}
		public List<Object[]> getAllDojosWithTags(){
			return dojoRepository.dojoAndTagJoin();
		}
		public List<Object[]> getAllDojosWithTagsByID(Long id){
			return dojoRepository.getDojoAndTagWhereId(id);
		}
		public List<Object[]> getAllDojosWithNinjasByID(Long id){
			return dojoRepository.getDojoAndNinjaWhereId(id);
		}
}
