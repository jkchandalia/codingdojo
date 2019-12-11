package com.codingdojo.authentications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentications.models.Location;
import com.codingdojo.authentications.repositories.LocationRepository;

@Service
public class LocationService {
	private LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
	// returns all the locations
    public List<Location> allLocations() {
        return locationRepository.findAll();
    }
    
    // creates a location
    public Location createLocation(Location b) {
        return locationRepository.save(b);
    }
    // retrieves a location
	    public Location findLocation(Long id) {
	        Optional<Location> optionalLocation = locationRepository.findById(id);
	        if(optionalLocation.isPresent()) {
	            return optionalLocation.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteLocation(Long id) {
			locationRepository.deleteById(id);
			
		}
		public Location updateLocation(Location location) {	
			locationRepository.save(location);
			return null;
		}
}
