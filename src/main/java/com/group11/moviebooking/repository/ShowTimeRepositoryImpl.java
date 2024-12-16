package com.group11.moviebooking.repository;


import com.group11.moviebooking.entity.ShowTimeEntity;
import org.springframework.stereotype.Repository;
import com.group11.moviebooking.util.BasicImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.group11.moviebooking.util.AddShowTimeRS.addShowTimeToList;

@Repository
public class ShowTimeRepositoryImpl extends BasicImpl implements ShowTimeRepository {
    public ShowTimeRepositoryImpl() {
        super("tblshowtimes");
    }

    @Override
    public List<ShowTimeEntity> getShowTimeByMovieId(int movie_id) {
        List<ShowTimeEntity> showtimes = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tblshowtimes WHERE movie_id = ? ")
                .append("ORDER BY show_date ASC");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, movie_id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                addShowTimeToList(rs, showtimes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return showtimes;
    }

    @Override
    public List<ShowTimeEntity> getShowTimeById(int showtime_id) {
        return List.of();
    }

    @Override
    public List<ShowTimeEntity> getShowTimeByMovieAndDate(int movie_id, String show_date) {
        List<ShowTimeEntity> showtimes = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tblshowtimes WHERE movie_id = ?  AND show_date = ? ;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, movie_id);
            pre.setString(2, show_date);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                addShowTimeToList(rs, showtimes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return showtimes;
    }
    @Override
    public List<ShowTimeEntity> getShowTimesByRoom(int movie_id, String show_date, int room_id) {
        List<ShowTimeEntity> showtimes = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tblshowtimes WHERE movie_id = ? AND show_date = ? AND room_id = ? ;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setInt(1, movie_id);
            pre.setString(2, show_date);
            pre.setInt(3, room_id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                addShowTimeToList(rs, showtimes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return showtimes;
    }
}

