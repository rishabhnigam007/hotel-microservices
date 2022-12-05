package com.hotel.service.service.impl;

import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.model.Hotel;
import com.hotel.service.repositories.HotelRepositories;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepositories hotelRepositories;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return this.hotelRepositories.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found " + id));
    }
}
