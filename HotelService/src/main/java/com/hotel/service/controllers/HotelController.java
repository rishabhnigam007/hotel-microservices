package com.hotel.service.controllers;

import com.hotel.service.model.Hotel;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/create")
    public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel) {

        Hotel createHotel = this.hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String hotelId) {
        Hotel hotel = this.hotelService.get(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/allhotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotelList = this.hotelService.getAllHotels();
        return ResponseEntity.ok(hotelList);
    }

}
