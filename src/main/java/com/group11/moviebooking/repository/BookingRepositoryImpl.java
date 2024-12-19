package com.group11.moviebooking.repository;

import com.group11.moviebooking.util.BasicImpl;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookingRepositoryImpl extends BasicImpl implements BookingRepository{
    public BookingRepositoryImpl() {
        super("tblbookings");
    }

    @Override
    public boolean createBooking(long customer_id, int showtime_id, int total_price) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tblbookings(customer_id, showtime_id, total_price) ");
        sql.append("VALUES (?,?,?)");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setLong(1, customer_id);
            pre.setInt(2, showtime_id);
            pre.setInt(3, total_price);
            pre.executeUpdate();

            this.con.commit();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean ceateBookingSeat(int booking_id, int seat_id) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tblbooking_seats(booking_id, seat_id) ");
        sql.append("VALUES(?,?)");
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setLong(1, booking_id);
            pre.setInt(2, seat_id);
            pre.executeUpdate();

            this.con.commit();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getLastBookingId() {
        int booking_id = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT MAX(booking_id)  FROM tblbookings;");
        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                booking_id = rs.getInt(1);
            }
            return booking_id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
