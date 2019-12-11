package com.codingdojo.authentications.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.authentications.models.Message;
import com.codingdojo.authentications.models.User;
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findAll();
}
