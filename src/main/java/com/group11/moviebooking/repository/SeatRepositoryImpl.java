package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.SeatEntity;
import com.group11.moviebooking.util.BasicImpl;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepositoryImpl extends BasicImpl implements SeatRepository{
    public SeatRepositoryImpl() {
        super("tblseats");
    }

    //Lấy ghế trống theo suẩt chiếu
    @Override
    public List<SeatEntity> getSoldSeats(int room_id, String show_date, String start_time, String end_time) {
        List<SeatEntity> seats = new ArrayList<SeatEntity>();
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT b.booking_id, b.showtime_id, s.seat_id, s.seat_row, s.seat_colunm, s.seat_type, s.seat_status ");
//        sql.append("FROM tblbooking_seats bs ");
//        sql.append("JOIN tblbookings b ON bs.booking_id = b.booking_id ");
//        sql.append("JOIN tblseats s ON bs.seat_id = s.seat_id ");
//        sql.append("WHERE s.seat_status IN ('reserved', 'booked') ");
//        sql.append("AND   AND b.showtime_id = ?");
//        sql.append("ORDER BY s.seat_row, s.seat_column;");

        sql.append("SELECT s.seat_id, s.seat_row, s.seat_column, s.seat_type, s.seat_status, r.room_id ");
        sql.append("FROM tblseats s ");
        sql.append("JOIN tblrooms r ON s.room_id = r.room_id ");
        sql.append("JOIN tblshowtimes st ON r.room_id = st.room_id ");
        sql.append("JOIN  tblbookings b ON st.showtime_id = b.showtime_id ");
        sql.append("JOIN tblbooking_seats bs ON b.booking_id = bs.booking_id ");
        sql.append("WHERE r.room_id = ? ");
        sql.append("AND st.show_date = ? ");
        sql.append("AND st.start_time = ? ");
        sql.append("AND bs.seat_id = s.seat_id;");

        try {
            PreparedStatement statement  = this.con.prepareStatement(sql.toString());
            statement.setInt(1, room_id);
            statement.setString(2, show_date);
            statement.setString(3, start_time);
            ResultSet rs = statement .executeQuery();
            while(rs.next()){
                SeatEntity seat = new SeatEntity();
                seat.setSeat_id(rs.getInt("seat_id"));
                seat.setRoom_id(rs.getInt("room_id"));
                seat.setSeat_row(rs.getString("seat_row"));
                seat.setSeat_column(rs.getString("seat_column"));
                seats.add(seat);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return seats;
    }

    @Override
    public boolean createSeat(int room_id, String seat_row, String seat_column) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tblseats (room_id, seat_row, seat_column, seat_status) ");
        sql.append("VALUES(?,?,?,?) ");
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, room_id);
            pre.setString(2, seat_row);
            pre.setString(3, seat_column);
            pre.setString(4, "BOOKED");

            // Thực thi câu lệnh SQL
            int rowsAffected = pre.executeUpdate();
            // Commit các thay đổi vào DB
            this.con.commit();
            if(rowsAffected > 0){
                System.out.println("Thanh cong !");
            }

            // Nếu số dòng bị ảnh hưởng > 0, tức là đã chèn thành công
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getSeatId(int room_id, String seat_row, String seat_column) {
        int seat_id = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT seat_id FROM tblseats WHERE room_id = ? AND seat_row = ? AND seat_column = ?");
        try {
            PreparedStatement statement  = this.con.prepareStatement(sql.toString());
            statement.setInt(1, room_id);
            statement.setString(2, seat_row);
            statement.setString(3, seat_column);
            ResultSet rs = statement .executeQuery();
            while(rs.next()){
                seat_id = rs.getInt("seat_id");
            }
            return seat_id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
