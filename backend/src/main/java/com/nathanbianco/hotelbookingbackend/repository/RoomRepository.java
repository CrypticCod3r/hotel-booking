package com.nathanbianco.hotelbookingbackend.repository;

import com.nathanbianco.hotelbookingbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
