package com.codingdojo.authentications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentications.models.Event;
import com.codingdojo.authentications.repositories.EventRepository;

@Service
public class EventService {
	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
	// returns all the events
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }
    public List<Object[]> eventAndLocationByState(String state) {
        return eventRepository.eventAndLocationByState(state);
    }
    public List<Object[]> eventAndLocationByNotState(String state) {
        return eventRepository.eventAndLocationByNotState(state);
    }
    
    
    // creates a event
    public Event createEvent(Event b) {
        return eventRepository.save(b);
    }
    // retrieves a event
	    public Event findEvent(Long id) {
	        Optional<Event> optionalEvent = eventRepository.findById(id);
	        if(optionalEvent.isPresent()) {
	            return optionalEvent.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteEvent(Long id) {
			eventRepository.deleteById(id);
			
		}
		public Event updateEvent(Event event) {	
			eventRepository.save(event);
			return null;
		}
}
