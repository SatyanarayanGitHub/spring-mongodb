package org.srysoft.mongodb.example.service;

import java.util.List;

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

	private HotelRepository hotelRepository;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

}
