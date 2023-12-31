package com.nathanbianco.hotelbookingbackend.controller;

import com.nathanbianco.hotelbookingbackend.model.Booking;
import com.nathanbianco.hotelbookingbackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping()
    public List<Booking> getBookings() {
        return this.bookingRepository.findAll();
    }
}
