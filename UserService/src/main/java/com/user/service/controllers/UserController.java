package com.user.service.controllers;

import com.user.service.model.User;
import com.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createUser = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    // count retry
    int retryCount = 1;

    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        log.info("Retry count : {}",retryCount);
        retryCount++;
        User user = this.userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = this.userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    //Creating Fallback calling method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(@PathVariable("userId") String userId, Exception ex) {
        log.info("Fallback is executed because service is down : ", ex.getMessage());
        User user = User.builder()
                .userId("000")
                .name("dummy")
                .email("xyz@gmail.com")
                .about("This user is created dummy some service is down")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
