package com.group11.moviebooking.util;

import com.group11.moviebooking.entity.ShowTimeEntity;
import com.group11.moviebooking.model.ShowTimeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddShowTimeRS {

    public static List<ShowTimeEntity> addShowTimeToList(ResultSet rs, List<ShowTimeEntity> showtimes){
        try {
            ShowTimeEntity showtimeEntity = new ShowTimeEntity();

            showtimeEntity.setShowtime_id(rs.getInt("showtime_id"));
            showtimeEntity.setMovie_id(rs.getInt("movie_id"));
            showtimeEntity.setRoom_id(rs.getInt("room_id"));
            showtimeEntity.setShow_date(rs.getString("show_date"));
            showtimeEntity.setStart_time(rs.getString("start_time"));
            showtimeEntity.setEnd_time(rs.getString("end_time"));
            showtimeEntity.setTicket_price(rs.getInt("ticket_price"));
            showtimeEntity.setShowtime_created_at(rs.getString("showtime_created_at"));
            showtimeEntity.setShowtime_updated_at(rs.getString("showtime_updated_at"));

            showtimes.add(showtimeEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return showtimes;
    }
}
