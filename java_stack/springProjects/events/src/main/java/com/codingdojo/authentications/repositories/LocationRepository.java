package com.codingdojo.authentications.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentications.models.Location;
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findAll();
    
	Optional<Location> findByCityAndState(String city, String state);
}
