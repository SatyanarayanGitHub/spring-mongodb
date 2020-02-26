package org.srysoft.mongodb.example.repository;

import java.util.List;
import java.util.Optional;

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

	public Optional<Hotel> findById(String id);

	public List<Hotel> findByPricePerNightLessThan(int max);

}
