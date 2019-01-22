package org.srysoft.mongodb.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.srysoft.mongodb.example.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
	
	public Book findByName(String name);

}
