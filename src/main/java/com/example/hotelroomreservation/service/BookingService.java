package com.example.hotelroomreservation.service;


import com.example.hotelroomreservation.domain.Booking;
import com.example.hotelroomreservation.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;


@Service
@ComponentScan
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public Booking bookRoom(Booking booking) {
        if (booking.getRoom().isAvailable()) {
            LocalDateTime endTime = LocalDateTime.now().plusMinutes(booking.getDurationMinutes());
            booking.setEndTime(endTime);
            booking.getRoom().setAvailable(false);
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Кімната вже заброньована.");
        }
    }
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            booking.getRoom().setAvailable(true);
            bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Бронювання не знайдено.");
        }
    }
}