package com.example.hotelroomreservation.service;

import com.example.hotelroomreservation.domain.Guest;
import com.example.hotelroomreservation.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//@ComponentScan
////@RequiredArgsConstructor
//public class GuestService {
//
//    private final GuestRepository guestRepository;
//
//    @Autowired
//    public GuestService(GuestRepository guestRepository) {
//        this.guestRepository = guestRepository;
//    }
//
//    public List<Guest> getAllGuests() {
//        return guestRepository.findAll();
//    }
//
//    public Guest getGuestById(Long guestId) {
////        Optional<Guest> optionalVisitor = guestRepository.findById(guestId);
////        return optionalVisitor.orElse(null);
//
//        return guestRepository.findById(guestId).orElse(null);
//    }
//
//    public Guest saveGuest(Guest guest) {
//        return guestRepository.save(guest);
//    }
//
//    public void deleteGuest(Long id) {
//        guestRepository.deleteById(id);
//    }
//
//    public List<Guest> getGuestsByLastName(String lastName) {
//        return guestRepository.findByLastName(lastName);
//    }
//
//    public Guest getGuestByPassportNumber(String passportNumber) {
//        return guestRepository.findByPassportNumber(passportNumber);
//    }
//}

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long guestId) {
        Optional<Guest> optionalVisitor = guestRepository.findById(guestId);
        return optionalVisitor.orElse(null);
    }

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public List<Guest> getGuestsByLastName(String lastName) {
        return guestRepository.findByLastName(lastName);
    }

    public Guest getGuestByPassportNumber(String passportNumber) {
        return guestRepository.findByPassportNumber(passportNumber);
    }
}