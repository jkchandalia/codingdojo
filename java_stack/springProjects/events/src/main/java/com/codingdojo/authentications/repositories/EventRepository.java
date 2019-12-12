package com.codingdojo.authentications.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentications.models.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
    
    @Query("SELECT e, l, u FROM Event e JOIN e.location l JOIN e.user u WHERE l.state = ?1")
	List<Object[]> eventAndLocationByState(String state);
	
	@Query("SELECT e, l  FROM Event e JOIN e.location l JOIN e.user u WHERE l.state <> ?1")
	List<Object[]> eventAndLocationByNotState(String state);
	
	@Query("SELECT e, m  FROM Event e JOIN e.messages m WHERE e.id = ?1")
	List<Object[]> eventAndMessagesById(Long event_id);
	
}
