package com.example.hotelroomreservation.controller;

import com.example.hotelroomreservation.domain.Guest;
import com.example.hotelroomreservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {

        Guest guest = guestService.getGuestById(id);
        if (guest != null) {
            return ResponseEntity.ok(guest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Guest>> getGuestsByLastName(@PathVariable String lastName) {
        List<Guest> guests = guestService.getGuestsByLastName(lastName);
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/passport/{passportNumber}")
    public ResponseEntity<Guest> getGuestByPassportNumber(@PathVariable String passportNumber) {
        Guest guest = guestService.getGuestByPassportNumber(passportNumber);
        if (guest != null) {
            return ResponseEntity.ok(guest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest) {
        Guest savedGuest = guestService.saveGuest(guest);
        return ResponseEntity.ok(savedGuest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}