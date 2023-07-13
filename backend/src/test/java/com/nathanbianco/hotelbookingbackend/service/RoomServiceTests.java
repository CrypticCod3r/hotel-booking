package com.nathanbianco.hotelbookingbackend.service;

import com.nathanbianco.hotelbookingbackend.model.Room;
import com.nathanbianco.hotelbookingbackend.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RoomServiceTests {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService uut;

    private List<Room> testRooms;

    @BeforeEach
    public void setup() {
        testRooms = getTestRooms();
        when(roomRepository.findAll()).thenReturn(testRooms);
    }

    @Test
    void filterRoomsTest_whenNoArgsProvided_thenReturnAllRooms() {
        List<Room> expectedRooms = testRooms;
		List<Room> actualRooms = uut.filterRooms(null, null, null);
		assertEquals(expectedRooms, actualRooms);
    }

    @Test
    void filterRoomsTest_whenFloorProvided_thenReturnCorrectRooms() {
        List<Room> expectedRooms = List.of(testRooms.get(1), testRooms.get(2));
        List<Room> actualRooms = uut.filterRooms(2, null, null);
        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    void filterRoomsTest_whenBedsProvided_thenReturnCorrectRooms() {
        List<Room> expectedRooms = List.of(testRooms.get(0), testRooms.get(2));
        List<Room> actualRooms = uut.filterRooms(null, 1, null);
        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    void filterRoomsTest_whenMaxRateProvided_thenReturnCorrectRooms() {
        List<Room> expectedRooms = List.of(testRooms.get(0), testRooms.get(2));
        List<Room> actualRooms = uut.filterRooms(null, null, 130.00);
        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    void filterRoomsTest_whenAllArgsProvided_thenReturnCorrectRooms() {
        List<Room> expectedRooms = List.of(testRooms.get(2));
        List<Room> actualRooms = uut.filterRooms(2, 1, 130.00);
        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    void filterRoomsTest_whenNoRoomsMatch_thenReturnEmptyList() {
        List<Room> expectedRooms = List.of();
        List<Room> actualRooms = uut.filterRooms(2, 2, 130.00);
        assertEquals(expectedRooms, actualRooms);
    }


    private List<Room> getTestRooms() {
        return List.of(
                Room.builder()
                        .floor(1)
                        .number("101")
                        .beds(1)
                        .rate(99.99)
                        .build(),
                Room.builder()
                        .floor(2)
                        .number("201A")
                        .beds(2)
                        .rate(149.99)
                        .build(),
                Room.builder()
                        .floor(2)
                        .number("201B")
                        .beds(1)
                        .rate(124.99)
                        .build()
        );
    }

}
