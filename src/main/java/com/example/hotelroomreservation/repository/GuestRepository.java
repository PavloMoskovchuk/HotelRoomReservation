package com.example.hotelroomreservation.repository;

import com.example.hotelroomreservation.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByLastName(String lastName);

    Guest findByPassportNumber(String passportNumber);

}