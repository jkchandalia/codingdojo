package com.codingdojo.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.Person;
import com.codingdojo.license.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    
    // creates a person
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    // retrieves a person
	    public Person findPerson(Long id) {
	        Optional<Person> optionalPerson = personRepository.findById(id);
	        if(optionalPerson.isPresent()) {
	            return optionalPerson.get();
	        } else {
	            return null;
	        }
	    }
		public void deletePerson(Long id) {
			personRepository.deleteById(id);
			
		}
		public Person updatePerson(Person person) {	
			personRepository.save(person);
			return null;
		}

}
