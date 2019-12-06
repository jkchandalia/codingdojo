package com.codingdojo.lookify.repositories;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	// this method retrieves all the books from the database
    List<Lookify> findAll();
    
    @PersistenceContext
    private EntityManager entityManager;
 
    @Override
    public List<Lookify> findOrderedBySeatNumberLimitedTo(int limit) {
        return entityManager.createQuery("SELECT l FROM Lookify l ORDER BY l.rating",
          Lookify.class).setMaxResults(limit).getResultList();
    }
}

