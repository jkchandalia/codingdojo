package com.codingdojo.ninjasdojos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ninjasdojos.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	// this method retrieves all the books from the database
    List<Tag> findAll();

	Optional<Tag> findByTag(String tag);
    
}