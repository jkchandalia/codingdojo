package com.codingdojo.authentications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentications.models.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{ 
	List<Task> findAll();
	
	@Query("SELECT t, c, a FROM Task t JOIN t.creator c JOIN t.assignee a WHERE t.id = ?1")
	List<Object[]> TaskCreatorAssigneeByID(Long task_id);
	
}
