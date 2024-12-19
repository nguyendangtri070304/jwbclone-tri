package com.group11.moviebooking.service;


import com.group11.moviebooking.convert.SeatMapper;
import com.group11.moviebooking.entity.SeatEntity;
import com.group11.moviebooking.model.SeatDTO;
import com.group11.moviebooking.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    private SeatRepository seatRepositoryImpl;
    public SeatService(SeatRepository seatRepositoryImpl) {
        this.seatRepositoryImpl = seatRepositoryImpl;
    }

    public List<SeatDTO> getSoldSeats(int room_id, String show_date, String start_time, String end_time) {
        List<SeatEntity> seatEntities = seatRepositoryImpl.getSoldSeats(room_id, show_date, start_time, end_time);
        List<SeatDTO> seatDTOs = new ArrayList<>();
        for(SeatEntity seat : seatEntities) {
            SeatDTO seatDTO = SeatMapper.mapENtityToDTO(seat);
            seatDTOs.add(seatDTO);
        }
        return seatDTOs;
    }

    public boolean createSeat(int room_id, String seat_row, String seat_column){
        return this.seatRepositoryImpl.createSeat(room_id, seat_row, seat_column);
    }

    public int getSeatId(int room_id, String seat_row, String seat_column){
        int seat_id = seatRepositoryImpl.getSeatId(room_id, seat_row, seat_column);
        return seat_id;
    }
}
