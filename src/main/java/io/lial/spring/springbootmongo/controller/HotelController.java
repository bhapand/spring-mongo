package io.lial.spring.springbootmongo.controller;

import io.lial.spring.springbootmongo.entity.Address;
import io.lial.spring.springbootmongo.entity.Hotel;
import io.lial.spring.springbootmongo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable String id) {
        return hotelRepository.findById(id).get();
    }

    @PostMapping
    public void updateHotel(@RequestBody Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @GetMapping("/prices/{maxPrice}")
    public List<Hotel> getPricePerNight(@PathVariable("maxPrice") int maxPrice) {
        return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/{city}")
    public List<Hotel> getHotelsByAddress(@PathVariable("city") String city) {
        return this.hotelRepository.findAll().stream()
                .filter(hotel -> hotel.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

    }

}
