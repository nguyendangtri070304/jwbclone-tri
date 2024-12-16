package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.ShowTimeEntity;

import java.util.List;

public interface ShowTimeRepository {
    List<ShowTimeEntity> getShowTimeByMovieId(int movie_id);

    List<ShowTimeEntity> getShowTimeById(int showtime_id);

    List<ShowTimeEntity> getShowTimeByMovieAndDate(int movie_id, String show_date);

    List<ShowTimeEntity> getShowTimesByRoom(int movie_id, String show_date, int room_id);

}
