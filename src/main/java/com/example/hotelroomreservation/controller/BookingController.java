package com.example.hotelroomreservation.controller;

import com.example.hotelroomreservation.domain.Booking;
import com.example.hotelroomreservation.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/book")
    public ResponseEntity<Booking> bookRoom(@RequestBody Booking booking) {
        Booking bookedRoom = bookingService.bookRoom(booking);
        return ResponseEntity.ok(bookedRoom);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}