package com.nathanbianco.hotelbookingbackend;

import com.nathanbianco.hotelbookingbackend.model.Room;
import com.nathanbianco.hotelbookingbackend.repository.BookingRepository;
import com.nathanbianco.hotelbookingbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingBackendApplication.class, args);
	}

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void run(String... args) throws Exception {
		this.roomRepository.save(Room.builder()
				.floor(1)
				.number("101")
				.beds(1)
				.rate(99.99)
				.build());
		this.roomRepository.save(Room.builder()
				.floor(2)
				.number("201A")
				.beds(2)
				.rate(149.99)
				.build());
		this.roomRepository.save(Room.builder()
				.floor(2)
				.number("201B")
				.beds(1)
				.rate(124.99)
				.build());
	}
}
