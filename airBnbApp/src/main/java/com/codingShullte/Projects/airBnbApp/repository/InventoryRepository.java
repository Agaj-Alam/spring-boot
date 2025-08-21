package com.codingShullte.Projects.airBnbApp.repository;

import com.codingShullte.Projects.airBnbApp.entity.Inventory;
import com.codingShullte.Projects.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    void deleteByDateAfterAndRoom(LocalDate data, Room room);
}