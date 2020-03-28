package io.lial.spring.springbootmongo.mongo;

import io.lial.spring.springbootmongo.entity.Address;
import io.lial.spring.springbootmongo.entity.Hotel;
import io.lial.spring.springbootmongo.entity.Review;
import io.lial.spring.springbootmongo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel("Marriot", 130,
                new Address("Cincinnati", "USA"),
                Arrays.asList(
                        new Review("bharat", 1, true),
                        new Review("maria", 3, false),
                        new Review("john", 2, true)));

        Hotel sheraton = new Hotel("Sheraton", 150,
                new Address("Princeton", "USA"),
                Arrays.asList(
                        new Review("bharat", 2, false),
                        new Review("maria", 7, false),
                        new Review("john", 1, true)));

        Hotel rivera = new Hotel("Rivera", 90,
                new Address("Austin", "USA"),
                Collections.emptyList());

        //drop all hotels
        this.hotelRepository.deleteAll();

        //add hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot,sheraton,rivera);
        this.hotelRepository.saveAll(hotels);
    }

}
