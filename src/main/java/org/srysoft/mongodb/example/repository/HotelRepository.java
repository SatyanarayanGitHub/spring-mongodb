package org.srysoft.mongodb.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.srysoft.mongodb.example.model.Hotel;

/**
 * 
 * @author SATYA
 *
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

}
