package com.nathanbianco.hotelbookingbackend.service;

import com.nathanbianco.hotelbookingbackend.model.Room;
import com.nathanbianco.hotelbookingbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> filterRooms(Integer floor, Integer beds, Double maxRate) {
        return this.roomRepository.findAll().stream()
                .filter(room -> Objects.isNull(floor) || room.getFloor() == floor)
                .filter(room -> Objects.isNull(beds) || room.getBeds() == beds)
                .filter(room -> Objects.isNull(maxRate) || room.getRate() <= maxRate)
                .toList();
    }
}
