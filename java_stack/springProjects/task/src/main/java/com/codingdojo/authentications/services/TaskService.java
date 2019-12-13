package com.codingdojo.authentications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentications.models.Task;
import com.codingdojo.authentications.repositories.TaskRepository;

@Service
public class TaskService {
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
	// returns all the events
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }
 // creates a task
    public Task createTask(Task b) {
        return taskRepository.save(b);
    }
    
    // retrieves a task
    public Task findTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
    }
    public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}
	public Task updateTask(Task task) {	
		taskRepository.save(task);
		return null;
	}

}
