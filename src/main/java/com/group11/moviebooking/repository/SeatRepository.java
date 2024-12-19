package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.SeatEntity;

import java.util.List;

public interface SeatRepository {
    List<SeatEntity> getSoldSeats(int room_id, String show_date, String start_time, String end_time);

    boolean createSeat(int room_id, String seat_row, String seat_column);

    int getSeatId(int room_id, String seat_row, String seat_column);

}
