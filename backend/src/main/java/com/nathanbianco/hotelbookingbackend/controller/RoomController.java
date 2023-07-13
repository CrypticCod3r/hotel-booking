package com.nathanbianco.hotelbookingbackend.controller;

import com.nathanbianco.hotelbookingbackend.model.Room;
import com.nathanbianco.hotelbookingbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getRooms(
            @RequestParam(name = "floor", required = false) Integer floor,
            @RequestParam(name = "beds", required = false) Integer beds,
            @RequestParam(name = "maxRate", required = false) Double maxRate
    ) {
        List<Room> rooms = roomService.filterRooms(floor, beds, maxRate);
        return ResponseEntity.ok().body(rooms);
    }
}
