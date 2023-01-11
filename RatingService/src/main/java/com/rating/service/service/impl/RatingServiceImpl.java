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
    public Rating getRatingByRatingId(String ratingId) {
        return ratingRepositories.findByRatingId(ratingId);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepositories.findByUserId(userId);
    }

    @Override
    public Rating updateRatingByRatingId(String ratingId, Rating rating) {
        Rating updateRating = ratingRepositories.findByRatingId(ratingId);
        updateRating.setRatingId(ratingId);

        //if not set anything then previous saved valued will be there
        updateRating.setRating(updateRating.getRating());
        updateRating.setFeedback(updateRating.getFeedback());
        updateRating.setUserId(updateRating.getUserId());
        updateRating.setHotelId(updateRating.getHotelId());

        // this is for new update record

        updateRating.setRating(rating.getRating());
        updateRating.setFeedback(rating.getFeedback());
        updateRating.setUserId(rating.getUserId());
        updateRating.setHotelId(rating.getHotelId());
        return ratingRepositories.save(updateRating);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepositories.findByHotelId(hotelId);
    }

    @Override
    public Rating deleteRatingByRatingId(String ratingId) {
        Rating deletedRating = ratingRepositories.findByRatingId(ratingId);
        ratingRepositories.deleteById(ratingId);
        return deletedRating;
    }
}
