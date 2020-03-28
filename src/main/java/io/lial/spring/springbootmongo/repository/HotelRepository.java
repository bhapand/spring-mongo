package io.lial.spring.springbootmongo.repository;

import io.lial.spring.springbootmongo.entity.Address;
import io.lial.spring.springbootmongo.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    public List<Hotel> findByPricePerNightLessThan(int maxPrice);
    //public List<Hotel> findByAddress(Address address);
}
