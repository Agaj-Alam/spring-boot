package com.codingShullte.Projects.airBnbApp.repository;

import com.codingShullte.Projects.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}