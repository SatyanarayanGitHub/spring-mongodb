package org.srysoft.mongodb.example.service;

import java.util.List;
import java.util.Optional;

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

}
