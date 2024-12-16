package com.group11.moviebooking.convert;

import com.group11.moviebooking.entity.ShowTimeEntity;
import com.group11.moviebooking.model.ShowTimeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowTimeMapper {

    public static ShowTimeDTO mapEntityToDTO(ShowTimeEntity showtimeEntity){
        ShowTimeDTO showtimeDTO = new ShowTimeDTO();
        showtimeDTO.setShowtime_id(showtimeEntity.getShowtime_id());
        showtimeDTO.setMovie_id(showtimeEntity.getMovie_id());
        showtimeDTO.setRoom_id(showtimeEntity.getRoom_id());
        showtimeDTO.setShow_date(showtimeEntity.getShow_date());
        showtimeDTO.setStart_time(showtimeEntity.getStart_time());
        showtimeDTO.setEnd_time(showtimeEntity.getEnd_time());
        showtimeDTO.setTicket_price(showtimeEntity.getTicket_price());
        showtimeDTO.setShowtime_created_at(showtimeEntity.getShowtime_created_at());
        showtimeDTO.setShowtime_updated_at(showtimeEntity.getShowtime_updated_at());

        return showtimeDTO;
    }

    public static ShowTimeDTO mapResultSetToDTO (ResultSet rs) throws SQLException {
        ShowTimeDTO showtimeDTO = new ShowTimeDTO();
        showtimeDTO.setShowtime_id(rs.getInt("showtime_id"));
        showtimeDTO.setMovie_id(rs.getInt("movie_id"));
        showtimeDTO.setRoom_id(rs.getInt("room_id"));
        showtimeDTO.setShow_date(rs.getString("show_date"));
        showtimeDTO.setStart_time(rs.getString("start_time"));
        showtimeDTO.setEnd_time(rs.getString("end_tt"));
        showtimeDTO.setTicket_price(rs.getInt("ticket_price"));
        showtimeDTO.setShowtime_created_at(rs.getString("showtime_created_at"));
        showtimeDTO.setShowtime_updated_at(rs.getString("showtime_updated_at"));

        return showtimeDTO;
    }
}
