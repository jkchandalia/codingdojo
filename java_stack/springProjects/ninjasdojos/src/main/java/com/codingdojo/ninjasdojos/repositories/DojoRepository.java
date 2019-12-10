package com.codingdojo.ninjasdojos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ninjasdojos.models.Dojo;


@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	// this method retrieves all the books from the database
    List<Dojo> findAll();
    @Query("SELECT d,n FROM Dojo d JOIN d.ninjas n")
	List<Object[]> dojoAndNinjaJoin();
	@Query("SELECT d,t FROM Dojo d JOIN d.tags t")
	List<Object[]> dojoAndTagJoin();
	// passing params and filtering (still retrieves a list)
    @Query("SELECT d,t FROM Dojo d join d.tags t WHERE d.id = ?1")
    List<Object[]> getDojoAndTagWhereId(Long id);
    @Query("SELECT d,n FROM Dojo d join d.ninjas n WHERE d.id = ?1")
    List<Object[]> getDojoAndNinjaWhereId(Long id);
    
}
