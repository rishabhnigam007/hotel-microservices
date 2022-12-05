package com.hotel.service.repositories;

import com.hotel.service.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositories extends JpaRepository<Hotel, String> {
}
