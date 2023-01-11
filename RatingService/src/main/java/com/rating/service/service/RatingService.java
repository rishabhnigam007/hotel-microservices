package com.rating.service.service;

import com.rating.service.model.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    Rating updateRatingByRatingId(String ratingId, Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

    Rating getRatingByRatingId(String ratingId);

    Rating deleteRatingByRatingId(String ratingId);
}
