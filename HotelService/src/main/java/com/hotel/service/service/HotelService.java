package com.hotel.service.service;

import com.hotel.service.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel get(String id);
}
