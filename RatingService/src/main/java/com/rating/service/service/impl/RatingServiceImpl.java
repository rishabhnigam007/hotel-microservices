package com.rating.service.service.impl;

import com.rating.service.model.Rating;
import com.rating.service.repository.RatingRepositories;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepositories ratingRepositories;

    @Override
    public Rating create(Rating rating) {
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ratingRepositories.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepositories.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepositories.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepositories.findByHotelId(hotelId);
    }


}
