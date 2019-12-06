package com.codingdojo.language.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.language.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	// this method retrieves all the books from the database
    List<Language> findAll();
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);

}
