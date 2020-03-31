package org.srysoft.mongodb.example.service;

import java.util.Collection;
import java.util.List;

import org.srysoft.mongodb.example.model.Hotel;

/**
 * 
 * @author SATYA
 *
 */
public interface HotelService {

	public List<Hotel> getAllHotels();

	public void insertHotel(Hotel hotel);

	public void updateHotel(Hotel hotel);

	public void deleteHotel(String id);

	public Hotel findHotelById(String id);

	public List<Hotel> findHotelByPricePerNightLessThan(int max);

	public List<Hotel> findHotelByCountry(String country);

	public Collection<Hotel> findAllByAddressCountry(String country);

	public Collection<Hotel> customHotelAddressCountry(String country);

	public Collection<Hotel> getHotelWithFiveReview();

}
