package org.srysoft.mongodb.example.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.srysoft.mongodb.example.model.Address;
import org.srysoft.mongodb.example.model.Hotel;
import org.srysoft.mongodb.example.model.Review;
import org.srysoft.mongodb.example.repository.HotelRepository;

/**
 * 
 * @author SATYA
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	private HotelRepository hotelRepository;

	public DataLoader(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel marriot = new Hotel("Marriot", 130, new Address("Paris", "France"),
				Arrays.asList(new Review("John", 5, false), new Review("Mary", 4, true)));

		Hotel ibis = new Hotel("Ibis", 90, new Address("Bucharest", "Romania"),
				Arrays.asList(new Review("Teddy", 4, true)));

		Hotel sofitel = new Hotel("Sofitel", 200, new Address("Rome", "Italy"), new ArrayList<>());

		// drop all hotels
		this.hotelRepository.deleteAll();

		// add our hotels to the database
		List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
		this.hotelRepository.saveAll(hotels);

	}

}
