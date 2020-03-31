package org.srysoft.mongodb.example.resource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.srysoft.mongodb.example.model.Hotel;
import org.srysoft.mongodb.example.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private HotelService hotelService;

	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@GetMapping(value = "all")
	public List<Hotel> getAll() {
		return this.hotelService.getAllHotels();
	}

	@PutMapping
	public void insert(@RequestBody Hotel hotel) {
		this.hotelService.insertHotel(hotel);
	}

	@PostMapping
	public void update(@RequestBody Hotel hotel) {
		this.hotelService.updateHotel(hotel);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") String id) {
		this.hotelService.deleteHotel(id);
	}

	@GetMapping("/{id}")
	public Hotel getById(@PathVariable("id") String id) {
		return this.hotelService.findHotelById(id);
	}

	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {

		List<Hotel> hotels = this.hotelService.findHotelByPricePerNightLessThan(maxPrice);
		return hotels;
	}

	//Find Documents By A Field Value in a Sub-Document - Using mongoTemplate
	@GetMapping("/country/{country}")
	public List<Hotel> getHotelByCountry(@PathVariable("country") String country) {
		System.out.println("Controller...");

		List<Hotel> hotels = this.hotelService.findHotelByCountry(country);

		return hotels;
	}

	//Find Documents By A Field Value in a Sub-Document - Using HotelRepository
	@GetMapping("/address/{country}")
	public List<Hotel> getHotelFilterFromSubDocument(@PathVariable("country") String country) {
		return this.hotelService.findAllByAddressCountry(country).stream().collect(Collectors.toList());
	}

	//Find Documents By A Field Value in a Sub-Document - Using Query annotation at Repository
	@GetMapping("/custom/{country}")
	public List<Hotel> getHotelFilterFromSubDocumentQuery(@PathVariable("country") String country) {
		return this.hotelService.customHotelAddressCountry(country).stream().collect(Collectors.toList());
	}
	
	
	//Find Documents By A Field Value in an Array
	@GetMapping("/greatReviews")
	public Collection<Hotel> getHotelWithFiveReview(){
		return this.hotelService.getHotelWithFiveReview();
	}

}
