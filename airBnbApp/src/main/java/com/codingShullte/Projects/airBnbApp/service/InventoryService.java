package com.codingShullte.Projects.airBnbApp.service;

import com.codingShullte.Projects.airBnbApp.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteFutureInventories(Room room);
}
