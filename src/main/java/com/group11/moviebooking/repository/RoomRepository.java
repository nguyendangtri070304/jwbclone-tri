package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.RoomEntity;
import com.group11.moviebooking.model.RoomDTO;

import java.util.List;

public interface RoomRepository {
    int getAvailableSeats(int room_id);

    boolean updateRoom(int room_id, int new_capacity);

    boolean createRoom(String room_name, int room_capacity, int hall_id);

    boolean deleteRoom(int room_id);

    List<RoomDTO> getAllRooms();

    RoomEntity getRoomById(int room_id);

    List<RoomEntity> getRoomEntities();
}
