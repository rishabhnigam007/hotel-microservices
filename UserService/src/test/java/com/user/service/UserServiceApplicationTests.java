package com.user.service;

import com.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private RatingService ratingService;

    @Test
    void contextLoads() {
    }

//    @Test
//    void createRating() {
//        Rating savedRating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is using feign client").build();
//        ratingService.createRating(savedRating);
//    }
//
//    @Test
//    void deleteRating() {
//        ratingService.deleteRating("759e3c97-04f1-465a-896a-79549938ac23");
//        System.out.println("record deleted successfully!!");
//    }

//    @Test
//    void updateRating() {
//        Rating updateRating = Rating.builder().rating(10).userId("").hotelId("").feedback("this hotel is very nice").build();
//        ratingService.updateRating("53845859-15d0-455c-94d8-2a6f09691c80", updateRating);
//    }

}
