package org.srysoft.mongodb.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.srysoft.mongodb.example.model.Hotel;
import org.srysoft.mongodb.example.repository.HotelRepository;

/**
 * 
 * @author SATYA
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	 @Autowired
	 private MongoTemplate mongoTemplate;
	 
	private HotelRepository hotelRepository;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return this.hotelRepository.findAll();
	}

	@Override
	public void insertHotel(Hotel hotel) {
		this.hotelRepository.insert(hotel);

	}

	@Override
	public void updateHotel(Hotel hotel) {
		this.hotelRepository.save(hotel);

	}

	@Override
	public void deleteHotel(String id) {
		this.hotelRepository.deleteById(id);
	}

	@Override
	public Hotel findHotelById(String id) {

		Optional<Hotel> hotel = this.hotelRepository.findById(id);

		if (hotel.isPresent())
			return hotel.get();
		else
			return new Hotel();
	}

	@Override
	public List<Hotel> findHotelByPricePerNightLessThan(int max) {
		return this.hotelRepository.findByPricePerNightLessThan(max);
	}

	
	@Override
	public List<Hotel> findHotelByCountry(String country) {
		System.out.println("Service call...");
		Query query = new Query();		
		query.addCriteria(Criteria.where("address.country").is(country));		
		
		List<Hotel> hotels = mongoTemplate.find(query, Hotel.class);
		
		System.out.println("hotel size : " + hotels.size());
		hotels.stream().forEach(hotel -> System.out.println(hotel));
		
		return hotels;
	}

	
}
