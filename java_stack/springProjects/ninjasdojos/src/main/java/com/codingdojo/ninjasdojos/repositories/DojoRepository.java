package com.codingdojo.ninjasdojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ninjasdojos.models.Dojo;


@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	// this method retrieves all the books from the database
    List<Dojo> findAll();
    
}
