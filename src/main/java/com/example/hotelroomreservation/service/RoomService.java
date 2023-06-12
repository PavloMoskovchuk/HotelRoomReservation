package com.example.hotelroomreservation.service;

import com.example.hotelroomreservation.domain.Room;
import com.example.hotelroomreservation.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//@ComponentScan
////@RequiredArgsConstructor
//public class RoomService {
//    private final RoomRepository roomRepository;
//
//    @Autowired
//    public RoomService(RoomRepository roomRepository) {
//        this.roomRepository = roomRepository;
//    }
//
//    public List<Room> getAllRooms() {
//        return roomRepository.findAll();
//    }
//
//    public Room getRoomById(Long id) {
//        Optional<Room> optionalRoom = roomRepository.findById(id);
//        return optionalRoom.orElse(null);
//    }
//
//    public Room saveRoom(Room room) {
//        return roomRepository.save(room);
//    }
//
//    public void deleteRoom(Long id) {
//        roomRepository.deleteById(id);
//    }
//
//    public Room getRoomByNumber(int number) {
//        return roomRepository.findByNumber(number);
//    }
//}

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElse(null);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room getRoomByNumber(Long number) {
        return roomRepository.findByNumber(number);
    }
}