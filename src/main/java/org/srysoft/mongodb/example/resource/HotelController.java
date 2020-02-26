package org.srysoft.mongodb.example.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Hotel> getAllHotel() {
		return hotelService.getAllHotels();
	}

}
