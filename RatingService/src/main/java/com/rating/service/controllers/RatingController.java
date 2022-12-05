package com.rating.service.controllers;

import com.rating.service.model.Rating;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

        Rating createRating = this.ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
    }

    @GetMapping("/allratings")
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> ratingList = this.ratingService.getAllRating();
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> ratingList = this.ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> ratingList = this.ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingList);
    }

}
