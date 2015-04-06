package com.spring.data.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.spring.data.domain.Message;

@RepositoryRestResource(path = "message", collectionResourceRel="message")
public interface MessageRepository extends JpaRepository<Message, Long> {

}
