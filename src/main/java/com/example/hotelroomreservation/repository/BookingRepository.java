package com.example.hotelroomreservation.repository;

import com.example.hotelroomreservation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByEndTimeBeforeAndRoomAvailableFalse(LocalDateTime currentDateTime);
}