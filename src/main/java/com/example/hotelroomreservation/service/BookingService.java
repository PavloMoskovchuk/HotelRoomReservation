package com.example.hotelroomreservation.service;


import com.example.hotelroomreservation.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Booking {
    private final BookingRepository bookingRepository;


}
