package org.srysoft.mongodb.example.resource;

import java.util.List;

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
	

}
