package com.example.hotelroomreservation.service;

import com.example.hotelroomreservation.domain.Booking;
import com.example.hotelroomreservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

//@Service
//@ComponentScan
////@RequiredArgsConstructor
//public class Schedule {
//    private final BookingRepository bookingRepository;
//
//    @Autowired
//    public Schedule(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//    @Scheduled(fixedRate = 60000)
//    public void checkExpiredBookings() {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        List<Booking> expiredBookings = bookingRepository.findByEndTimeBeforeAndRoomAvailableFalse(currentDateTime);
//        for (Booking booking : expiredBookings) {
//            booking.getRoom().setAvaliable(true);
//            bookingRepository.deleteById(booking.getId());
//        }
//    }
//}


@Component
public class Schedule {

    private final BookingRepository bookingRepository;

    @Autowired
    public Schedule(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Scheduled(fixedRate = 60000) // Перевіряти кожну хвилину
    public void checkExpiredBookings() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Booking> expiredBookings = bookingRepository.findByEndTimeBeforeAndRoomAvailableFalse(currentDateTime);
        for (Booking booking : expiredBookings) {
            booking.getRoom().setAvailable(true);
            bookingRepository.deleteById(booking.getId());
        }
    }
}