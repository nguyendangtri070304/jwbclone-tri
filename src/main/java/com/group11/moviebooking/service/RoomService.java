package com.group11.moviebooking.service;

import com.group11.moviebooking.model.RoomDTO;
import com.group11.moviebooking.model.SeatDTO;
import com.group11.moviebooking.repository.RoomRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomService {
    private final RoomRepositoryImpl roomRepository;

    public RoomService(RoomRepositoryImpl roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<SeatDTO> getSeatsByRoom(int room_id) {
        List<SeatDTO> seats = new ArrayList<>();

        return seats;
    }
    public List<RoomDTO> getAllRoom(){
        return this.roomRepository.getAllRooms();
    }
}
