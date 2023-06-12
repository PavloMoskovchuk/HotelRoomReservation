package com.example.hotelroomreservation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int roomNumber;

    @Column (name = "available")
    private boolean available;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
}